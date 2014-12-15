(ns prime.prime-table
  (:use cooljure.core)
  (:require [prime.prime-4 :as prime])
  (:gen-class))

; In this function, we do not exploit the symmetry of the table.  We assert (without
; proof) that any caching strategy (e.g. clojure.core/memoize) will consume much more than
; 1 multiply of time and more than Long.BYTES storage, per cell.
(defn gen-mult-1
  "Generate a multiplication table of prime numbers"
  [n]
  {:pre [(integer? n) (< 0 n)] }
  (let [primes      (take n (prime/all-primes))
        products    (vec    ; force to be non-lazy
                      (for [row-val primes]
                        (for [col-val primes]
                          (* row-val col-val))))
  ]
    {:primes primes  :products products} ))

