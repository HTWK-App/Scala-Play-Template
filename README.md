Scala-Play Template
=================================

This is a Template for a Microservice, written in Scala in cooperation with the Play-Framework. It will provision a REST-JSON and Linked-Data API. As Linked-Data, RDF/XML, Turtle and Notation-3 will be provided.

### How to use this Template ###

In Order to write your own microservice, all you have to do is to fork this repository and fill in all the necessary parts into the following files:

* build.sbt - Name of your service
* Dockerfile - Maintainer, NewRelic Application Name, Name of the startup script
* Dockerdeploy.sh - Docker image tag

Last thing you have to do is to add your application ideas code into the app directory. That's it!

### Compilation/Running this Service  ###

Install the [Typesafe Acticator](//www.playframework.com/documentation/2.3.x/Installing).

For **developement mode**, execute the following commands:

```
# May take some time...
activator update
activator run
```

To package the application for **production mode**, execute the following command. You will be told where the resulting dist zip is placed. Inside this zip, theres a run script. Start it and your ready to go.

```
activator dist
```

Please note that this application was designed to be deployed with docker and instrumented (Metrics, ...) by NewRelic. Inside the projects root, you'll find a scipt named **dockerDeploy.sh**. This script will build a docker image, containing the app. Execute the following to start the docker image:

```
docker run -it --rm -p 9000:9000 <YOUR_Image_Tag>:latest
```
