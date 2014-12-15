(defproject prime "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [ [org.clojure/clojure      "1.6.0"]
                  [cooljure                 "0.1.18"] 
                  [criterium                "0.4.3"]
                ]
  :jvm-opts ^:replace ["-client" "-Xms3g" "-Xms7g" ]
  :global-vars { *warn-on-reflection* false }
  :main ^:skip-aot prime.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  
  :test-selectors { :default     (fn [m] (not (:perf m)))
                    :perf        :perf
                    :all         (constantly true) }
)
