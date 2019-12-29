#Couchmovies Application Server
FROM couchbase:latest
MAINTAINER david.brown@couchbase.com

RUN apt-get update --fix-missing
RUN apt-get -y  install git 
RUN git clone https://github.com/escapedcanadian/couchmovies.git /opt/couchmovies

# RUN sudo apt-get -y install zip unzip jq maven vim openjdk-8-jdk python chromium-chromedriver
RUN apt-get -y install zip unzip jq maven vim openjdk-8-jdk python 
RUN /opt/couchmovies/build/buildServer

COPY entrypoint.sh /
RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 8080
