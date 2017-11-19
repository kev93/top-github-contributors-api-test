# top-github-contributors-api-test
API to get the top GitHub contributors in given city name

### How it works
Assuming that we have the project running already, we should go to:
[http://localhost:8080/contributors](http://localhost:8080/contributors)

If we want to know which users are on the TOP 100 contributors of Barcelona, 
sorting them by the number of repositories, then we can add query params as shown below:

[http://localhost:8080/contributors?city=barcelona&size=100&sort=repos&order=desc](http://localhost:8080/contributors?city=barcelona&size=100&sort=repos&order=desc)


### Installation
#### What you'll need
 * JDK 1.8
 * Gradle 2.3+

Project compilation by executing:
`gradle build`

Run the project by doing:
`java -jar build/libs/gs-test-rest-0.1.0.jar`

If you have docker installed in your PC, you can run the project as shown below 

`docker run --rm -v gradle-cache:/home/gradle/.gradle -v "$PWD":/home/gradle/project -w /home/gradle/project gradle:jdk8-alpine gradle clean build && java -jar build/libs/gs-test-rest-0.1.0.jar`

#### Run the tests
`gradle test`

or

`docker run --rm -v gradle-cache:/home/gradle/.gradle -v "$PWD":/home/gradle/project -w /home/gradle/project gradle:jdk8-alpine gradle test`


### Comments

First of all i wanted to let you know that i just realized that GitHub users endpoint results size up to 100 :/ ....
and now is too late to implement this feature (I'd have made two requests and changing page and per_page params to get it when size > 100')

I used Java 8 and Spring boot framework as you could see, because i wanted to demonstrate that although i'm not use to
this language and i have no knowledge of Spring framework, i finished the code challenge
(although i realize too late about mentioned trouble). 

There is no asynchronous implementation, i wanted to implement it using CompletableFuture class form Java 8, but i had some
troubles with Spring configuration.