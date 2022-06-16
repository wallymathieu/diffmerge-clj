(ns diffmerge.core)

(defn diff "symmetric diff"
  [left right]
  (let [common-keys (keys (select-keys left (keys right)))
        only-on-left (apply dissoc left (keys right))
        only-on-right (apply dissoc right (keys left))
        intersection (into {} (for [k common-keys]
                                [k [(get left k) (get right k)]]))]
    {:only-in-right only-on-right
     :only-in-left only-on-left
     :intersection intersection}))
