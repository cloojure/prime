(ns prime.core-test
  (:use clojure.test
        prime.core
        prime.core-test)
  (:require [clojure.set    :as set] )
  (:import java.lang.Math)
)

(defn is-prime-simple? 
  "Super-simple test to see if n is prime"
  [n]
  {:pre [(integer? n) (< 1 n)] }
  (let [upper-bound     (Math/floor (Math/sqrt n))
        divisors        (range 2 (inc upper-bound))
        remainders      (map #(rem n %) divisors) ]
    (not (some zero? remainders))))

; Verify that is-prime-simple? works correctly
(deftest is-prime-simple?-t
  (let [primes      #{2 3 5 7 11 13 17 19 23 29}
        non-primes  (set/difference  (into #{} (range 2 30))  primes)
  ]
    (is (= 10 (count primes)))
    (is (= 18 (count non-primes)))      ; [4 6 ... 28]
    (is (every?         is-prime-simple?     primes))
    (is (not-every?     is-prime-simple? non-primes))
  ))

(def simple-primes-4
  "All primes less than 10^4"
  (filter is-prime-simple? (range 2 10000)))
(println "simple-primes-4:" (take 99 simple-primes-4) "..." (take-last 3 simple-primes-4))

