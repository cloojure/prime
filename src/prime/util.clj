(ns prime.util
  (:use cooljure.core)
  (:require [clojure.set        :as set] 
            [criterium.core     :as crit])
  (:import java.lang.Math)
  (:gen-class))


(def tst-size 1000)  ; global test size for timing tests

(defn is-prime-simple 
  "Super-simple test to see if n is prime"
  [n]
  {:pre [(integer? n) (< 1 n)] }
  (let [upper-bound     (Math/floor (Math/sqrt (double n)))
        divisors        (range 2 (inc upper-bound))
        remainders      (map #(rem n %) divisors) ]
    (not-any? zero? remainders)))

(defn all-primes 
  "Returns a lazy sequence of all primes: [2 3 5 7 11...]"
  []
  (filter is-prime-simple (iterate inc 2)))

(defn get-primes
  "Returns a list of primes of the desired length"
  [num-primes-wanted]
  {:pre [(pos? num-primes-wanted)]}
  (vec (take num-primes-wanted (all-primes))))

(defn all-prime? [coll]
  (and (map is-prime-simple coll)))
