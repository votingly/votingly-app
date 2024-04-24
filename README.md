# Votingly













### Build and run instructions (cmd)

Local
```
./gradlew clean bootJar
java -jar -Dspring.profiles.active=dev build/libs/votingly-app-17.0.10.jar
```
Dev Container
```
./gradlew clean -Dspring.profiles.active=testcontainer bootJar
java -jar -Dspring.profiles.active=devcontainer build/libs/votingly-app-17.0.10.jar
```

```
docker build --tag=votingly:latest .
docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=devcontainer" --network=votingly_default votingly:latest
```

Terraform Usage and info:


### Dev instructions

```
npm init
```