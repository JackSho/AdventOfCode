(ns adventofcode.day15-test
  (:require [clojure.test :refer :all]
            [adventofcode.day15 :refer :all]))

;;http://adventofcode.com/2017/day/15/input

(def input-a 591)
(def input-b 393)

(deftest day15-test

  (testing "day15-test-part1"

    (is (= (match-count 2147483647 [16807 65] [48271 8921] 5)
           1))
    (is (= (match-count 2147483647 [16807 65] [48271 8921] 40000000)
           588))
    (is (= (match-count 2147483647
                        [16807 input-a]
                        [48271 input-b]
                        40000000)
           619)))

  (testing "day15-test-part2"
    (is (= (match-count2 2147483647 [16807 65] [48271 8921] 5)
           0))
    (is (= (match-count2 2147483647 [16807 65] [48271 8921] 1055)
           0))
    (is (= (match-count2 2147483647 [16807 65] [48271 8921] 1056)
           1))
    (is (= (match-count2 2147483647
                        [16807 input-a]
                        [48271 input-b]
                        5000000)
           290))))