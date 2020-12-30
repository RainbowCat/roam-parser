(ns roam-parser.basic-test
  (:require [clojure.test :refer [deftest is are]]
    ;[roam-parser.core :refer :all]
            [roam-parser.grammar :refer :all]
    ;[expectations.clojure.test :refer [expect]]
            ))

(defn check [pattern input] (not (nil? (re-matches pattern input))))

(deftest simple-bold
  (is (check BOLD "**Abc**"))
  (is (not (check BOLD "*A"))))

(deftest simple-italics
  (is (check ITALICS "__Abc__"))
  (is (not (check ITALICS "_A"))))

(deftest simple-highlight
  (is (check HIGHLIGHT "^^Abc^^"))
  (is (not (check HIGHLIGHT "^A"))))

(deftest simple-page
  (is (check PAGE "[[A]]"))
  (is (not (check PAGE "[A]"))))

(deftest simple-ref
  (is (check REF "((A))"))
  (is (not (check REF "(A)"))))

(deftest simple-alias
  (is (check ALIAS "[alias text](www.google.com)"))
  (is (check ALIAS "[alias text]([[abcdef]])"))             ;alias to a page
  (is (check ALIAS "[alias text](((abcdef)))"))             ;alias to a block reference
  (is (not (check ALIAS "[alias text](((abcdef))")))        ; missing parentheses
  (is (not (check ALIAS "[alias text(((abcdef))"))))        ; missing brackets

(deftest simple-img
  (is (check IMGS "![](https://firebasestorage.googleapis.com/v0/b/firescript-577a2.appspot.com/o/imgs%2Fapp%2Faprilsin%2FGtBI5zPC0q.png?alt=media&token=ac735fc8-ad62-4c9c-92cb-dc8084ab9031)"))
  (is (not (check IMGS "![]https://firebasestorage.googleapis.com/v0/b/firescript-577a2.appspot.com/o/imgs%2Fapp%2Faprilsin%2FGtBI5zPC0q.png?alt=media&token=ac735fc8-ad62-4c9c-92cb-dc8084ab9031)"))))