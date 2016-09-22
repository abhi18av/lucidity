(defproject tahto/lucid "1.1.0"
  :description "tools for clarity"
  :url "https://www.github.com/tahto/lucidity"
  :license {:name "The MIT License"
            :url "http://http://opensource.org/licenses/MIT"}
  :aliases {"test" ["run" "-m" "hara.test"]}
  :injections []
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.match "0.2.2"]
                 [im.chit/hara.data      "2.4.4"]
                 [im.chit/hara.data.diff "2.4.4"]
                 [im.chit/hara.data.nested "2.4.4"]
                 [im.chit/hara.io.file   "2.4.4"]
                 [im.chit/hara.io.watch  "2.4.4"]
                 [im.chit/hara.common.checks "2.4.4"]
                 [im.chit/hara.common.watch  "2.4.4"]
                 [im.chit/hara.component "2.4.4"]
                 [im.chit/hara.concurrent.latch "2.4.4"]
                 [im.chit/hara.concurrent.pipe  "2.4.4"]
                 [im.chit/hara.event     "2.4.4"]
                 [im.chit/hara.object    "2.4.4"]
                 [im.chit/hara.reflect   "2.4.4"]
                 [im.chit/hara.string    "2.4.4"]

				         [org.eclipse.aether/aether-api "1.1.0"]
	               [org.eclipse.aether/aether-spi "1.1.0"]
                 [org.eclipse.aether/aether-util "1.1.0"]
                 [org.eclipse.aether/aether-impl "1.1.0"]
	               [org.eclipse.aether/aether-connector-basic "1.1.0"]
	               [org.eclipse.aether/aether-transport-wagon "1.1.0"]
	               [org.eclipse.aether/aether-transport-http "1.1.0"]
	               [org.eclipse.aether/aether-transport-file "1.1.0"]
	               [org.eclipse.aether/aether-transport-classpath "1.1.0"]
	               [org.apache.maven/maven-aether-provider "3.1.0"]

                 [version-clj/version-clj "0.1.2"]
                 [rewrite-clj/rewrite-clj "0.5.2"]
                 [markdown-clj/markdown-clj "0.9.89"]
                 [hiccup/hiccup "1.0.5"]]
  :java-source-paths ["example/java"]
  :jar-exclusions [#"^test\..+\.class"]				 
  :profiles {:dev {:dependencies [[im.chit/hara.test "2.4.4"]]
                   :plugins [[lein-hydrox "0.1.17"]
				             [lein-repack "0.2.10"]]}}

  :repack [{:type :clojure
            :levels 2
            :path "src"
            :standalone #{"aether" "base" "dive" "launch" "query"}}])