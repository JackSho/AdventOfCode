(ns adventofcode.day10-test
  (:require [clojure.test :refer :all]
            [adventofcode.day10 :refer :all]))

;;http://adventofcode.com/2017/day/10/input

(def input "120,93,0,90,5,80,129,74,1,165,204,255,254,2,50,113")

(deftest day10-test

  (testing "day10-test-part1"
    (is (= (multiply-second 5 "3 4 1 5") 12))
    (is (= (multiply-second 256 input) 826)))

  (testing "day10-test-part2"
    (is (= (knot-hash "") "a2582a3a0e66e6e86e3812dcb672a272"))
    (is (= (knot-hash "AoC 2017") "33efeb34ea91902bb2f59c9920caa6cd"))
    (is (= (knot-hash "1,2,3") "3efbe78a8d82f29979031a4aa0b16a9d"))
    (is (= (knot-hash "1,2,4") "63960835bcdc130f0b66d7ff4f6a5a8e"))
    (is (= (knot-hash input) "d067d3f14d07e09c2e7308c3926605c4"))))