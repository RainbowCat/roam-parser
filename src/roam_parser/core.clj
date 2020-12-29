(ns roam-parser.core
  "This is the main class for parsing a user's Roam Research graph exported as .edn files."
  (:require
    [roam-parser.grammar :refer :all]
    [clojure.string :as str]
    ; [instaparse.core :as insta]
    )
  (:gen-class))

(defn -main
  [& args]
  (println BOLD)
  (println "hellooo"))
