(ns prime.core
  (:use cooljure.core)
  (:require [prime.prime-table :as table])
  (:gen-class))

(defn print-table 
  [tbl]
  {:pre [ (= (count tbl) (count (first tbl))) ] }  ; ensure square
  (doseq [row tbl]
    (doseq [elem row]
      (print (format "%10d" elem)))
    (newline)))

(defn -main []
  (print-table (table/gen-mult-1 5))
)
