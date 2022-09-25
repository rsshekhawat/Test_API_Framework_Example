package io.github.rsshekhawat.helpers;

import io.github.rsshekhawat.constants.EndPoints;
import io.github.rsshekhawat.model.Booking;
import io.github.rsshekhawat.model.BookingDates;
import io.github.rsshekhawat.utils.utils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateBooking extends utils {

    public Response createBooking(String firstname, String lastname, int totalPrice, boolean depositPaid, String additionalNeeds, String checkIn, String checkOut) {

        BookingDates datesPayload = new BookingDates(checkIn, checkOut);
        Booking createBookingPayload = new Booking(firstname, lastname, totalPrice, depositPaid, datesPayload, additionalNeeds);
        String create_booking_payload = serializeObject(createBookingPayload);

        EndPoints endPoints = new EndPoints();
        endPoints.setCreateBookingURI();
        String createBookingURI = endPoints.getCreateBookingURI();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(create_booking_payload)
                .when()
                .post(createBookingURI)
                .then()
                .extract().response();

        return response;
    }

    public String getFirstNameFromCreateBookingResponse(Response response){
        return getJsonString(response.asString(), "$.booking.firstname");
    }

    public String getLastNameFromCreateBookingResponse(Response response){
        return getJsonString(response.asString(), "$.booking.lastname");
    }

    public int getTotalPriceFromCreateBookingResponse(Response response){
        return getJsonInteger(response.asString(), "$.booking.totalprice");
    }

    public String getHotelCheckInTimeFromCreateBookingResponse(Response response){
        return getJsonString(response.asString(), "$.booking.bookingdates.checkin");
    }

    public String getHotelCheckOutTimeFromCreateBookingResponse(Response response){
        return getJsonString(response.asString(), "$.booking.bookingdates.checkout");
    }
}
