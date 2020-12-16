(ns adventofcode.2017.day3-test
  (:require [clojure.test :refer :all])
  (:use [adventofcode.2017.day3]))

;;http://adventofcode.com/2017/day/3/input

(def input 347991)

(deftest day3-test

  (testing "day3-test-part1"
    (is (= (manhattan-distance 1) 0))
    (is (= (manhattan-distance 12) 3))
    (is (= (manhattan-distance 23) 2))
    (is (= (manhattan-distance input) 480)))

  (testing "day3-test-part2"
    (is (= (next-larger 2) 4))
    (is (= (next-larger 10) 11))
    (is (= (next-larger 100) 122))
    (is (= (next-larger 300) 304))
    (is (= (next-larger input) 349975))))
