(ns prime.prime-1
  (:use cooljure.core)
  (:gen-class))

(defn is-prime
  [n primes-so-far]
  {:pre [(integer? n) (< 1 n)] }
  (let [upper-bound     (Math/floor (Math/sqrt (double n)))
        divisors        primes-so-far
        remainders      (map #(rem n %) divisors)
        result          (not-any? zero? remainders) ]
    result ))

(defn get-primes
  "Returns a list of primes of the desired length"
  [num-primes-wanted]
  {:pre [(pos? num-primes-wanted)]}
  (loop [primes-so-far      [2]
         next-value         3   ]
    (if (<= num-primes-wanted (count primes-so-far))
      primes-so-far
      (recur  (if (is-prime next-value primes-so-far)
                (conj primes-so-far next-value)
                primes-so-far)
              (+ 2 next-value)))))

