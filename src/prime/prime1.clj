(ns prime.prime1
  (:gen-class)
  (:use cooljure.core)
)

(defn is-prime-1
  [n primes-so-far]
  {:pre [(integer? n) (< 1 n)] }
  (let [upper-bound     (Math/floor (Math/sqrt (double n)))
        remainders      (map #(rem n %) primes-so-far)
        result          (not-any? zero? remainders) ]
    result ))

(defn get-primes-1
  "Returns a list of primes of the desired length"
  [num-primes-wanted]
  {:pre [(pos? num-primes-wanted)]}
  (loop [primes-so-far      [2]
         next-value         3]
    (if (<= num-primes-wanted (count primes-so-far))
      primes-so-far
      (if (is-prime-1 next-value primes-so-far)
        (recur  (conj primes-so-far next-value)  (inc next-value))
        (recur        primes-so-far              (inc next-value)) ))))

