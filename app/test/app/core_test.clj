(ns app.core-test
  (:require [clojure.test :refer :all]
            [app.core :refer :all]))

;; (deftest test-encode
;;   (testing "succeed for a list."
;;     (is (= '(a a a a b) '((4, 'a'), (1, 'b')))) ))


(deftest test-encode-modified
  (let [lst '(a a a b c c d e e e)
        ecd '((3 a) b (2 c) d (3 e))]
    (is (= (encode-modified lst) ecd))))

(deftest test-encode-modified2
  (let [lst '(a a a b c c d e e e)
        ecd '((3 a) b (2 c) d (3 e))]
    (is (= (encode-modified2 lst) ecd))))

(deftest test-encode-modified3
  (let [lst '(a a a b c c d e e e)
        ecd '((3 a) b (2 c) d (3 e))]
    (is (= (encode-modified3 lst) ecd))))


