<h1 align="center">
<img src="./assets/logo.jpeg" alt="logo" width="300">
</h1>

<h4 align="center">
Empowering Insights, One Question at a Time
</h4>

<div align="center">

![version](https://img.shields.io/badge/version-v0.1.0-blue)
[![stability-beta](https://img.shields.io/badge/stability-alpha-yellow.svg)](https://github.com/mkenney/software-guides/blob/master/STABILITY-BADGES.md#beta)
[![stars](https://custom-icon-badges.demolab.com/github/stars/votingly/votingly-app?logo=star&style=flat)](https://github.com/votingly/votingly-app/stargazers "stars")
[![issues](https://custom-icon-badges.demolab.com/github/issues-raw/votingly/votingly-app?logo=issue)](https://github.com/votingly/votingly-app/issues "issues")
[![license](https://custom-icon-badges.demolab.com/github/license/votingly/votingly-app?logo=law&logoColor=white)](https://github.com/votingly/votingly-app/blob/main/LICENSE "license MIT")

<h4 align="center">
Built in 🇧🇪 with ❤️ and:
</h4>

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff)](#)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FF6600?logo=rabbitmq&logoColor=fff)](#)
[![React](https://img.shields.io/badge/React-%2320232a.svg?logo=react&logoColor=%2361DAFB)](#)
[![Postgres](https://img.shields.io/badge/Postgres-%23316192.svg?logo=postgresql&logoColor=white)](#)
[![Terraform](https://img.shields.io/badge/Terraform-844FBA?logo=terraform&logoColor=fff)](#)
[![Google Cloud](https://img.shields.io/badge/Google%20Cloud-%234285F4.svg?logo=google-cloud&logoColor=white)](#)

</div>

## About

Votingly is a comprehensive web application designed to streamline the process of creating, distributing, and analyzing surveys. It caters to businesses, educators, researchers, and individuals seeking to gather insights and feedback efficiently.

## Build and run

### Local
```
./gradlew clean build
docker compose up -d
java -jar -Dspring.profiles.active=dev build/libs/votingly-app-17.0.10.jar
```
Access at localhost:8080

### Dev Container
```
./gradlew clean -Dspring.profiles.active=testcontainer bootJar
java -jar -Dspring.profiles.active=devcontainer build/libs/votingly-app-17.0.10.jar
```

### Dockerize
```
docker build --tag=votingly:latest .
docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=devcontainer" votingly:latest

# To run on same network in dev container use --network=votingly_default
```

## Deploy

### Requirements
- Open this project
- In [GCP IAM](https://console.cloud.google.com/iam-admin/serviceaccounts) - Create your service account with 'Compute Admin', ‘DNS Admin’, ‘Service Account Admin’, ‘Service Account User’ permission. Then put its key in deploy/.creds and rename to 'gcloud_sa_compute_admin.json'
- [Install Terraform](https://developer.hashicorp.com/terraform/install) (or see [VScode dev containers](https://code.visualstudio.com/docs/devcontainers/containers#_quick-start-open-an-existing-folder-in-a-container) on how to open our project in a container)

### Steps
`cd deploy/prod`

Initialize (only first time)

`terraform init`

Get a preview of changes that Terraform plans to make to infrastructure

`terraform plan`

Execute the actions proposed in Terraform plan

`terraform apply`

Destroy all remote objects managed by Terraform

`terraform destroy`

## Devevelopment

```
npm init
docker compose up -d
```

Run Tests (specify spring active profile)
```
./gradlew -PspringProfilesActiveTests=<profile_name> check
```

Continuously rebuild on code changes
```
./gradlew -t classes
```