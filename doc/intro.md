# Introduction to diffmerge

`diffmerge` provides `diffmerge.core/diff`, which compares two maps. Its
result contains maps for keys present only on the right (`:only-in-right`),
keys present only on the left (`:only-in-left`), and keys present in both
(`:intersection`). Values in the intersection are `[left-value right-value]`
vectors. See the [README](../README.md#usage) for a runnable example.

## Project files

- `src/diffmerge/core.clj` contains the library implementation.
- `test/diffmerge/core_test.clj` contains the `clojure.test` tests.
- `project.clj` defines the Leiningen project and development plugins.

## Running the CI checks

This project uses Leiningen. The Travis CI configuration runs:

```sh
lein ancient
lein cloverage --codecov
```

The first command checks for outdated dependencies; the second runs the
coverage task, which also runs the tests. On successful CI runs, Travis uploads
`target/coverage/codecov.json` to Codecov.
