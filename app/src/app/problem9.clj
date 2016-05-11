(ns app.problem9
  (:require [clojure.string :as s]))


(defn pack [coll]
  (map #(s/join "" %) (partition-by identity coll)))

;(map #(s/join "" %) (partition-by identity '("a", "a", "a", "b", "b", "a", "c", "c", "b", "d", "a")))
; (pack '("a", "a", "a", "b", "b", "a", "c", "c", "b", "d", "a"))

(pack '(a a a a b c c a a d e e e e))

;; TODO: solve it with core.match too




