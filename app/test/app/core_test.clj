(ns app.core-test
  (:require [clojure.test :refer :all]
            [app.core :refer :all]))

(deftest test-encode
  (testing "succeed for a list."
    (is (= '(a a a a b) '((4, 'a'), (1, 'b')))) ))


;; (encode2 '(a a a a b c c a a d e e e e))
