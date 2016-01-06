(ns user
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.pprint :refer (pprint)]
            [clojure.repl :refer :all]
            [clojure.test :as test]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]
            [figwheel-sidecar.repl-api :as ra]
            [com.stuartsierra.component :as component]
            [todomvc.system :as system]))

(def figwheel-config
  {:figwheel-options {}
   :build-ids ["dev"]
   :all-builds
                     [{:id "dev"
                       :figwheel true
                       :source-paths ["src/cljs"]
                       :compiler {:main 'todomvc.core
                                  :asset-path "/js"
                                  :output-to "resources/public/js/app.js"
                                  :output-dir "resources/public/js"
                                  :optimizations :none
                                  :static-fns true
                                  :optimize-constants true
                                  :pretty-print true
                                  :externs ["src/js/externs.js"]
                                  :closure-defines '{goog.DEBUG true}
                                  :verbose true}}]})

(def server-config {:db-uri "datomic:mem://localhost:4334/todos"
                    :web-port 8081})

(defrecord Figwheel []
  component/Lifecycle
  (start [config]
    (ra/start-figwheel! config)
    config)
  (stop [config]
    (ra/stop-figwheel!)
    config))

(def sys
  (atom
    (component/system-map
      :figwheel (map->Figwheel figwheel-config)
      :app-server (system/dev-system server-config))))

(defn start []
  (swap! sys component/start))

(defn stop []
  (swap! sys component/stop))

(defn reset []
  (stop)
  (refresh :after 'user/start))

(defn repl []
  (ra/cljs-repl))
