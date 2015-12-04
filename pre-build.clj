#!/usr/bin/env lein-exec

(require '[clojure.java.io :as io])
(require '[clojure.java.shell :as shell])

(let [base-page
      (slurp "http://packages.ubuntu.com/wily-updates/amd64/openjdk-8-jre-headless/download")
      current-package-url (re-find #"http://mirrors.cat.pdx.edu/.*deb" base-page)]
  (with-open [in (io/input-stream current-package-url)
              out (io/output-stream "java.deb")]
    (io/copy in out))
  (shell/sh "ar" "x" "java.deb" "data.tar.xz")
  (io/delete-file "java.deb")
  (println "Updated data.tar.xz"))
