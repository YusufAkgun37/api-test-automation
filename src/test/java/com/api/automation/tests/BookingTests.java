package com.api.automation.tests;

import com.api.automation.api.BookingApi;
import com.api.automation.models.Booking;
import com.api.automation.models.BookingDates;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Booking API")
@Feature("CRUD Operations")
public class BookingTests extends BaseTest {

    private int bookingId;
    private Booking bookingPayload;

    @Test(priority = 1)
    @Story("Create Booking")
    @Description("Verify that a new booking can be created successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void createBookingTest() {
        // Create Booking Payload using Builder pattern
        BookingDates dates = BookingDates.builder()
                .checkin("2024-01-01")
                .checkout("2024-01-10")
                .build();

        bookingPayload = Booking.builder()
                .firstname("Yusuf")
                .lastname("Akgun")
                .totalprice(1000)
                .depositpaid(true)
                .bookingdates(dates)
                .additionalneeds("Extra Pillow")
                .build();

        // Send POST request
        Response response = BookingApi.createBooking(bookingPayload);
        response.prettyPrint();

        // Verify Status Code
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");

        // Extract Booking ID
        bookingId = response.jsonPath().getInt("bookingid");
        Assert.assertTrue(bookingId > 0, "Booking ID should be generated");
    }

    @Test(priority = 2, dependsOnMethods = "createBookingTest")
    @Story("Get Booking")
    @Description("Verify that a booking can be retrieved by ID")
    @Severity(SeverityLevel.NORMAL)
    public void getBookingTest() {
        Response response = BookingApi.getBooking(bookingId);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        
        // Deserialize response to POJO for easy assertion
        Booking responseBooking = response.as(Booking.class);

        Assert.assertEquals(responseBooking.getFirstname(), bookingPayload.getFirstname());
        Assert.assertEquals(responseBooking.getLastname(), bookingPayload.getLastname());
    }

    @Test(priority = 3, dependsOnMethods = "createBookingTest")
    @Story("Update Booking")
    @Description("Verify that a booking can be updated with new details")
    @Severity(SeverityLevel.CRITICAL)
    public void updateBookingTest() {
        // Update payload
        bookingPayload.setFirstname("Yusuf Updated");
        bookingPayload.setTotalprice(1500);

        String token = com.api.automation.api.AuthApi.getToken();
        Response response = BookingApi.updateBooking(bookingId, token, bookingPayload);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

        Booking responseBooking = response.as(Booking.class);
        Assert.assertEquals(responseBooking.getFirstname(), "Yusuf Updated");
        Assert.assertEquals(responseBooking.getTotalprice(), 1500);
    }

    @Test(priority = 4, dependsOnMethods = "createBookingTest")
    @Story("Delete Booking")
    @Description("Verify that a booking can be deleted")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteBookingTest() {
        String token = com.api.automation.api.AuthApi.getToken();
        Response response = BookingApi.deleteBooking(bookingId, token);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 201, "Status code should be 201 (Created) for delete");
    }
}
