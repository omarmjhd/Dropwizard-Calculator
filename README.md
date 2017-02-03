# Dropwizard-Calculator
Basic calculator built as an extended introduction to Dropwizard

Version 2.0 implements the calculator functionality within the Operation Resources and can be accessed by the following endpoint

[http://localhost:8080/calculator/add?value1=1&value2=5](http://localhost:8080/calculator/add?value1=1&value2=5)

Version 2.0 maintains the functionality of version 1.0 but also seperates the calculator into its own CalculatorService and can be reached at the following endpoint
[http://localhost:8080/calculator?operation=add&value1=1&value2=5](http://localhost:8080/calculator?operation=add&value1=1&value2=5)

