# Votingly













## Build and run instructions

### Local
```
./gradlew clean bootJar
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

## Infrastructure as Code



### Instructions
- Open this project
- In [GCP IAM](https://console.cloud.google.com/iam-admin/serviceaccounts) - Create your service account with 'Compute Admin', ‘DNS Admin’, ‘Service Account Admin’, ‘Service Account User’ permission. Then put its key in deploy/.creds and rename to 'gcloud_sa_compute_admin.json'
- [Install Terraform](https://developer.hashicorp.com/terraform/install) (or see [VScode dev containers](https://code.visualstudio.com/docs/devcontainers/containers#_quick-start-open-an-existing-folder-in-a-container) on how to open our project in a container)
```
cd deploy/prod

# Initialize (only first time)
terraform init

# Get a preview of changes that Terraform plans to make to infrastructure
terraform plan

# Execute the actions proposed in Terraform plan
terraform apply

# Destroy all remote objects managed by Terraform
terraform destroy
```

## Dev instructions

```
npm init
docker compose up -d
```

Run Tests (specify spring active profile)
```
./gradlew -PspringProfilesActiveTests=<profile_name> check
```