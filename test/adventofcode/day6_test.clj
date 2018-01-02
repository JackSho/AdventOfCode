(ns adventofcode.day6-test
  (:require [clojure.test :refer :all])
  (:use [adventofcode.day6]))

;;http://adventofcode.com/2017/day/6/input

(def input "10\t3\t15\t10\t5\t15\t5\t15\t9\t2\t5\t8\t5\t2\t3\t6")

(deftest day6-test

  (testing "day6-test-part1"
    (is (= (reallocation-times "0 2 7 0") 5))
    (is (= (reallocation-times input) 14029)))

  (testing "day6-test-part2"
    (is (= (reallocation-seen-again "0 2 7 0") 4))
    (is (= (reallocation-seen-again input) 2765))))