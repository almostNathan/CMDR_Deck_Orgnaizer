Launcher.class: 	Launcher.java MainActivity.class CardList.class Card.class
	javac -g Launcher.java

MainActivity.class:	MainActivity.java CardList.class Card.class
	javac -g MainActivity.java

CardList.class:		CardList.java Card.class
	javac -g CardList.java

BasicLand.class: 	BasicLand.java Card.class
	javac -g BasicLand.java

Card.class:			Card.java
	javac -g Card.java



run: 			Launcher.class
	java Launcher


debug:			Launcher.class
	jdb Launcher

clean: 
	rm *.class
