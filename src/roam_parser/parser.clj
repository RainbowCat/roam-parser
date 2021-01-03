(ns roam-parser.parser
  "This is the main class for parsing a user's Roam Research graph exported as .edn files."
  (:require
    [clojure.string :as str]
    [clojure.java.io :as io]
    [clojure.edn :as edn]
    [instaparse.core :as insta :refer [defparser transform]]
    [datascript.core :as ds :refer [data-readers]])
  (:gen-class))

(insta/set-default-input-format! :abnf)
(binding [instaparse.abnf/*case-insensitive* false])

(defparser parser (.getFile (io/resource "grammar.bnf")))

(def transform-options
  {:VCHAR identity
   :text  str
   :page  identity
   :ref   identity
   :query identity})

(defn parse [input]
  ;(parser input))
  (->> (parser input) (insta/transform transform-options)))
