(ns adventofcode.2017.day14-test
  (:require [clojure.test :refer :all]
            [adventofcode.2017.day14 :refer :all]))

;;http://adventofcode.com/2017/day/14/input

(def input "nbysizxe")

(deftest day14-test

  (testing "day14-test-part1"

    (is (= (used-squares "flqrgnkx") 8108))
    (is (= (used-squares input) 8216)))

  (testing "day14-test-part2"
    (is (= (squares-num "flqrgnkx") 1242))
    (is (= (squares-num input) 1139))))
