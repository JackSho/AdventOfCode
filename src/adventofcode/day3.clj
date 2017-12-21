(ns adventofcode.day3)

;; http://adventofcode.com/2017/day/3

;--- Day 3: Spiral Memory ---
;You come across an experimental new kind of memory stored on an infinite two-dimensional grid.
;
;Each square on the grid is allocated in a spiral pattern starting at a location marked 1 and then counting up while spiraling outward. For example, the first few squares are allocated like this:
;
;17  16  15  14  13
;18   5   4   3  12
;19   6   1   2  11
;20   7   8   9  10
;21  22  23---> ...
;While this is very space-efficient (no squares are skipped), requested data must be carried back to square 1 (the location of the only access port for this memory system) by programs that can only move up, down, left, or right. They always take the shortest path: the Manhattan Distance between the location of the data and square 1.
;
;For example:
;
;Data from square 1 is carried 0 steps, since it's at the access port.
;Data from square 12 is carried 3 steps, such as: down, left, left.
;Data from square 23 is carried only 2 steps: up twice.
;Data from square 1024 must be carried 31 steps.
;How many steps are required to carry the data from the square identified in your puzzle input all the way to the access port?

(defn axis-numbers
  "返回指定层（中心是0层）的坐标轴上的值，格式为：
  [right top left bottom]"
  [tier]
  (let [r-b (inc (* 2 tier))
        t-sqrt (long (java.lang.Math/pow r-b 2))]
    [(- t-sqrt tier)
     (- t-sqrt tier (* tier 2))
     (- t-sqrt tier (* tier 4))
     (- t-sqrt tier (* tier 6))]))

(defn manhattan-distance
  [number]
  (let [sqrt-of-number (java.lang.Math/sqrt number)
        t-int (long sqrt-of-number)
        t-int (if (even? t-int) (dec t-int) t-int)
        t-power (java.lang.Math/pow t-int 2)
        t-sqrt (/ (dec t-int) 2)
        tier (if (> sqrt-of-number t-int) (inc t-sqrt) t-sqrt)]
    (+ tier (apply min (map #(java.lang.Math/abs (- number %)) (axis-numbers tier))))))


;--- Part Two ---
;As a stress test on the system, the programs here clear the grid and then store the value 1 in square 1. Then, in the same allocation order as shown above, they store the sum of the values in all adjacent squares, including diagonals.
;
;So, the first few squares' values are chosen as follows:
;
;Square 1 starts with the value 1.
;Square 2 has only one adjacent filled square (with value 1), so it also stores 1.
;Square 3 has both of the above squares as neighbors and stores the sum of their values, 2.
;Square 4 has all three of the aforementioned squares as neighbors and stores the sum of their values, 4.
;Square 5 only has the first and fourth squares as neighbors, so it gets the value 5.
;Once a square is written, its value does not change. Therefore, the first few squares would receive the following values:
;
;147  142  133  122   59
;304    5    4    2   57
;330   10    1    1   54
;351   11   23   25   26
;362  747  806--->   ...
;What is the first value written that is larger than your puzzle input?

;; ver1
(defn value-of-coord
  [x y]
  (cond
    (= x y 0) 1
    (and (= x 1) (= y 0)) (value-of-coord 0 0)
    ;(and (= x 1) (= y 1)) (+ (value-of-coord 0 0) (value-of-coord 1 0))
    (and (= x 0) (= y 1)) (+ (value-of-coord 0 0) (value-of-coord 1 0) (value-of-coord 1 1))
    ;(and (= x -1) (= y 1)) (+ (value-of-coord 0 0) (value-of-coord 0 1))
    (and (= x -1) (= y 0)) (+ (value-of-coord 0 0) (value-of-coord 0 1) (value-of-coord -1 1))
    ;(and (= x -1) (= y -1)) (+ (value-of-coord 0 0) (value-of-coord -1 0))
    (and (= x 0) (= y -1)) (+ (value-of-coord 1 0) (value-of-coord 0 0) (value-of-coord -1 0) (value-of-coord -1 -1))
    ;(and (= x 1) (= y -1)) (+ (value-of-coord 1 0) (value-of-coord 0 0) (value-of-coord 0 -1))

    (zero? y) (cond (pos-int? x) (+ (value-of-coord (dec x) (inc y))
                                    (value-of-coord (dec x) y)
                                    (value-of-coord (dec x) (dec y))
                                    (value-of-coord x (dec y)))
                    (neg-int? x) (+ (value-of-coord (inc x) (dec y))
                                    (value-of-coord (inc x) y)
                                    (value-of-coord (inc x) (inc y))
                                    (value-of-coord x (inc y))))
    (zero? x) (cond (pos-int? y) (+ (value-of-coord (dec x) (dec y))
                                    (value-of-coord x (dec y))
                                    (value-of-coord (inc x) (dec y))
                                    (value-of-coord (inc x) y))
                    (neg-int? y) (+ (value-of-coord (inc x) (inc y))
                                    (value-of-coord x (inc y))
                                    (value-of-coord (dec x) (inc y))
                                    (value-of-coord (dec x) y)))
    (pos-int? x) (cond (= x (- y)) (+ (value-of-coord x (inc y))
                                      (value-of-coord (dec x) (inc y))
                                      (value-of-coord (dec x) y))
                       (= x y) (+ (value-of-coord (dec x) (dec y))
                                  (value-of-coord x (dec y)))
                       (> x y 0) (+ (value-of-coord (dec x) y)
                                    (value-of-coord (dec x) (dec y))
                                    (value-of-coord x (dec y))
                                    (if-not (= (dec x) y) (value-of-coord (dec x) (inc y)) 0))
                       (> y x 0) (+ (value-of-coord (dec x) (dec y))
                                    (value-of-coord x (dec y))
                                    (value-of-coord (inc x) (dec y))
                                    (value-of-coord (inc x) y))
                       (< y (- x) 0) (+ (value-of-coord (dec x) y)
                                        (value-of-coord (dec x) (inc y))
                                        (value-of-coord x (inc y))
                                        (if-not (= x (- y)) (value-of-coord (inc x) (inc y))))
                       (< (- x) y 0) (+ (value-of-coord (dec x) (inc y))
                                        (value-of-coord (dec x) y)
                                        (if-not (= (dec x) (- y)) (+ (value-of-coord (dec x) (dec y))
                                                                     (value-of-coord x (dec y))) 0)))
    (neg-int? x) (cond (= (- x) y) (+ (value-of-coord (inc x) y)
                                      (value-of-coord (inc x) (dec y)))
                       (= x y) (+ (value-of-coord (inc x) (inc y))
                                  (value-of-coord x (inc y)))
                       (> y (- x) 0) (+ (value-of-coord (inc x) y)
                                        (value-of-coord (inc x) (dec y))
                                        (value-of-coord x (dec y))
                                        (if-not (= (dec y) (- x)) (value-of-coord (dec x) (dec y)) 0))
                       (> (- x) y 0) (+ (value-of-coord x (inc y))
                                        (value-of-coord (inc x) (inc y))
                                        (value-of-coord (inc x) y)
                                        (value-of-coord (inc x) (dec y)))
                       (< x y 0) (+ (value-of-coord x (inc y))
                                    (value-of-coord (inc x) (inc y))
                                    (value-of-coord (inc x) y)
                                    (if-not (= (inc x) y) (value-of-coord (inc x) (dec y)) 0))
                       (< y x 0) (+ (value-of-coord (inc x) (inc y))
                                    (value-of-coord x (inc y))
                                    (value-of-coord (dec x) (inc y))
                                    (value-of-coord (dec x) y)))))

(defn corner-numbers
  [number]
  [(value-of-coord number number)
   (value-of-coord (- number) number)
   (value-of-coord (- number) (- number))
   (value-of-coord number (- number))])

(defn side-numbers
  [number direct]
  (case direct
    :right (map (fn [ind]
                  (let [x number
                        y (inc (- ind x))]
                    (value-of-coord x y))) (range (* 2 number)))
    :top (map (fn [ind]
                (let [y number
                      x (dec (- y ind))]
                  (value-of-coord x y))) (range (* 2 number)))
    :left (map (fn [ind]
                 (let [x (- number)
                       y (dec (- (+ x ind)))]
                   (value-of-coord x y))) (range (* 2 number)))
    :bottom (map (fn [ind]
                   (let [y (- number)
                         x (inc (+ y ind))]
                     (value-of-coord x y))) (range (* 2 number)))))

(defn next-larger
  [num]
  (loop [x 1]
    (let [directs (corner-numbers x)]
      (if (< (last directs) num)
        (recur (inc x))
        (let [[r t l b] directs]
          (cond
            (< num r) (first (filter #(< num %) (side-numbers x :right)))
            (< num t) (first (filter #(< num %) (side-numbers x :top)))
            (< num l) (first (filter #(< num %) (side-numbers x :left)))
            (< num b) (first (filter #(< num %) (side-numbers x :bottom)))))))))
;; ver1

;;ver2
(defn next-larger
  [number]
  (let [next-data-fn (fn [[x y] direction]
                       (case direction
                         :up [[x (inc y)] (if (= x (inc y)) :left :up)]
                         :left [[(dec x) y] (if (= (dec x) (- y)) :down :left)]
                         :down [[x (dec y)] (if (= x (dec y)) :right :down)]
                         :right [[(inc x) y] (if (= x (- y)) :up :right)]))
        data-coll (iterate
                    (fn [{:keys [history data coord] :as data-map}]
                      (let [[x y] coord
                            direction (last data)
                            cur-data (+ (get history [(inc x) y] 0)
                                        (get history [(inc x) (inc y)] 0)
                                        (get history [x (inc y)] 0)
                                        (get history [(dec x) (inc y)] 0)
                                        (get history [(dec x) y] 0)
                                        (get history [(dec x) (dec y)] 0)
                                        (get history [x (dec y)] 0)
                                        (get history [(inc x) (dec y)] 0))
                            next-data (next-data-fn coord direction)]
                        (-> (update data-map :history assoc coord cur-data)
                            (assoc :coord (first next-data))
                            (assoc :data [cur-data (last next-data)]))))
                    {:history {[0 0] 1}
                     :data    [1 :up]
                     :coord   [1 0]})]
    (loop [seq data-coll]
      (let [{:keys [data] :as s} (first seq)]
        (if (<= (first data) number)
          (recur (rest seq))
          (first data))))))
;;ver2