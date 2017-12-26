(ns adventofcode.core
  (:gen-class))

(defn string->num-coll
  [string]
  (->> (re-seq #"\d" string)
       (map #(java.lang.Integer/valueOf %))))

(defn line->num-coll
  [line]
  (->> (re-seq #"\d+" line)
       (map #(java.lang.Integer/valueOf %))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
