(ns prime.prime-4
  (:use cooljure.core)
  (:gen-class))

(defn is-prime
  [n primes-so-far]
  {:pre [(integer? n) (< 1 n)] }
  (let [upper-bound     (Math/floor (Math/sqrt (double n)))
        divisors        (filter #(<= % upper-bound) primes-so-far)
        remainders      (map #(rem n %) divisors)
        result          (not-any? zero? remainders) ]
    result ))

(defn all-primes*
  [newest-prime     ; the most recently found (largest) prime
   primes-so-far]   ; list of all primes found so far incl newest-prime
  ; We must find the next time before we can call the next element in the lazy seq
  (loop [primes-so-far    primes-so-far
         next-value       (+ 2  newest-prime) ]
    (if (is-prime next-value primes-so-far)
      (cons newest-prime
            (lazy-seq 
                (all-primes* next-value (conj primes-so-far next-value))))
      (recur primes-so-far (+ 2 next-value)))))

(defn all-primes
  "Returns an infinite lazy sequence of primes generated using the sieve of Eratosthenes."
  []
  ; Note that all-primes* increments by 2 so as to examine only odd numbers.  Therefore,
  ; we must start the iteration at 3 (or any other odd prime).
  (cons 2 (all-primes* 3 [2 3] )))

(defn get-primes
  "Returns a list of primes of the desired length"
  [num-primes-wanted]
  {:pre [(pos? num-primes-wanted)]}
  (vec (take num-primes-wanted (all-primes))))
