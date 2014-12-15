(ns prime.prime-table
  (:use cooljure.core)
  (:require [prime.prime-4 :as prime])
  (:gen-class))

(defn gen-mult-1
  "Generate a multiplication table of prime numbers"
  [n]
  {:pre [(integer? n) (< 1 n)] }
  (let [primes      (take n (prime/all-primes))
        products    (vec    ; force to be non-lazy
                      (for [row-val primes]
                        (for [col-val primes]
                          (* row-val col-val))))
  ]
    {:primes primes  :products products} ))

