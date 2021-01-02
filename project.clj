(defproject roam-parser "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [instaparse "1.4.10"]
                 [expectations "2.0.16"]
                 [com.datomic/client-pro "0.9.63"]
                 [datascript "1.0.3"]]
  :plugins [[lein-expectations "0.0.8"]]
  :main ^:skip-aot roam-parser.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})