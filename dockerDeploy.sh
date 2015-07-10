#!/bin/bash
git pull

activator clean docker:stage
cp Dockerfile target/docker/
cp newrelic-java-3.17.0.zip target/docker/newrelic.zip

cd target/docker/
docker build -t <YOUR_IMAGE_Tag> ./

docker rmi <YOUR_IMAGE_Tag>:current
docker tag <YOUR_IMAGE_Tag>:latest <YOUR_IMAGE_Tag>:current
