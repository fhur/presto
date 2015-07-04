(ns presto.core-test
  (:require [clojure.test :refer :all]
            [presto.core :refer :all]))

(expected-when "test-inc" inc
  :when [0] = 1
  :when [1] = 2
  :when [2] = 3
  :when [3] = 4
  :when [4] = 5
  :when [5] = 6)

(expected-when "test-*" *
 :when [1] = 1
 :when [2123] = 2123
 :when [7 2] = 14
 :when [10 10 -2 -4] = 800
 :when [] = 1)

(expected-when "test-=" =
 :when [1] = true
 :when [1 1] = true
 :when ["a" "a" "a"] = true
 :when [:foo :foo :foo :foo] = true
 :when [1 2 3] = false
 :when [1 "1"] = false)

;; You can also change the :when for a fail message
(expected-when "a test" *
  when [1 1] = 1
  when [2 3] = 6)


