# Vehicle Registration System

This program is designed to generate large numbers of vehicle records, assign them unique registration numbers. Once the registration numbers have been generated and assigned it will scan them against a list of DVLA revoked number combinations and replace them if they are considered offensive. It can be run as many times as desired with different results each time.


# Files

The program has uses takes in three files during the build process:

 1. vehicles.json - Contains a hash of vehicle manufactures and nested arrays containing each manufacture's respective models.
 2. ascii.txt - Contains the ascii formatted title run when the program starts up
 3. illegal_vrm_list.txt - Contains approximately 4000 partial registration numbers formatted as regular expressions.
