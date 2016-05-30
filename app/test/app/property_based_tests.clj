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


(defspec encode-length
  10
  (prop/for-all [v (gen/such-that not-empty gen/string)]
    (= count v (reduce + (map #(first %) (encode v))))))


(gen/sample (gen/such-that not-empty gen/string))

(reduce + (map #(first %) (encode '(1))))



