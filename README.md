# Open Web Technologie - Web-App Fullstack Challenge

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
Spring boot back end application for the web-app fullstack challenge of Open Web Technologie.

This spring boot app work with a front end development that you can install locally too if you want to run completly. Please download it at https://github.com/jschneider14/OWT-angular-boat.

This REST API has a restricted access to connected people. If you want to access data, you need to authenticate with the user `OwtUser` and the password `OwtPassword`. You will receive a token that you need to join to all your API requests.

## Technologies
Project is created with:
* Java: 14
* Spring-boot: 2.3.3
    * Devtools
    * Web
    * Data JPA
    * Security
* [Springdoc Open API 3](https://github.com/springdoc/springdoc-openapi)
* [Lombok](https://projectlombok.org/)
* [Java JWT](https://github.com/jwtk/jjwt#install-jdk-maven)
	
## Setup
Download the source on GitHub at: https://github.com/jschneider14/OWT-spring-boot-boat

To run this project, install it locally and run it in your favorite IDE.

### API Documentation

You can get a documentation on this api going to this URL http://localhost:8080/swagger-ui when the application is running. 

It's the main overview on what you can get from this API.