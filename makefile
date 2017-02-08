#
# makefile
#
# input file for 'make' build tool ( /usr/bin/make )
# to build solution for CS 5666 JUnit sample
#
# @author Dr. Fenwick,  Mikeal Anderson
# @version Spring 2017 Greeting v1
#

JUNIT_JAR = /usr/share/java/junit-4.10.jar
HAMCREST_JAR = /usr/share/java/hamcrest/core-1.1.jar
APACHE_JAR = /u/css/andersonmc2/5666/gitlabs/Greeting/cs-5666-greeting-andersonmc2/lib/commons-cli-1.3.1.jar
default:
	@echo "usage: make target"
	@echo "available targets: compile, test, clean, run"

compile: Greeting.java GreetingTest.java
	javac -cp .:$(JUNIT_JAR):$(APACHE_JAR) GreetingTest.java
	javac -cp .:$(APACHE_JAR) Greeting.java
clean:
	rm -f Greeting.class
	rm -f GreetingTest.class
run:
	java -cp .:$(APACHE_JAR) Greeting

test: Greeting.class GreetingTest.class
	java -cp .:$(JUNIT_JAR):$(HAMCREST_JAR):$(APACHE_JAR) org.junit.runner.JUnitCore GreetingTest
