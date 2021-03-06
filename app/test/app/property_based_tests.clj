(ns app.property-based-tests
  (:require  [clojure.test :as t]
             [app.core :refer :all])
  (:require [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :as ct :refer (defspec)]))

;; test.check for encode (problem 10)

;; in haskell
;; prop_encodeLength xs = length xs == sum (map (\(x, _) -> x) $ encode xs)
;; prop_encodeFirstElement (NonEmpty xs) = head xs == snd (head (encode xs))
;; prop_encodeLastElement (NonEmpty xs) = last xs == snd (last (encode xs))

;; (defspec encode-length
;;   10
;;   (prop/for-all [v (gen/such-that not-empty gen/string)]
;;     (= count v (reduce + (map #(first %) (encode v))))))

;; (gen/sample (gen/such-that not-empty gen/string))
;; (reduce + (map #(first %) (encode '(1))))


;; prop_dupliShouldDoubleSize xs = length (dupli9 xs) == length xs * 2

(defspec duplitest
  10
  (prop/for-all [v (gen/vector gen/any)]
    (= (count (dupli v)) (* (count v) 2))))

(defspec replitest
  10
  (prop/for-all [v (gen/not-empty (gen/vector gen/int))
                 n gen/int]
    (= (count(repli v n)) (* (count v) n))))
