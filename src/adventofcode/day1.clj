(ns adventofcode.day1)

;; http://adventofcode.com/2017/day/1

(defn captcha
  [str]
  (if (>= 1 (count str))
    0
    (let [se (seq str)
          char->int (fn [ch] (- (long ch) (long \0)))]
      (first (reduce (fn [[num cur-ch] next-ch]
                       (if (= cur-ch next-ch)
                         [(+ num (char->int cur-ch)) next-ch]
                         [num next-ch])) [0 (last se)] se)))))



(defn captcha-half
  [s]
  (if (>= 1 (count s))
    0
    (let [half-len (/ (count s) 2)
          new-str (str s (subs s 0 (inc half-len)))
          char->int (fn [ch] (- (long ch) (long \0)))]
      (first
        (reduce
          (fn [[num index t-ch] cur-ch]
            (let [next-index (inc index)]
              [(+ num (if (= t-ch cur-ch) (char->int cur-ch) 0))
               next-index
               (nth new-str (+ next-index half-len))]))
          [0 0 (nth new-str half-len)]
          s)))))
