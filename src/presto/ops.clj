(ns presto.ops)

(defn abs
  [n]
  (if (>= n 0)
    n
    (- n)))

(defn close-by
  "Returns a function that checks if the absolute difference
  between two numbers is less than or equal than difference.
  Use close-by as an operator in the expected or expected-when
  macro when testing float differences
  "
  [difference]
  (fn [a b]
    (<= (abs (- a b))
       difference)))

(def ^{:doc "Equivalent to (close-by 0)"}
  equal
  (close-by 0))


