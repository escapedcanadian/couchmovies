# This page is still under development
Next step is to build a Docker compose environment that links on container with CB and another running the services, allowing the CB image to be updated


# Couchmovies

This is a sample project shows how to build a search feature using Bleve/Couchbase FTS

# Demo
TBD

# Building the demo
This demo is designed to be run as a series of Docker images that are managed by ```docker stack``` (```docker-compose``` may also work).  The demo containers should be already available for the casual user of this demo, and nothing should need to be built.  The build instructions may be found in submodules of this repo:

- **couchmovies-couchbase**
 The instructions for building the Couchbase server container can be found in the [/couchbase submodule](https://github.com/escapedcanadian/couchmovies-couchbase).
- **couchmovies-movieservice**
 The instructions for building the RESTful service that fronts the database can be found in the  [/movieservice submodule](https://github.com/escapedcanadian/couchmovies-movieservice).
- **couchmovies-web**
 The instructions for building the http server container can be found in the [/web submodule](https://github.com/escapedcanadian/couchmovies-web).

# Running the demo
These instructions are written for running this demo on a Mac Powerbook laptop. It is designed to run in a docker swarm that only includes the local computer. It may work across a multi-machine docker swarm, but this has not been tested. They may be adaptable for other environements, such as kubernetes.

To run this demo, start by cloning the [/demo submodule](https://github.com/escapedcanadian/couchmovies-demo) onto your local machine.

``` git clone https://github.com/escapedcanadian/couchmovies-demo [localDir] ```

Change directory to directory that contains the demo (either localDir if you specified one or ./couchmovies-demo if you did not).

Check to see if your laptop has an active docker swarm.

```docker info```

Look for a line in the output that contains ```Swarm : active```

If there is no active swarm, create one with 

``` docker swarm init```


You can bring up the cluster by running the following in the demo directory

``` docker-compose up -d ```








OPTIONAL: If you want to enable the image cover (the image that appears when you click over a movie) you will need to install a chrome driver:
```
brew cask install chromedriver //on mac
```

And then update the path to your chrome driver in the class "ImageService.java"
