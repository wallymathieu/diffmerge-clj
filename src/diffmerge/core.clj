(ns diffmerge.core
  (:require
    [clojure.set :as cset]
    ))

(defn- set-contains [set] (fn [[key val]] (contains? set key)))

(defn diff "symmetric diff"
  [left right]
  (let [set-left (-> left keys set)
        set-right (-> right keys set) 
        only-on-left (into {} (filter (set-contains (cset/difference set-left set-right)) left))
        only-on-right (into {} (filter (set-contains (cset/difference set-right set-left)) right)) 

        intersection (into {} (map (fn [k] [k [(get left k) (get right k)]]) (cset/intersection set-right set-left)))
       ]
    {:only-in-right only-on-right :only-in-left only-on-left :intersection intersection} 
  ))