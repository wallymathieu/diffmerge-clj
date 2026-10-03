# diffmerge
[![Build Status](https://www.travis-ci.com/wallymathieu/diffmerge-clj.svg?branch=main)](https://www.travis-ci.com/wallymathieu/diffmerge-clj)
[![codecov](https://codecov.io/gh/wallymathieu/diffmerge-clj/branch/master/graph/badge.svg)](https://codecov.io/gh/wallymathieu/diffmerge-clj)
[![Clojars Project](https://img.shields.io/clojars/v/diffmerge.svg)](https://clojars.org/diffmerge)

A Clojure library for comparing two maps.

```clj
[diffmerge "0.0.0"]
```

## Usage

Require `diffmerge.core` and call `diff` with the existing and incoming maps:

```clj
(require '[diffmerge.core :as diffmerge])

(diffmerge/diff {:name "Ada" :age 36}
                {:name "Ada Lovelace" :city "London"})
;; => {:only-in-right {:city "London"}
;;     :only-in-left {:age 36}
;;     :intersection {:name ["Ada" "Ada Lovelace"]}}
```

The result separates keys found only in the right map (`:only-in-right`),
keys found only in the left map (`:only-in-left`), and shared keys
(`:intersection`). Each shared key maps to a two-element vector containing
its left and right values, in that order. See [the developer introduction](doc/intro.md)
for project and CI details.

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
