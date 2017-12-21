(ns adventofcode.day3-test
  (:require [clojure.test :refer :all])
  (:use [adventofcode.day3]))

;;http://adventofcode.com/2017/day/3/input

(deftest day3-test

  (def input 347991)

  (testing "day3-test-part1"
    (is (= (manhattan-distance 1) 0))
    (is (= (manhattan-distance 12) 3))
    (is (= (manhattan-distance 23) 2))
    (is (= (manhattan-distance input) 480)))

  (testing "day3-test-part2"
    (is (= (next-larger input) 349975))))