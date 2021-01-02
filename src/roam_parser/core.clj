(ns roam-parser.core
  "This is the main class for parsing a user's Roam Research graph exported as .edn files."
  (:require
    [roam-parser.grammar :refer :all]
    [clojure.string :as str]
    [clojure.java.io :as io]
    [clojure.edn :as edn]
    [instaparse.core :as insta :refer [defparser]]
    [datascript.core :as ds :refer [data-readers]])
  (:gen-class))

(defn load-edn
  "Load edn from an io/reader source (filename or io/resource)."
  [source]
  (try
    (with-open [r (io/reader source)]
      (println "opened")
      (edn/read (java.io.PushbackReader. r) :readers :data-readers))

    (catch java.io.IOException e
      (printf "Couldn't open '%s': %s\n" source (.getMessage e)))
    (catch RuntimeException e
      (printf "Error parsing edn file '%s': %s\n" source (.getMessage e)))))

(defparser parse-roam "roam-grammar.bnf" :input-format :abnf)

(def page-parser
  (insta/parser
    "
     left=#'\\[\\['
     right=#'\\]]\\]]'
     text=#'.*'
     <S> = left, text, right
     "))

;(defparser as-and-bs " grammar.bnf " :input-format :abnf)

(def as-and-bs
  (insta/parser
    "S = AB*
     AB = A B
     A = 'a'+
     B = 'b'+"))

(defn -main
  [& args]
  (println "hellooo")
  (println (parse-roam "[[A]]"))
  )
