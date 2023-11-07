# Steps to run test
After cloning project into your local repository, go to root folder of the project via CommandPrompt/Terminal where DockerFile is located and apply below the steps:

## In order to run tests on docker container run below the commands sequantially on the root folder of the project:
- ```docker build -t search-engine-test .```
- ```docker run -dp 127.0.0.1:8082:8082 -e browser=Chrome -e server=container -e keyword="Domain specific languages" search-engine-test```
- Go to container terminal and follow-up the logs produced for test run