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

;; solution 11
(defn encode-modified [coll]
  (let [lst (map #(list (count %)(first %)) (my-pack coll)) ]
    (map #(if (= (first %) 1)
            (second %)
            %) lst)))

;; sol with a simpler let
(defn encode-modified2 [coll]
  (map #(let [n (count %)
               val (first %)]
           (if(= n 1) val (list n val))) (my-pack coll)))


;; TODO: fix pb here of calculating count twice

(encode-modified '(a a a a b c c a a d e e e e))
;; TODO: solve p11 also with core.match
