(ns adventofcode.2017.day16
  (:require [adventofcode.2017.core :as core]))

;; http://adventofcode.com/2017/day/16

;--- Day 16: Permutation Promenade ---
;You come upon a very unusual sight; a group of programs here appear to be dancing.
;
;There are sixteen programs in total, named a through p. They start by standing in a line: a stands in position 0, b stands in position 1, and so on until p, which stands in position 15.
;
;The programs' dance consists of a sequence of dance moves:
;
;Spin, written sX, makes X programs move from the end to the front, but maintain their order otherwise. (For example, s3 on abcde produces cdeab).
;Exchange, written xA/B, makes the programs at positions A and B swap places.
;Partner, written pA/B, makes the programs named A and B swap places.
;For example, with only five programs standing in a line (abcde), they could do the following dance:
;
;s1, a spin of size 1: eabcd.
;x3/4, swapping the last two programs: eabdc.
;pe/b, swapping programs e and b: baedc.
;After finishing their dance, the programs end up in order baedc.
;
;You watch the dance for a while and record their dance moves (your puzzle input). In what order are the programs standing after their dance?

(defn spin
  [move]
  (fn [programs]
    (let [cnt (count programs)]
      (core/sseq (- cnt move)
                 cnt
                 programs))))

(defn exchange
  [m1 m2]
  (fn [programs]
    (map-indexed
      (fn [i p]
        (cond
          (= i m1) (nth programs m2)
          (= i m2) (nth programs m1)
          :default p))
      programs)))

(defn partner
  [m1 m2]
  (fn [programs]
    (map (fn [p]
           (cond
             (= p m1) m2
             (= p m2) m1
             :default p))
         programs)))

(defn dance-move
  [moves]
  (let [sub-moves (subs moves 1)]
    (case (first moves)
      \s (spin (Integer/valueOf sub-moves))
      \x (->> (core/string->numbers #"\d+" sub-moves)
              (apply exchange))
      \p (->> (remove #{\/} sub-moves)
              (apply partner)))))

(defn dance
  [programs moves-str]
  (->> (clojure.string/split moves-str #",")
       (map dance-move)
       (reduce #(%2 %1) programs)
       (apply str)))


;--- Part Two ---
;Now that you're starting to get a feel for the dance moves, you turn your attention to the dance as a whole.
;
;Keeping the positions they ended up in from their previous dance, the programs perform it again and again: including the first dance, a total of one billion (1000000000) times.
;
;In the example above, their second dance would begin with the order baedc, and use the same dance moves:
;
;s1, a spin of size 1: cbaed.
;x3/4, swapping the last two programs: cbade.
;pe/b, swapping programs e and b: ceadb.
;In what order are the programs standing after their billion dances?

(defn circul-dance
  [programs moves-str circle]
  (let [programs (map identity programs)]
    (let [move-seq (->> (clojure.string/split moves-str #",")
                        (map dance-move)
                        (repeat circle)
                        (apply concat))
          cycles   (reduce (fn [[cnt p] f]
                             (let [ret (f p)
                                   cnt (inc cnt)]
                               (if (= programs ret)
                                 (reduced cnt)
                                 [cnt ret])))
                           [0 programs] move-seq)]
      (if (coll? cycles)
        (apply str (second cycles))
        (->> move-seq
             (take (mod circle cycles))
             (reduce #(%2 %1) programs)
             (apply str))))))
