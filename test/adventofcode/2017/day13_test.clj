(ns adventofcode.2017.day13-test
  (:require [clojure.test :refer :all]
            [adventofcode.2017.day13 :refer :all]))

;;http://adventofcode.com/2017/day/13/input

(def input "0: 4\n1: 2\n2: 3\n4: 5\n6: 6\n8: 4\n10: 8\n12: 6\n14: 6\n16: 8\n18: 8\n20: 6\n22: 8\n24: 9\n26: 8\n28: 8\n30: 12\n32: 12\n34: 10\n36: 12\n38: 12\n40: 10\n42: 12\n44: 12\n46: 12\n48: 12\n50: 12\n52: 14\n54: 14\n56: 12\n58: 14\n60: 14\n62: 14\n64: 17\n66: 14\n70: 14\n72: 14\n74: 14\n76: 14\n78: 18\n82: 14\n88: 18\n90: 14")

(deftest day13-test

  (testing "day13-test-part1"

    (is (= (trip-severity "0: 3\n1: 2\n4: 4\n6: 4") 24))
    (is (= (trip-severity input) 2688)))

  (testing "day13-test-part2"

    (is (= (fewest-picoseconds "0: 3\n1: 2\n4: 4\n6: 4") 10))
    (is (= (fewest-picoseconds input) 3876272))))
