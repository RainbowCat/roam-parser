(ns roam-parser.core
  "This is the main class for parsing a user's Roam Research graph exported as .edn files."
  (:require
    [roam-parser.grammar :refer :all]
    [clojure.string :as str]
    [instaparse.core :as insta]
    )
  (:gen-class))

(def as-and-bs
  (insta/parser
    "S = AB*
     AB = A B
     A = 'a'+
     B = 'b'+"))

(defn -main
  [& args]
  (println (as-and-bs "aaaaabbbaaaabb"))
  ;(println BOLD)
  (println "hellooo"))
