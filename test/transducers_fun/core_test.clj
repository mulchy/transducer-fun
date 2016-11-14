(ns transducers-fun.core-test
  (:require [clojure.test :refer :all]
            [transducers-fun.core :refer :all]))

(deftest caesar-count-test
  (testing "The caesar count function works"
    (is (= (caesar-count "abc" 0) {\c 1, \b 1}))
    (is (= (caesar-count "abc" 1) {\d 1, \c 1}))
    (is (= (caesar-count "hello world" 0) {\d 1, \r 1, \w 1, \l 3, \h 1}))
    (is (= (caesar-count "hello world" 13) {\q 1, \e 1, \j 1, \y 3, \u 1}))))
