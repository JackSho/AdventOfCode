(ns adventofcode.day5)

;; http://adventofcode.com/2017/day/5

(defn escape-maze
  [string]
  (let [strs (mapv #(java.lang.Integer/valueOf %) (clojure.string/split-lines string))
        cnts (count strs)]
    (loop [cur-ind 0
           maze strs
           steps 0]
      (if (< cur-ind cnts)
        (recur (+ cur-ind (nth maze cur-ind)) (update maze cur-ind inc) (inc steps))
        steps))))


(defn exit-maze
  [string]
  (let [strs (mapv #(java.lang.Integer/valueOf %) (clojure.string/split-lines string))
        cnts (count strs)]
    (loop [cur-ind 0
           maze strs
           steps 0]
      (if (< cur-ind cnts)
        (let [v (nth maze cur-ind)]
          (recur (+ cur-ind v) (if (< v 3) (update maze cur-ind inc)
                                           (update maze cur-ind dec)) (inc steps)))
        steps))))