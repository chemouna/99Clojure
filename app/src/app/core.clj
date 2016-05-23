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

;; problem 11
(defn encode-modified [coll]
  (map #( if(= (count %) > 1) (list (count %)(first %)) (identity %))  (my-pack coll)))

;; TODO: fix pb here of calculating count twice

(encode-modified '(a a a a b c c a a d e e e e))
;; TODO: solve p11 also with core.match
