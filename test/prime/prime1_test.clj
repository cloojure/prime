(ns prime.prime1-test
  (:use prime.prime1
        clojure.test
        prime.core-test)
  (:require [clojure.set    :as set] )
  (:import java.lang.Math)
)

(deftest get-primes-1-t
  (println (get-primes-1 10))
)
