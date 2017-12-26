(ns adventofcode.core
  (:gen-class))

(defn string->coll
  [re convert-fn string]
  (->> (re-seq re string)
       (map convert-fn)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
