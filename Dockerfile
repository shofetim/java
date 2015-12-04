FROM ubuntu:15.04

ADD data.tar.xz /

ENTRYPOINT ["/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java"]

CMD ["-version"]
