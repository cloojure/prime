(ns prime.prime-1-test
  (:use clojure.test
        prime.prime-1)
  (:require [criterium.core     :as crit]
            [prime.util         :as util] ))

(deftest basic
  (is (= (get-primes util/tst-size) (util/get-primes util/tst-size))))

(deftest ^:perf timing
  (time (crit/quick-bench (get-primes util/tst-size))))

