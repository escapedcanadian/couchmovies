# This page is still under development
Next step is to build a Docker compose environment that links on container with CB and another running the services, allowing the CB image to be updated


# Couchmovies



## Building the demo
This demo is designed to be run as a series of Docker images that are managed by ```docker-compose```. **The demo containers should be already available in docker hub for the casual user of this demo, and nothing should need to be built.** For someone wanting to update or enhance the demo, the build instructions may be found in submodules of this repo:

- **couchmovies-couchbase**
 The instructions for building the Couchbase server container can be found in the [/couchbase submodule](https://github.com/escapedcanadian/couchmovies-couchbase).
- **couchmovies-movieservice**
 The instructions for building the RESTful service that fronts the database can be found in the  [/movieservice submodule](https://github.com/escapedcanadian/couchmovies-movieservice).
- **couchmovies-web**
 The instructions for building the http server container can be found in the [/web submodule](https://github.com/escapedcanadian/couchmovies-web).

## Running the demo
These instructions are written for running this demo on a Mac Powerbook laptop.  It may work across a multi-machine docker swarm, but this has not been tested. They may als be adaptable for other environements, such as kubernetes.

To run this demo, start by cloning the [/demo submodule](https://github.com/escapedcanadian/couchmovies-demo) onto your local machine.

``` git clone https://github.com/escapedcanadian/couchmovies-demo [localDir] ```

Change directory to directory that contains the demo (either localDir if you specified one or ./couchmovies-demo if you did not).

Follow the instructions in the [README.md](https://github.com/escapedcanadian/couchmovies-demo) of that repo.






