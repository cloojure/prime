(ns prime.util-test
  (:use clojure.test
        prime.util)
  (:require [clojure.set        :as set] 
            [criterium.core     :as crit])
  (:gen-class))
(def ns-str (ns-name *ns*))

(def primes-10 
  "First 10 primes"
  [2 3 5 7 11 13 17 19 23 29])

; Verify that is-prime-simple works correctly
(deftest is-prime-simple-t
  (let [primes      (into #{} primes-10)
        non-primes  (set/difference  (into #{} (range 2 30))  primes)
  ]
    (is (= 10 (count primes)))
    (is (= 18 (count non-primes))) ; [4 6 ... 28]
    (is (every?         is-prime-simple      primes))
    (is (not-every?     is-prime-simple  non-primes))
    (is (all-prime? primes))
    (is (all-prime? (get-primes 100)))))

(deftest basic
  (is (= primes-10 (get-primes 10)))
  (doseq [tst-size  [1 2 5 10 20 50 100 200 500 1000]]
    (do 
      (print (format " %d" tst-size))
      (let [primes (get-primes tst-size) ]
        (is (all-prime? primes))
        (is (= tst-size (count primes)))
        (is (= tst-size (count (set primes))))
        (is (= primes-10 (get-primes 10))))))
  (newline))

(deftest ^:perf timing
  (time (crit/bench (get-primes tst-size))))
