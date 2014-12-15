(ns prime.prime-table
  (:use cooljure.core)
  (:require [prime.prime-4 :as prime])
  (:gen-class))

(defn gen-mult-1
  "Generate a multiplication table of prime numbers"
  [n]
  {:pre [(integer? n) (< 1 n)] }
  (let [primes      (take n (prime/all-primes))
        tbl-vals    (cons 1 primes)
        result      (for [row-val tbl-vals]
                      (for [col-val tbl-vals]
                        (* row-val col-val)))
  ]
    result ))

