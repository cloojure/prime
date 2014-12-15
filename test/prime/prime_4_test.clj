(ns prime.prime-4-test
  (:use prime.prime-4
        clojure.test)
  (:require [criterium.core     :as crit]
            [prime.util         :as util] ))

(deftest basic
  (is (= (get-primes util/tst-size) (util/get-primes util/tst-size))))

(deftest ^:perf timing
  (time (crit/bench (get-primes util/tst-size))))

