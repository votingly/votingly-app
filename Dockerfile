FROM eclipse-temurin:17.0.10_7-jdk-alpine
COPY build/libs/votingly-app-17.0.10.jar votingly-app-17.0.10.jar
ENTRYPOINT ["java","-jar","/votingly-app-17.0.10.jar"]

# https://hub.docker.com/_/eclipse-temurin/tags?page=&page_size=&ordering=&name=17.0.10
