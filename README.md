## Net Calculator
A service which allows consumers to
calculate the net price from a gross price by excluding the tax. Different Tax rates are being applied for different countries hence. Currently supported countries are `DE`, `FR`, `IT`, `NL`
#### Getting started
To run the application locally, you need:
* Java 11 or higher
* Gradle 7+

To build the application run the following command:
```./gradlew build```

To test out the application, first go to `/build/libs` folder and then run the following command:

```java -Dprice=10 -Dcountry=FR -jar net-calculator.jar```

`price` and `country` are optional. Default values are price=100 and country=DE.

#### Overview
Java files are inside `src/main/java` and test files are inside `src/test` folder.
`NetPriceCalculatorService` is the service interface for calculating the Net price.