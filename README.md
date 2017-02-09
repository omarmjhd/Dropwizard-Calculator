# Dropwizard-Calculator
This is a basic calculator I built as an extended introduction to Dropwizard.

##Running the Project

This project is built as a Maven packaged Java project, so after cloning the repo, it can be packaged into a jar by running

```
mvn package
```

Once the project is packaged, it can be run using the following command

```
java -jar target/calculator-3.0-SNAPSHOT.jar server calculator.yml
```

After that command is run, the server should be up and active, and can be accessed at 

[http://localhost:8080/calculator](http://localhost:8080/calculator)

##Functionality

The calculator operations available are as follows:

| Operation     | Parameters                | Endpoint  |
| ------------- |:-------------------------:| -----:|
| Addition      | operation, value1*, value2* | [http://localhost:8080/calculator?operation=add&value1=1&value2=5](http://localhost:8080/calculator?operation=add&value1=1&value2=5) |
| Subtraction   | operation, value1*, value2* | [http://localhost:8080/calculator?operation=subtract&value1=1&value2=5](http://localhost:8080/calculator?operation=subtract&value1=1&value2=5) |
| Multiplication| operation, value1*, value2* | [http://localhost:8080/calculator?operation=multiply&value1=1&value2=5](http://localhost:8080/calculator?operation=multiply&value1=1&value2=5) |
| Division      | operation, value1*, value2* | [http://localhost:8080/calculator?operation=divide&value1=1&value2=5](http://localhost:8080/calculator?operation=add&value1=1*&value2=5*) |

Parameters annotated with an * are optional, and will be replaced with a 0 in the calculation if not added 

Additionally, Dropwizard HealthCheck's have been added to the project, and can be accessed at:

[http://localhost:8081/healthcheck](http://localhost:8081/healthcheck)

##Version History

Version 1.0 implements the calculator functionality within the Operation Resources and can be accessed by the following endpoint

[http://localhost:8080/calculator/add?value1=1&value2=5](http://localhost:8080/calculator/add?value1=1&value2=5)

Version 2.0 seperates the calculator into its own CalculatorService and can be reached at the following endpoint

[http://localhost:8080/calculator?operation=add&value1=1&value2=5](http://localhost:8080/calculator?operation=add&value1=1&value2=5)

To view the HealthCheck's for the application, hit the following link

[http://localhost:8081/healthcheck](http://localhost:8081/healthcheck)

Version 3.0 refactored a large majority of the code to follow proper DropWizard and Guice conventions, as well as allow the use of optional parameters. It can be reached at endpoints with the following structure:

[http://localhost:8080/calculator?operation=add&value1=1&value2=5](http://localhost:8080/calculator?operation=add&value1=1&value2=5)

[http://localhost:8080/calculator?operation=add&value1=1](http://localhost:8080/calculator?operation=add&value1=1)

[http://localhost:8080/calculator?operation=add](http://localhost:8080/calculator?operation=add)