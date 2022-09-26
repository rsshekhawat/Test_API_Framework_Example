# Test_API_Framework_Example

This is a basic api test automation framework structure and example using RestAssured library and POJO model.
### Tools Used : <br/>
1. Programming Language  : Java 17               <br/>
2. Build Automation Tool : Maven (v3.8.4)        <br/>
3. Test Framework        : TestNG (v7.6.1)       <br/>
4. API Test Library      : RestAssured (v5.2.0)  <br/>
5. Java Model            : POJO (Plain Old Java Object)

### Other Maven Dependencies
1. jackson-databind (com.fasterxml.jackson.core)    : Used to serialize java object to json    <br/>
2. json-path (com.jayway.jsonpath)                  : Used to deserialize json to java object

### Project Structure 

![image](https://user-images.githubusercontent.com/20008980/192139027-42f16c1f-242d-45c8-85d7-47aa597c6f4e.png)

#### Note : This is a example test api framework. Only the files highlighted in yellow have the code, rest java files are empty.

### Steps to run tests :
Run 'TestCreateBooking.xml' to run CreateBooking tests.

### Test Data :
Test data is passed via the test xml file using parameters tag.
