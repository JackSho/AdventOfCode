(ns adventofcode.2017.day11
  (:require [adventofcode.2017.core :as core]))

;; http://adventofcode.com/2017/day/11

;--- Day 11: Hex Ed ---
;Crossing the bridge, you've barely reached the other side of the stream when a program comes up to you, clearly in distress. "It's my child process," she says, "he's gotten lost in an infinite grid!"
;
;Fortunately for her, you have plenty of experience with infinite grids.
;
;Unfortunately for you, it's a hex grid.
;
;The hexagons ("hexes") in this grid are aligned such that adjacent hexes can be found to the north, northeast, southeast, south, southwest, and northwest:
;
;  \ n  /
;nw +--+ ne
;  /    \
;-+      +-
;  \    /
;sw +--+ se
;  / s  \
;You have the path the child process took. Starting where he started, you need to determine the fewest number of steps required to reach him. (A "step" means to move from the hex you are in to any adjacent hex.)
;
;For example:
;
;ne,ne,ne is 3 steps away.
;ne,ne,sw,sw is 0 steps away (back where you started).
;ne,ne,s,s is 2 steps away (se,se).
;se,sw,se,sw,sw is 3 steps away (s,s,sw).

(defn move
  [[x y z] direction]
  (case direction
    "n" [x (inc y) z]
    "s" [x (dec y) z]
    "ne" [x y (dec z)]
    "sw" [x y (inc z)]
    "se" [(inc x) y z]
    "nw" [(dec x) y z]))

(defn displace
  [coord]
  (let [index (->> (map #(Math/abs %) coord)
                   (core/index-of-coll (partial apply min)))
        data  (->> (map-indexed
                     (fn [i d] ((if (= i index) - +) d (nth coord index)))
                     coord)
                   (remove zero?))]
    (if-not (empty? data)
      (->> (map #(Math/abs %) data)
           (apply (if (pos-int? (apply * data)) max +)))
      0)))

(defn fewest-steps
  [input-str]
  (->> (clojure.string/split input-str #",")
       (reduce move [0 0 0])
       (displace)))


;--- Part Two ---
;How many steps away is the furthest he ever got from his starting position?

(defn furthest-steps
  [input-str]
  (->> (clojure.string/split input-str #",")
       (reductions move [0 0 0])
       (map displace)
       (apply max)))
