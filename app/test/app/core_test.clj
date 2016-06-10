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

(deftest test-decode-modified
  (let [lst '((3 a) b (2 c) d (3 e))
        res '(a a a b c c d e e e)]
    (is (= (decode-modified lst) res))))

(deftest test-dupli
  (let [lst '(a b c c d)
        res '(a a b b c c c c d d)]
    (is (= (dupli lst) res))))

