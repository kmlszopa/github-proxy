# GitHub Proxy MVP

## Purpose

Code challenge for recruiting process

## Features
* Retrieve repositories for a given GitHub user.
* Parallelize requests to the GitHub API to improve performance and efficiency.

## What's inside

The template is a working application with a minimal setup. It contains:
* application skeleton
* dockerfile

The application exposes swagger endpoint (http://localhost:8080/swagger-ui.html)


## Setup and run

Simply run `./Dockerfile`.


## Acceptance criteria:
1. As an api consumer, given username and header “Accept: application/json”, I would like to list all his github repositories, which are not forks. Information, which I require in the response, is:
   Repository Name
   Owner Login
   For each branch it’s name and last commit sha

2. As an api consumer, given not existing github user, I would like to receive 404 response in such a format:
   {
   “status”: ${responseCode}
   “Message”: ${whyHasItHappened}
   }

3. As an api consumer, given header “Accept: application/xml”, I would like to receive 406 response in such a format:
   {
   “status”: ${responseCode}
   “Message”: ${whyHasItHappened}
   }

## Notes:
- Please full-fill the given acceptance criteria, delivering us your best code compliant with industry standards.
- Please use https://developer.github.com/v3 as a backing API
- Please expose swagger
- Application should have a proper README.md file
- Add unit and integration test cases.
- Prepare Dockerfile so that app can be run in a container
- Make sure that data is downloaded in parallel, not in sequence
- U can either use reactive stack of Your choice, or stick to non-reactive/blocking approach

## Technologies to use (required):
- Java
- Maven
- Spring Boot