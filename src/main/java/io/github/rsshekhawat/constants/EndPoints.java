package io.github.rsshekhawat.constants;

import io.restassured.RestAssured;

public class EndPoints {

    String createBookingURI, updateBookingURI, deleteBookingURI, getBookingURI;

    public EndPoints(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    public String getCreateBookingURI() {
        return createBookingURI;
    }

    public void setCreateBookingURI() {
        this.createBookingURI = "/booking";
    }

    public String getUpdateBookingURI() {
        return updateBookingURI;
    }

    public void setUpdateBookingURI(int id) {
        this.updateBookingURI = "/booking/"+id;
    }

    public String getDeleteBookingURI() {
        return deleteBookingURI;
    }

    public void setDeleteBookingURI(int id) {
        this.deleteBookingURI = "/booking/"+id;
    }

    public String getGetBookingURI() {
        return getBookingURI;
    }

    public void setGetBookingURI(int id) {
        this.getBookingURI = "/booking/"+id;
    }
}
