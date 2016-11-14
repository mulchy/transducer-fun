(ns transducers-fun.core
  (:gen-class))

(defn char->number
  "Converts a chacter to it's caesar number"
  [char]
  (- (int char) 97))

(defn number->char
  "Converts a caeser number to a character"
  [number]
  (char (+ 97 number)))

(def remove-garbage
  (filter #(Character/isLetter %)))

(def remove-vowels
  (filter (comp
           not
           #(contains? #{\a \e \i \o \u} %))))

(def remove-uppercase
  (filter (comp not #(Character/isUpperCase %))))

(defn rotate-n
  [char n]
  (-> char
      (char->number)
      (+ n)
      (mod 26)
      (number->char)))

(defn caesar
  [n]
  (fn [char] (rotate-n char n)))

(defn xform
  [n]
  (comp
   remove-garbage
   remove-vowels
   remove-uppercase
   (map (caesar n))))

(defn reducer
  [acc val]
  (update-in acc [val] (fnil inc 0)))

(defn caesar-count
  [string cipher]
  (transduce (xform cipher) (completing reducer) {} string))

(defn -main
  ([]
    (println "Should be called with a string and a number"))
  ([any]
    (println "Should be called with a string and a number"))
  ([string count & rest]
   (println (caesar-count string (read-string count)))))
