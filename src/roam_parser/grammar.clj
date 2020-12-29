(ns roam-parser.grammar
  "Defines all Roam Research grammar."
  (:require [clojure.string :as str])
  (:gen-class)
  (:import [java.util Vector]))

;;; HELPER
(defn mk-gmr
  [lst]
  (assert (vector? lst) (type lst))
  ;(println lst)
  ;(println (eval lst))
  (re-pattern (str/join (eval lst))))

;;; Grammar Definitions
(def ANY ".*")
(def URLS ".*")                                   ;TODO

(def BOLD (mk-gmr ["\\*\\*" 'ANY "\\*\\*"]))
(def HIGHLIGHT (mk-gmr ["\\^\\^" 'ANY "\\^\\^"]))
(def ITALICS (mk-gmr ["__" 'ANY "__"]))

(def PAGE (mk-gmr ["\\[\\[" 'ANY "\\]\\]"]))
(def REF (mk-gmr ["\\(\\(" 'ANY "\\)\\)"]))
(def ALIAS (mk-gmr ["\\[" 'ANY "\\]\\(" 'ANY "\\)"]))
(def IMGS (mk-gmr ["\\[" 'ANY "\\]\\(" 'URLS "\\)"]))

;;; Grammar Function
(defn extract-pages
  [x]
  (re-matches PAGE x))                            ;TODO extract nested pages

(defn is-page
  [x]
  (def p (extract-pages x))
  (if (not (nil? x))
    (do (println "Found PAGE:") true)
    false))
