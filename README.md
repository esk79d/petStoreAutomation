# petStoreAutomation
#This file gives an overview of what this project does and how to execute these tests

# Below are the tools that have been used this for automation framework.
1)Java as Programming language

2)RestAssured as the Java library to handle the APi Requests and Responses

3)Gradle as build tool

4)Serenity BDD to write the tests in BDD structure

5) log4j to log the UserActions

#ProjectOverview
1)The project is designed by making use of Core java Concepts
2)The Locators Class helps us to identify the pageElements using xpath
3)The HomePageActions class has got all the necessary methods to perform various User actions to fill the Customer details to get a Home Insurance Quote on the PolicyExpert WebPage
4)I've provided the testdata under TestData class. If needed, I can also create a BDD framework to pass the input data via Feature file
5)The ElementActions has got the generic methods to assist the HomePageActions in performing various User operations
6)The HomeTest class has got the actual Test scenarios to perform below actions:
fillCustomerDetailsWithDualOccupation
fillCustomerDetailsWithSingleOccupation
validateContactDetails
7)This makes use of the methods in HomePageActions to perform various Operations and Validate the behavior

# How to Run Project :

1)command to execute the entire project via Terminal:  ./gradlew clean build test
2)run PetStoreServiceTests in src\test\java\tests
3)Report path : petStoreAutomation\target\site\serenity
One can view the report by opening the .html file via one of the browsers