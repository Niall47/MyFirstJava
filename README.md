# Vehicle Registration System

This program is intended to generate large numbers of vehicle records, assign them unique registration numbers.
It uses SpringBoot to provide an API which allows for interaction with the program
By default it runs on port 8080

# Build & Run
To run the application first build with Maven using 
>mvn clean package

Then to launch the application run 
> java -jar target/VehicleRegistry-0.0.1-SNAPSHOT.jar


# URLs
To make things easier, here are the URLs you will need

http://localhost:8080/scan - Scans all registrations in the registry for illegal combinations

http://localhost:8080/start?add=1000 - Creates dummy vehicle and assigns a unique registration number to it

# Files

The program takes in three files during the build process:

 1. vehicles.json - Contains a hash of vehicle manufactures and nested arrays containing each manufacture's respective models.
 2. ascii.txt - Contains the ascii formatted title run when the program starts up
 3. illegal_vrm_list.txt - Contains approximately 4000 partial registration numbers formatted as regular expressions.
