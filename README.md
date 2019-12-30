# This page is still under development
Next step is to build a Docker compose environment that links on container with CB and another running the services, allowing the CB image to be updated


# CouchMovies

This is a sample project shows how to build a search feature using Bleve/Couchbase FTS

# Demo
TBD

## Building a new couchmovies-couchbase image
Start by determining which version of Couchbase Server you wish to run, making sure that there is an available Docker image on [Docker Hub](https://hub.docker.com/_/couchbase). Select the appropriate tag and use it in the command below.

### Pull and run a docker image

```
pull docker couchbase:<tag>
docker run -d --name couchmovies_couchbase_build -p 8091-8096:8091-8096 -p 11210-11211:11210-11211 couchbase:<tag>

```
### Configure environment inside Docker
```
docker exec -it couchmovies_couchbase_build bash
```
```
apt-get update --fix-missing
apt-get -y  install git unzip
git clone https://github.com/escapedcanadian/couchmovies /opt/couchmovies


cd /opt/couchmovies/build
. .env
./installToolsDebian
./createCluster
./loadData
./createRBAC
./resetTweets
```  
At this point, it is prudent to check that there are three populated buckets and all created indices are ready

### Tag and push the image to the Docker repo
```
docker image tag couchmovies_couchbase_build escapedcanadian/couchmovies_couchbase:<tag>
docker push escapedcanadian/couchmovies_couchbase:<tag>
```

# Running the demo
Other than having the server running, you need three additional processes.  While you could run these in the same temrminal and background them, I typically run them in separate terminals

### The microservice
For historical reasons,this project is built out of the root directory.  To build the service, run
```
mvn clean install
```
Followed by
```
mvn spring-boot-run
```

### The webserver
This simple HTTP server serves up the single content page, but, for cross domain authentication reasons, it needs to be run on the same server as the microservice
```
front/runWebServer
```
With this server running, you should see the Couchmovies page load on 
http://localhost:8000/couchmovies.html


### Tweet Feeder
You should prepare to run this process, but don't run it until you have shown the Tableau dashboard as-is, with the single tweet. The Tableau dashboard is wholly unhappy if there is no data in the dataset, so we start with a single tweet.

This process pulls the tweets from the tweetSource bucket and puts them into the tweetTarget bucket at a rate of 4 per second (it would be nice to pass a parameter in to control the rate some day).

```
tweet-feeder/startFeeder
```
You can reset the tweetTarget bucket to contain a single tweet using
```
cd build
. .env
./resetTweets
```


OPTIONAL: If you want to enable the image cover (the image that appears when you click over a movie) you will need to install a chrome driver:
```
brew cask install chromedriver //on mac
```

And then update the path to your chrome driver in the class "ImageService.java"
