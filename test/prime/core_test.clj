(ns prime.core-test
  (:use clojure.test
        prime.core)
  (:require [clojure.set        :as set] 
            [criterium.core     :as crit])
  (:import java.lang.Math)
  (:gen-class))

