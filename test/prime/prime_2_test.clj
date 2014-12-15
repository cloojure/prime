(ns prime.prime-2-test
  (:use clojure.test
        prime.util
        prime.prime-2)
  (:require [criterium.core     :as crit]
            [prime.util         :as util] ))

(deftest timing
  (let [tst-fn      get-primes
        tst-size    1000
        primes  (time (tst-fn tst-size)) ]
    (is (util/all-prime? primes))
    (is (= tst-size (count primes)))
    (is (= tst-size (count (set primes))))
    (time (crit/quick-bench (tst-fn tst-size))))
  (newline) )
