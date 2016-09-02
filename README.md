GoEuro Test
==============

How to run the application:
--------------

-  `java -jar goeuro.jar 'CITY_NAME'`

-  The file will be recorded on the same directory where is located JAR file.

How to run the tests:
---------------------

- `mvn tests`

How to generate the jar file:
-----------------------------

- `mvn package`

 Technologies
 --------------
   - Java 8
   - [FasterXML/jackson] (https://github.com/FasterXML/jackson)
   - [FasterXML/jackson-dataformat-xml] (https://github.com/FasterXML/jackson-dataformat-xml)
   
   
Design/Architecture Decisions
-------------- 
About the design:
 
 The class responsible for parsing the arguments is the Parameter.java
 The CityService.java is called to return the JSON document.
 The class responsible to return the list of Cities is the GenerateCities.java 
 To record the datas into the csv file is the CSVWriter.java is called.
 
 
   
  


