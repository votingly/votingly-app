terraform {
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "5.25.0"
    }
  }
}

provider "google" {
  # Configuration options
  project     = "votingly"
  region      = "europe-west1"
  zone        = "europe-west1-b"
  credentials = file(".creds/gcloud_sa_votingly-d37d67903f23.json")
}
