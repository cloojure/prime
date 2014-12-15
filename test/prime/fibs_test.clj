(ns prime.fibs-test
  (:use clojure.test
        prime.util)
  (:require [criterium.core     :as crit])
  (:gen-class))
(def ns-str (ns-name *ns*))

; Verify that is-prime-simple works correctly
(deftest is-prime-simple-t
  (println ns-str))
