
# Om TodoMVC Example

Trying to complete the example started at [Om TodoMVC Example](http://github.com/swannodette/om-next-demo)

> Om is a ClojureScript UI component library over React.

> _[Om - github.com/swannodette/om](http://github.com/swannodette/om)_

## Start REPL

```
lein repl
```

## Start System
First start the repl then enter the following.
```clojure
user=> (start)
```
## Stop System
```clojure
user=> (stop)
```
_Note that a java.util.concurrent.RejectedExecutionException will be thrown. This is expected when stopping Figwheel_

## Reload System
```clojure
user=> (reset)
```
_Note that a java.util.concurrent.RejectedExecutionException will be thrown. This is expected when stopping Figwheel_

# Start Figwheel REPL
```clojure
user=> (repl)
```

# Exit Figwheel REPL
```clojure
cljs.user=>:cljs/quit
Choose focus build for CLJS REPL (dev) or quit > quit
```

