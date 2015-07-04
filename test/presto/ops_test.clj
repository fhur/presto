(ns presto.ops-test
  (:require [clojure.test :refer :all]
            [presto.core :refer :all]
            [presto.ops :refer :all]))

(expected-when "equal should test that difference is 0" equal
  :when [0 0] = true
  :when [0.0 0] = true
  :when [0 0.0] = true
  :when [0.0 0.0] = true
  :when [2.0 2] = true
  :when [123.654 123.654] = true
  :when [1234 1234.0] = true
  :when [1234N 1234] = true
  :when [1234N 1234.0] = true)

(expected-when "close-by 1 should accept differences of 1" (close-by 1)
  :when [0 0] = true
  :when [0 0.1] = true
  :when [0 0.5] = true
  :when [0 1] = true
  :when [0 2] = false
  :when [0 3] = false)




