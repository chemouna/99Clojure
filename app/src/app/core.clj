(ns app.core)

;; problem 09 
(defn my-pack [lst]
  (partition-by identity lst))

;; problem 10
;; [(n, v)] -> n: nber of occurrences , v value 
(defn encode [coll]
  (map #(list (count %) (first %)) (my-pack coll)))

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
(defn decode-modified [coll]
  (reduce concat (map #(if(and (list? %) (> (count %) 1))
         (let [n (first %)
               val (second %)]
           (repeat n val))
         (list %)) coll)))

;(reduce concat '((a a a) (b b b) (c c) (d d d) (e e e)))

;(decode-modified '((3 a) (1 b) (2 c) (1 d) (3 e)))
;; lets solve this pb first

;(decode-modified '((3 a) b (2 c) d (3 e)))


;; Problem 14 

;; Duplicate the elements of a list.

;; (dupli '(a b c c d)) -> (A A B B C C C C D D)

;; use reduce with an accum that concatenates

;; dupli6 = foldl (\acc x -> acc ++ [x,x]) []

;; TODO: do another solution with pattern matching like +' def in core.clj

(defn dupli
  "Duplicate the elements of a list."
  [coll]
  (reduce #(concat %1 (repeat 2 %2)) '() coll))

(dupli '(a b c c d))




