package com.api.automation.tests;

import com.api.automation.api.BookingApi;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Booking API")
@Feature("Booking List")
public class GetBookingTest extends BaseTest {

    @Test
    @Story("Get All Bookings")
    @Description("Verify that all booking IDs can be retrieved")
    @Severity(SeverityLevel.NORMAL)
    public void testGetBookingIds() {
        Response response = BookingApi.getBookings();
        
        response.prettyPrint(); // Response'u konsola yazdır

        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        Assert.assertTrue(response.jsonPath().getList("bookingid").size() > 0, "Booking list should not be empty");
    }
}
