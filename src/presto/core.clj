(ns presto.core
  (:require [clojure.test :refer :all]))

(defmacro expected
  "Simple expectation macro.
  Asserts that the operator applied to actual and expectation yields a truth result
  Example: (expected (+ 5 3) = 8)
           (expected (inc 2) = 3)"
  [actual operator expectation]
  `(testing (str "Expected " '~actual " to " '~operator " " '~expectation)
    (is (~operator ~actual
                   ~expectation))))

(defmacro expected-when
  "Creates a deftest with a group of 'expected' calls. It should
  be used to quickly test for several input cases to a given function.
  Syntax:
  (expected-when 'test-name' 'function'
    :when ['args'] 'operator' 'expectation'
    ...
    :when ['args'] 'operator' 'expectation')
  Example:
  (expected-when inc-test inc
    :when [0] = 1
    :when [1] = 2
    :when [3] = 3)"
  [test-name func & expectations]
  (let [test-name-sym (symbol test-name)]
    (concat `(deftest ~test-name-sym)
            (for [[_ args operator expected] (partition 4 expectations)]
              `(expected (apply ~func ~args) ~operator ~expected)))))


