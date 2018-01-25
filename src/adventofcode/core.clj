(ns adventofcode.core
  (:gen-class))

(defn string->coll
  "字符串转换为 coll
  使用正则表达式匹配，对匹配的部分调用 convert-fn"
  [re convert-fn string]
  (->> (re-seq re string)
       (map convert-fn)))

(defn iterate-coll
  "使用给定的变换函数和初始值构造一个无限序列"
  [iterate-fn init-data]
  (iterate iterate-fn init-data))

(defn coll-offset-fn
  "返回一个序列循环移位函数"
  [offset]
  (let [select (fn [coll i _] (nth coll (mod (- i offset) (count coll))))]
    (fn [coll] (map-indexed (partial select coll) coll))))

(defn index-of-coll
  "返回某值在 coll 中的位置，该值由 coll-op-fn 求得"
  [coll-op-fn coll]
  (.indexOf coll (coll-op-fn coll)))

(defn convert-coll
  [convert-fn coll]
  (map convert-fn coll))

(defn sseq
  "返回子序列，如果要求的长度比 coll 长，则循环"
  [start length coll]
  (let [cnt (count coll)]
    (->> (range length)
         (map #(nth coll (mod (+ start %) cnt))))))

(defn merge-colls
  "合并多个序列为一个"
  [& colls]
  (reduce
    (fn [s coll]
      (let [s-len (count s)
            c-len (count coll)]
        (map #(if (< % c-len)
                (nth coll %)
                (nth s %)) (range (max s-len c-len)))))
    '()
    colls))

(defn remove-keys
  [m keyseq]
  (reduce #(dissoc %) m keyseq))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
