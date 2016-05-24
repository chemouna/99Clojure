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


;; problem 12

                                        ; consumes stack...
(defn my-flatten [x]
  (reduce
   (fn [acc e]
     (if (list? e)
       (concat acc (my-flatten e))
       (concat acc (list e)))
     )
   '()
   x
   ))

(defn decode-modified [coll]
  (my-flatten (map #(if(and (list? %) (> (count %) 1))
         (let [n (first %)
               val (second %)]
           (repeat n val))
         (list %)) coll)))


(my-flatten '((a a a) (b b b) (c c) (d d d) (e e e))

(decode-modified '((3 a) (1 b) (2 c) (1 d) (3 e)))
;; lets solve this pb first

(decode-modified '((3 a) b (2 c) d (3 e)))



