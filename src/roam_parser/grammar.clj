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
(def ITALICS (mk-gmr ["__" 'ANY "__"]))
(def HIGHLIGHT (mk-gmr ["\\^\\^" 'ANY "\\^\\^"]))

(def PAGE (mk-gmr ["\\[\\[" 'ANY "\\]\\]"]))
(def REF (mk-gmr ["\\(\\(" 'ANY "\\)\\)"]))
(def ALIAS (mk-gmr ["\\[" 'ANY "\\]\\(" 'ANY "\\)"]))
(def IMGS (mk-gmr ["\\[" 'ANY "\\]\\(" 'URLS "\\)"]))

;;; Grammar Function
(defn extract-pages
  [x]
  (re-matches PAGE x))                            ;TODO extract nested pages

;(defmacro gen-basic
;  [name]
;  '(defn (str/join ["is-" name])
;     [x]
;     (if (not (nil? (re-matches (str/upper-case name) x))) true false)))

(defn is-bold [x] (if (not (nil? (re-matches BOLD x))) true false))
(defn is-italics [x] (if (not (nil? (re-matches ITALICS x))) true false))
(defn is-highlight [x] (if (not (nil? (re-matches HIGHLIGHT x))) true false))
(defn is-page [x] (if (not (nil? (re-matches PAGE x))) true false))
(defn is-ref [x] (if (not (nil? (re-matches REF x))) true false))
(defn is-alias [x] (if (not (nil? (re-matches ALIAS x))) true false))
(defn is-img [x] (if (not (nil? (re-matches IMGS x))) true false))

;  '(defn (str/join ["is-" name])
;     [x]
;     (if (not (nil? (re-matches (str/upper-case name) x))) true false)))

;(defn is-page
;  [x]
;  (def p (extract-pages x))
;  (if (not (nil? p))
;    (do (println "Found PAGE:") true)
;    false))


