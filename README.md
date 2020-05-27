# Shape backend

A Rest API constructed with kotlin and mongodb.

This has been used as learning opportunity as I have never used mongodb and haven't
made a backend entirely with kotlin before.

These technologies have been chosen as I've never built a backend with 
either of them and thought it would be interesting.

I have to say I've enjoyed using kotlin, though have often found that I was somewhat
in the wilderness for how to dependency inject @AutoWired components using kotlin
especially mocked ones for unit tests, but got there in the end :D

## Running the application
The simplest way to run the application is to start a mongo database instance with
docker.
This will bind your localhost port 27017 to this mongo docker container
`sudo docker run -d -p 27017:27017 -v ~/data:/data/db mongo`

Then the simplest way to get the application running is to build and 
run the spring boot application locally on the command line with gradle:
`./gradlew bootrun`

Alternatively open the project in intellij load gradle and run the Application.kt file
this will launch the rest api.

You will know this is working if you open http://localhost:8080/
and also http://localhost:8080/swagger-ui for the auto generated documentation of the rest api.

Upon launching please open:

http://localhost:8080/swagger-ui.html

For api documentation and a description of error 
return codes.

## Alternative ways of running mongo db
The application properties resource:
resources/application.properties

is currently configured to point to a mongodb database on localhost. Change this if you want to use
a remote database.

You can install mongodb locally using apt-get or brew, or you can live your 
best life and use docker :) 

## What has been done
The work here shows testable architecture for a backend.
Including a repository, service and Controller layer.

These layers are then mocked and some unit tests performed upon them.

A Dockerfile is produced, which will build  the backend provided a mongodb 
instance is provided in the application.properties file.

The DockerFile creates the application from scratch, and the artifact can
subsequently be launched.

A mongodb database has been used to store objects
submitted by the rest api.

The rest api has been containerised and is produced
by the docker file.

## Due to time constraints the following items are not complete:
- A database query to efficiently 
- More unit tests on the restapi layer
- Integration tests using postman
- Full containerisation (this should just be loading the produced jar into a dockerfile)
 
