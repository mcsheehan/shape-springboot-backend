# Shape backend

A Rest API constructed with kotlin and mongodb.


This has been a learning opportunity as I have never used mongodb and haven't
made a backend entirely with kotlin before.

I have to say I've enjoyed using kotlin, though have often found that I was somewhat
in the wilderness for how to dependency inject @AutoWired components using kotlin
especially mocked ones for unit tests, but got there in tle he end :D

Access to a mongodb is the easiest way to get going with this.
The application properties resource:

resources/application.properties
is currently configured to operate on local host.

You can install mongodb locally using apt-get or brew, or you can live your 
best life and use docker :) 

This will bind your localhost port 
`sudo docker run -d -p 27017:27017 -v ~/data:/data/db mongo`



To build and run all tests:
./gradlew build

To run the spring boot application locally :
./gradlew bootrun


These technologies have been chosen as I've never built a backend with 
either of them and thought it would be interesting.

The work here shows testable architecture for a backend.
Including a repository, service and Controller layer.

These layers are then mocked and some unit tests performed upon them.

A Dockerfile is produced, which will build  the backend provided a mongodb 
instance is provided in the application.properties file.

The DockerFile creates the application from scratch, and the artifact can
subsequently be launched.


##### Due to time constraints the following items are not complete:
- A database query to efficiently 


 
A mongodb database has been used to store objets
submitted by the rest api.

The rest api has been containerised and is produced
by the docker file.

Upon launching please open:

http://localhost:8080/swagger-ui.html

For api documentation and a description of error 
return codes.
