(ns app.core)

;; problem 09 
(defn my-pack [lst]
  (partition-by identity lst))

;; problem 10
;; [(n, v)] -> n: nber of occurrences , v value 
(defn encode [coll]
  (->> (my-pack coll)
       (map #(list (count %)(first %)))))

(defn encode2 [coll]
  (map #(list (count %)(first %)) (my-pack coll)))

