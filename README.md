# Shape backend

A Rest API constructed with kotlin and mongodb.

This has been used as learning opportunity as I have never used mongodb and haven't
made a backend entirely with kotlin before.

These technologies have been chosen as I've never built a backend with 
either of them and thought it would be interesting.

I have to say I've enjoyed using kotlin, though there wasn't many posts anywhere about how to dependency inject @AutoWired components using kotlin or mock them for unit tests, whilst combining with kotlins null safety and constructors, but I got there in the end :D

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
and also http://localhost:8080/swagger-ui.html for the auto generated documentation of the rest api.

Upon launching please open:

`http://localhost:8080/swagger-ui.html`

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

Including a repository, service and rest controller layer.

Continuous integration has been setup using circleci and reports on the unit tests run as 
well as running the unit tests on each commit.

Many unit tests have been written to demonstrate a test driven development style towards
whether the two rectangles overlap. I thought this would show off a TDD style more than a DB query.

The layers are mocked and some unit tests performed upon them. To demonstrate I know
how to use mocking libraries and test infrastructure in layers.

A Dockerfile has been added, which could be used to run the jar file if the jar was
 placed inside it from the CI.
 
The CRUD operations are implemented using mongodb. This mongodb instance can be run anywhere, and the code
is not tied to a single hard coded instance.

A mongodb database has been used to store objects
submitted by the rest api.

The application produces it's own documentation using swagger. Detailing the model classes used
and the operations available on each endpoint.

The create functionality returns the created shape in the header as a resource
as is standard for rest api's


## Due to time constraints the following items are not complete:
- A database query to efficiently search whether a rectangle will be placed inside another rectangle.
- Add a feature to only allow creation of a rectangle if it is not inside another rectangle
- More unit tests on the restapi layer
- Integration tests using postman
- Full containerisation (this should just be loading the produced jar into a dockerfile)
 
I was hoping to show off by using the geospatial queries of mongodb to solve the interior exterior problem of the rectangle,
but the provided kotlin code solving the problem should hopefully suffice.

Postman automation testing could be used to test the rest api too
