(ns adventofcode.2017.day17-test
  (:require [clojure.test :refer :all]
            [adventofcode.2017.day17 :refer :all]))

;;http://adventofcode.com/2017/day/17/input

(def input 335)

(deftest day17-test

  (testing "day17-test-part1"

    (is (= (short-circuit 3 2) 1))
    (is (= (short-circuit 3 4) 3))
    (is (= (short-circuit 3 6) 1))
    (is (= (short-circuit 3 8) 6))
    (is (= (short-circuit 3 9) 5))
    (is (= (short-circuit 3 2017) 638))
    (is (= (short-circuit input 2017) 1282)))

  (testing "day17-test-part2"

    (is (= (after-zero 3 1) 1))
    (is (= (after-zero 3 2) 2))
    (is (= (after-zero 3 3) 2))
    (is (= (after-zero 3 5) 5))
    (is (= (after-zero 3 9) 9))
    (is (= (after-zero input 50000000) 27650600))))
