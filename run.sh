#bin/bash
mvn clean install
mvn compile
mvn package
java -jar target/vrmdemo.jar