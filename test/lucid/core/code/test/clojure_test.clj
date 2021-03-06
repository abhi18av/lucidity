(ns lucid.core.code.test.clojure-test
  (:use hara.test)
  (:require [lucid.core.code.test.clojure :refer :all]
            [lucid.core.code.test.common :as common]
            [rewrite-clj.zip :as z]))

^{:refer lucid.core.code.test.clojure/gather-is-form :added "1.1"}
(fact "Make docstring notation out of is form"
  (common/join-nodes (gather-is-form (z/of-string "(is (= 1 1))")))
  => "1\n  => 1"

  (common/join-nodes (gather-is-form (z/of-string "(is (boolean? 4))")))
  => "(boolean? 4)\n  => true")

^{:refer lucid.core.code.test.clojure/gather-deftest :added "1.1"}
(fact "Make docstring notation out of deftest form"
  (-> "^{:refer example/hello-world :added \"0.1\"}
       (deftest hello-world-test\n  \"Sample test program\"\n  (is (= 1 1))\n  (is (identical? 2 4)))"
      (z/of-string)
      z/down z/right z/down z/right z/right
      (gather-deftest)
      :test
      common/join-nodes)
  => "\"Sample test program\"\n  1\n  => 1\n  (identical? 2 4)\n  => true")
