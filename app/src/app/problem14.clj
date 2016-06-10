(ns app.problem14)

;; Duplicate the elements of a list.

;; (dupli '(a b c c d)) -> (A A B B C C C C D D)

;; use reduce with an accum that concatenates

;; dupli6 = foldl (\acc x -> acc ++ [x,x]) []

;; TODO: do another solution with pattern matching like +' def in core.clj

(defn dupli [coll]
  "Duplicate the elements of a list."
  (reduce #(concat %1 (repeat 2 %2)) '() coll))

(dupli '(a b c c d))
