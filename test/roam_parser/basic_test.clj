(ns roam-parser.basic-test
  (:require [clojure.test :refer :all]
            [roam-parser.core :refer :all]
            [roam-parser.grammar :refer :all]))

(def a-page "[[A]]")
(def not-page "[A]")

(deftest simple-page
  (is (is-page a-page))
  (is (not (is-page not-page))))


(def a-ref "((A))")
(def not-ref "(A)")

(deftest simple-ref
  (is (is-page a-ref))
  (is (not (is-page not-ref))))