# tecnical-challenge
Backend JVM Software Engineer - Technical Challenge

To solve this challenge I decide to use only Java in a Maven project.

With little time I decided not add to project a library as Vert.x that I never have used.

Eu implementei 1 Entidade chamada pessoa e 3 validadores como serviços de domínio e um serviço de aplicação que instacia e gerencia o fluxo de threads.

A classe main é a mais "suja" de todas e injeta os serviços de domínio da camada de infra. 


To run you have to:
 - mvn package

Or just:
 - Open in IntelliJ as Maven project and run the StartApplication file