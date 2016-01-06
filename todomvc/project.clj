(defproject om-next-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :jvm-opts ^:replace ["-Xms512m" "-Xmx512m" "-server"]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [com.datomic/datomic-free "0.9.5206" :exclusions [joda-time]]
                 [bidi "1.20.3"]
                 [org.omcljs/om "1.0.0-alpha28"]
                 [ring/ring "1.4.0"]
                 [com.cognitect/transit-clj "0.8.281"]
                 [com.cognitect/transit-cljs "0.8.225"]
                 [com.stuartsierra/component "0.2.3"]
                 [figwheel-sidecar "0.5.0-SNAPSHOT" :scope "test"]]

  :source-paths ["src/clj" "src/cljs" "src/dev"]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.3"]
                                  [org.clojure/java.classpath "0.2.0"]]}})
