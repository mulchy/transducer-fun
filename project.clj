(defproject transducers-fun "0.0.0"
  :description "Playing around with transducers"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot transducers-fun.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
