(ns prime.prime-3
  (:use cooljure.core)
  (:gen-class))

(defn get-primes
  "Returns a list of primes of the desired length"
  [num-primes-wanted]
  {:pre [(pos? num-primes-wanted)]}
  (loop [primes-so-far      [2]
         next-value         3   ]
    (if (<= num-primes-wanted (count primes-so-far))
      primes-so-far
      (let [upper-bound     (Math/floor (Math/sqrt (double next-value)))
            divisors        (filter #(<= % upper-bound) primes-so-far)
            remainders      (map #(rem next-value %) divisors)
            is-prime        (not-any? zero? remainders) ]
        (recur  (if is-prime
                  (conj primes-so-far next-value)
                  primes-so-far)
                (+ 2 next-value))))))

