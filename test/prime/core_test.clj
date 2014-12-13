(ns prime.core-test
  (:use clojure.test
        prime.core)
  (:require [clojure.set    :as set] )
  (:import java.lang.Math)
)

(defn is-prime-simple? 
  "Super-simple test to see if n is prime"
  [n]
  (let [upper-bound     (Math/floor (Math/sqrt  n))
        divisors        (range 2 (inc upper-bound))
        remainders      (map #(rem n %) divisors) ]
    (not (some zero? remainders))))

(deftest is-prime-simple?-t
  (let [primes      #{2 3 5 7 11 13 17 19 23 29}
        non-primes  (set/difference  (into #{} (range 2 30))  primes)
  ]
    (is (= 10 (count primes)))
    (is (= 18 (count non-primes)))
  )
)
