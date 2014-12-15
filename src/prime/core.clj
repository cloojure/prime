(ns prime.core
  (:use cooljure.core)
  (:require [prime.prime-table :as table])
  (:gen-class))

(defn print-table 
  [{:keys [primes products]}]
  {:pre [ (= (count primes) (count products) (count (first products)) ) ] }  ; ensure congruent

  ; print first row - just primes
  (newline)
  (print (format "%7s" \space))    ; blank spot in UL corner
  (doseq [elem primes]
    (print (format "%7d" elem)))   ; print primes
  (newline)

  ; print other rows
  (doseq [ii (range (count primes))
            :let [row (nth products ii)] ]
    (do (print (format "%7d" (nth primes ii)))  ; print prime
        (doseq [elem row]
          (print (format "%7d" elem))))        ; print products
    (newline))
  (newline))

(defn -main []
  (print-table (table/gen-mult-1 10))
)
