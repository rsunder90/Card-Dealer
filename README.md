# Card-Dealer
A Spring boot application that shuffles and deals cards.

What you need to run this application:

Maven
Java (1.8) & Spring Boot (1.5.15)
Alternatively, if you know how to use Eclipse or Intellij, you can use the built-in tools to compile and run the program.

Steps to run:

Check out card-games-api, card-games-impl and card-games-server.
Maven install in the following order:
card-games-api
card-games-impl
card-games-server

You will need to spring-boot:run the card-games-server once everything has been maven installed properly (assuming there were no complications).
Port default is 8080 but can be changed in the application.properties file.

Endpoints:

-{host}:8080/shuffleDeck - This is a GET endpoint that shuffles the deck of cards on the server and returns a message saying that the deck was shuffled.

-{host}:8080/dealOneCard - This is a GET endpoint that deals one card until the deck runs out of cards (where it will return a 400).

Notes:

I figured the best use case for a card dealing application involved it being some sort of server acting as a "dealer" that is in charge of card distribution to participating players. Multiple users can theoretically hit these endpoints and play whatever game they want to with this interface because the server keeps track of the cards.

Using Spring Boot and this service-layer approach lends itself to interesting implementations. For example, I could inject/autowire a corrupt card dealer that deals from the middle or bottom of the deck depending on specific circumstances.
