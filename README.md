# presto

[![Clojars Project](http://clojars.org/presto/latest-version.svg)](http://clojars.org/presto)

I'm putting the stuff I want to reuse for tests here. Not sure what's
gonna happen to this repo in the long run.

## Usage

There are currently 2 test macros I've grown quite fond of:

#### `expected`

Syntax:
```clojure
expected {argument} {operator} {expectation}
```

Example: `(expected (inc 5) = 6)` this example passes. It tests that
incrementing 5 by one equals 6.

Example: `(expected (* 3 6) = 7)` fails. Why? because 6 * 3 != 7.

#### `expected-when`

Syntax:
```clojure
(expected-when {test-name} {function}
  :when {args0} {op0} {expectation0}
  ...
  :when {argsN} {opN} {expectationN})

`expect-when` takes a function as its second argument and runs the
function through a set of different arguments making an assertion on
each one of them.
```

Example:

```clojure
(expected-when 'test-inc' inc
  :when [0] = 1
  :when [1] = 2
  :when [3] = 4)
```

`expected-when` is very neat because it allows you to easily test a
function against different arguments and make an assertion on
the result.

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
