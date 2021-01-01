(ns roam-parser.core
  "This is the main class for parsing a user's Roam Research graph exported as .edn files."
  (:require
    [roam-parser.grammar :refer :all]
    [clojure.string :as str]
    [instaparse.core :as insta :refer [defparser]]
    )
  (:gen-class))

(defparser as-and-bs "grammar.bnf" :input-format :abnf)

(defn -main
  [& args]
  ;(clojure.java.io/resource "grammar.bnf")
  (println (as-and-bs "aaaaabbbaaaabb"))
  ;(println BOLD)
  (println "hellooo"))
