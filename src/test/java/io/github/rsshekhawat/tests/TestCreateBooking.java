package io.github.rsshekhawat.tests;

import io.github.rsshekhawat.helpers.CreateBooking;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCreateBooking extends CreateBooking {

    public static Response response;
    @Parameters({"firstname", "lastname", "totalPrice", "depositPaid", "additionalNeeds", "checkIn", "checkOut"})
    @BeforeClass
    public void getCreateBookingResponse(String firstname, String lastname, int totalPrice, boolean depositPaid,
                           String additionalNeeds, String checkIn, String checkOut){
         response = createBooking(firstname, lastname, totalPrice, depositPaid, additionalNeeds, checkIn, checkOut);
    }

    @Test
    public void TestCreateBookingResponseStatus(){
        Assert.assertEquals(response.getStatusCode(), 200, "Assertion Failed : CreateBooking response status code is not 200");
        Reporter.log("Assertion Passed : CreateBooking response status code is 200", true);
    }

    @Test
    public void TestCreateBookingResponseTime(){
        Assert.assertTrue(response.getTime()<=5000L, "Assertion Failed : CreateBooking response time is greater than 5 seconds");
        Reporter.log("Assertion Passed : CreateBooking response time is not greater than 5 seconds", true);
    }

    @Test
    public void TestCreateBookingResponseUserFirstName(){
        String actualFirstName = getFirstNameFromCreateBookingResponse(response);
        Assert.assertEquals(actualFirstName, "FirstName", "Assertion Failed : User's first name is not correct in create booking response");
        Reporter.log("Assertion Passed : User's first name is correct in create booking response", true);
    }

    @Test
    public void TestCreateBookingResponseUserLastName(){
        String actualLastName = getLastNameFromCreateBookingResponse(response);
        Assert.assertEquals(actualLastName, "LastName", "Assertion Failed : User's last name is not correct in create booking response");
        Reporter.log("Assertion Passed : User's last name is correct in create booking response", true);
    }

    @Test
    public void TestCreateBookingResponseRoomTotalPrice(){
        int actualTotalPrice = getTotalPriceFromCreateBookingResponse(response);
        Assert.assertEquals(actualTotalPrice, 120, "Assertion Failed : Room's total price is not correct in create booking response");
        Reporter.log("Assertion Passed : Room's total price is correct in create booking response", true);
    }

    @Test
    public void TestCreateBookingResponseUserCheckInTime(){
        String actualCheckInTime = getHotelCheckInTimeFromCreateBookingResponse(response);
        Assert.assertEquals(actualCheckInTime, "2018-01-01", "Assertion Failed : Room's checkin time is not correct in create booking response");
        Reporter.log("Assertion Passed : Room's checkin time is correct in create booking response", true);
    }

    @Test
    public void TestCreateBookingResponseUserCheckOutTime(){
        String actualCheckOutTime = getHotelCheckOutTimeFromCreateBookingResponse(response);
        Assert.assertEquals(actualCheckOutTime, "2019-01-01", "Assertion Failed : Room's checkout time is not correct in create booking response");
        Reporter.log("Assertion Passed : Room's checkout time is correct in create booking response", true);
    }
}
