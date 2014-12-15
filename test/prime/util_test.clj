(ns prime.util-test
  (:use clojure.test
        prime.util)
  (:require [clojure.set        :as set] 
            [criterium.core     :as crit])
  (:gen-class))
(def ns-str (ns-name *ns*))

; Verify that is-prime-simple works correctly
(deftest is-prime-simple-t
  (let [primes      #{2 3 5 7 11 13 17 19 23 29}
        non-primes  (set/difference  (into #{} (range 2 30))  primes)
  ]
    (is (= 10 (count primes)))
    (is (= 18 (count non-primes))) ; [4 6 ... 28]
    (is (every?         is-prime-simple      primes))
    (is (not-every?     is-prime-simple  non-primes))
    (is (all-prime? primes))
    (is (all-prime? (get-primes-simple 100)))
  ))

(deftest timing
  (let [tst-fn      get-primes-simple
        tst-size    1000
        primes  (time (tst-fn tst-size)) ]
    (is (all-prime? primes))
    (is (= tst-size (count primes)))
    (is (= tst-size (count (set primes))))
    (time (crit/quick-bench (tst-fn tst-size))))
  (newline) )

#_(deftest timing-lazy-demo
  (newline)
  (println "-----------------------------------------------------------------------------")
  (println "timing-lazy-demo 1:")
  (crit/quick-bench (filter odd? (range 1e4)))

  (println "timing-lazy-demo 2:")
  (crit/quick-bench (vec (filter odd? (range 1e4))))

  (newline) )
