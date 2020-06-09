# SD-MV-Challenge-202006
Spring Boot Rest API

This API allow to test the CNES record, by listing all values, listing by UF, listing by type. The CNES records storage of data was done with H2 in-memory database. A CommandLineRunner interface was implemented to populate the data from the source file, cnes_ativonone.csv. Once that the application starts the database is automatically populated. It's necessary to wait a minute to load the data.

To run this program execute the class ChallengeApplication as a  spring boot application on IDE or use the command: mvn spring-boot:run, on terminal in the project directory.

To run the tests  execute the class ChallengeApplicationTests as a JUnit Test on IDE, or use the command: mvn test, on terminal in the project directory.

To access the interface use http://localhost/ and test the API.
