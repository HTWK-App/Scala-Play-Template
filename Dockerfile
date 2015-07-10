FROM java:8-jre
MAINTAINER <YOUR_EMAIL>

# Add project files and NewRelic Agent
ADD files /
ADD newrelic.zip /opt/docker/

WORKDIR /opt/docker

# Install NewRelic Agent
RUN unzip newrelic.zip
RUN cd newrelic && sed -i -e "s/My Application/<YOUR_APPLICATION_NAME>/g" newrelic.yml
RUN chmod +x ./bin/<NAME_FROM_build.sbt>

# Production settings
EXPOSE 9000
ENTRYPOINT ["./bin/<NAME_FROM_build.sbt>", "-J-javaagent:/opt/docker/newrelic/newrelic.jar"]
CMD []
