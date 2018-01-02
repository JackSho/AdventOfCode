(ns adventofcode.core
  (:gen-class))

(defn string->coll
  [re convert-fn string]
  (->> (re-seq re string)
       (map convert-fn)))

(defn iterate-coll
  [iterate-fn init-data]
  (iterate iterate-fn init-data))

(defn coll-offset-fn
  [offset]
  (fn [coll]
    (map-indexed
      (fn [i _] (nth coll (mod (- i offset) (count coll))))
      coll)))

(defn index-of-coll
  [coll-op-fn coll]
  (.indexOf coll (coll-op-fn coll)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
