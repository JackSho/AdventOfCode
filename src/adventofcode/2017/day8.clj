(ns adventofcode.2017.day8
  (:require [adventofcode.2017.core :as core]))

;; http://adventofcode.com/2017/day/8

;--- Day 8: I Heard You Like Registers ---
;You receive a signal directly from the CPU. Because of your recent assistance with jump instructions, it would like you to compute the result of a series of unusual register instructions.
;
;Each instruction consists of several parts: the register to modify, whether to increase or decrease that register's value, the amount by which to increase or decrease it, and a condition. If the condition fails, skip the instruction without modifying the register. The registers all start at 0. The instructions look like this:
;
;b inc 5 if a > 1
;a inc 1 if b < 5
;c dec -10 if a >= 1
;c inc -20 if c == 10
;These instructions would be processed as follows:
;
;Because a starts at 0, it is not greater than 1, and so b is not modified.
;a is increased by 1 (to 1) because b is less than 5 (it is 0).
;c is decreased by -10 (to 10) because a is now greater than or equal to 1 (it is 1).
;c is increased by -20 (to -10) because c is equal to 10.
;After this process, the largest value in any register is 1.
;
;You might also encounter <= (less than or equal to) or != (not equal to). However, the CPU doesn't have the bandwidth to tell you what all the registers are named, and leaves that to you to determine.
;
;What is the largest value in any register after completing the instructions in your puzzle input?

(defn cond-pred-fn
  [op cond-reg cond-num]
  (fn [data-map]
    (op (get data-map cond-reg 0) cond-num)))

(defn parse-instruct-line
  "将一行指令字符串解析成一条指令"
  [line]
  (let [vs        (clojure.string/split line #"\s")
        register  (symbol (nth vs 0))
        delta     (Integer/valueOf (nth vs 2))
        op-fn     (fn [op data-map]
                    (update data-map register #(op (or % 0) delta)))
        update-fn (case (nth vs 1)
                    "dec" (partial op-fn -)
                    "inc" (partial op-fn +))
        cond-num  (Integer/valueOf (nth vs 6))
        cond-reg  (symbol (nth vs 4))
        cond-fn   (case (nth vs 5)
                    "!=" (cond-pred-fn not= cond-reg cond-num)
                    ">=" (cond-pred-fn >= cond-reg cond-num)
                    "<=" (cond-pred-fn <= cond-reg cond-num)
                    "==" (cond-pred-fn = cond-reg cond-num)
                    ">" (cond-pred-fn > cond-reg cond-num)
                    "<" (cond-pred-fn < cond-reg cond-num))]
    {:update-fn update-fn
     :cond-fn   cond-fn}))

(defn exec-instruct
  [data-map {:keys [update-fn cond-fn]}]
  (if (cond-fn data-map)
    (update-fn data-map)
    data-map))

(defn largest-register
  [str]
  (->> (clojure.string/split-lines str)
       (map parse-instruct-line)
       (reduce exec-instruct {})
       (vals)
       (apply max)))


;--- Part Two ---
;To be safe, the CPU also needs to know the highest value held in any register during this process so that it can decide how much memory to allocate to these operations. For example, in the above instructions, the highest value ever held was 10 (in register c after the third instruction was evaluated).

(defn largest-history
  [str]
  (->> (clojure.string/split-lines str)
       (map parse-instruct-line)
       (reductions exec-instruct {})
       (mapcat vals)
       (apply max)))
