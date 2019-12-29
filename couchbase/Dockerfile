#Couchmovies Application Server
FROM couchbase:latest
MAINTAINER david.brown@couchbase.com

RUN apt-get update
RUN apt-get -y  install git sudo
RUN useradd -m -p $(openssl passwd -1 demo) demo
RUN usermod -aG sudo demo
RUN echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> /etc/sudoers
RUN echo "PATH=/opt/couchbase/bin:\$PATH" >> /home/demo/.profile
RUN su -l demo
RUN git clone https://github.com/escapedcanadian/couchmovies.git

RUN sudo apt-get -y install zip unzip jq maven vim openjdk-8-jdk python chromium-chromedriver
RUN sudo ln -s /usr/lib/chromium-browser/chromedriver /usr/local/bin/chromedriver

RUN cd /demo/couchmovies/build
RUN ./buildServer

ENTRYPOINT ["/entrypoint.sh"]
CMD ["couchbase-server"]

EXPOSE 8091 8092 8093 8094 8095 8096 11207 11210 11211 18091 18092 18093 18094 18095 18096
VOLUME /opt/couchbase/var