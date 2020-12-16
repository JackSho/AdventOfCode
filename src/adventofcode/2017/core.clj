(ns adventofcode.2017.core)

(defn string->coll
  "字符串转换为 coll
  使用正则表达式匹配，对匹配的部分调用 convert-fn"
  ([re string]
   (string->coll re str string))
  ([re convert-fn string]
   (->> (re-seq re string)
        (map convert-fn))))

(defn string->numbers
  "字符串转换为整数集合"
  ([string]
   (string->numbers #"\d" string))
  ([re string]
   (string->coll re #(Integer/valueOf %) string)))

(defn coll-offset-fn
  "返回一个序列循环移位函数"
  [offset]
  (let [select (fn [coll i _] (nth coll (mod (- i offset) (count coll))))]
    (fn [coll] (map-indexed (partial select coll) coll))))

(defn index-of-coll
  "返回某值在 coll 中的位置，该值由 coll-op-fn 求得"
  [coll-op-fn coll]
  (.indexOf coll (coll-op-fn coll)))

(defn sseq
  "返回子序列，如果要求的长度比 coll 长，则循环"
  [start length coll]
  (let [cycle-coll (cycle coll)]
    (->> (range length)
         (map #(nth cycle-coll (+ start %))))))

(defn merge-colls
  "合并多个序列为一个"
  [& colls]
  (reduce
    (fn [s coll]
      (let [s-len (count s)
            c-len (count coll)]
        (map #(if (< % c-len)
                (nth coll %)
                (nth s %))
             (range (max s-len c-len)))))
    '()
    colls))

(defn merge-colls-with
  [f & colls]
  (reduce
    (fn [s coll]
      (let [s-len (count s)
            c-len (count coll)]
        (map #(if (< % c-len)
                (nth coll %)
                (nth s %))
             (range (max s-len c-len)))))
    '()
    colls))

(defn remove-keys
  [m keyseq]
  (apply dissoc m keyseq))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
