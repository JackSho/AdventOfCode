(ns adventofcode.core
  (:gen-class))

(defn string->num-seq
  [string]
  (->> (re-seq #"\d" string)
       (map #(java.lang.Integer/valueOf %))))

(defn line->num-coll
  [line]
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
