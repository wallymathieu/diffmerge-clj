(ns diffmerge.core-test
  (:require [clojure.test :refer :all]
            [diffmerge.core :refer :all]))


(deftest given-two-maps
  (is (= {:only-in-right {:c 4}, :only-in-left {:a 1, :d 5}, :intersection {:b [2 3]}} 
           (diff {:a 1 :b 2 :d 5} {:b 3 :c 4}))))

(deftest when-there-is-an-incoming-element 
  (is (= {:only-in-right {2 2}, :only-in-left {}, :intersection {1 ["1" 1]}} 
    (diff {1 "1"} {1 1 2 2}))))
(deftest when-there-an-empty-incoming-list 
  (is (= {:only-in-right {}, :only-in-left {1 "1"}, :intersection {}} 
    (diff {1 "1"} {}))))
(deftest when-incoming-is-the-same-as-existing 
  (is (= {:only-in-right {}, :only-in-left {}, :intersection {1 ["1" 1]}} 
    (diff {1 "1"} {1 1}))))