package com.api.automation.tests;

import com.api.automation.api.BookingApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingTest extends BaseTest {

    @Test
    public void testGetBookingIds() {
        Response response = BookingApi.getBookings();
        
        response.prettyPrint(); // Response'u konsola yazdır

        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        Assert.assertTrue(response.jsonPath().getList("bookingid").size() > 0, "Booking list should not be empty");
    }
}
