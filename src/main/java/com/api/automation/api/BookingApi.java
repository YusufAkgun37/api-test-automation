package com.api.automation.api;

import io.restassured.response.Response;

public class BookingApi {

    private static final String BOOKING_ENDPOINT = "/booking";

    public static Response getBookings() {
        return RestResource.get(BOOKING_ENDPOINT);
    }

    public static Response getBooking(int id) {
        return RestResource.get(BOOKING_ENDPOINT + "/" + id);
    }

    public static Response createBooking(Object payload) {
        return RestResource.post(BOOKING_ENDPOINT, payload);
    }

    public static Response updateBooking(int id, Object payload) {
        return RestResource.put(BOOKING_ENDPOINT + "/" + id, payload);
    }

    public static Response deleteBooking(int id) {
        return RestResource.delete(BOOKING_ENDPOINT + "/" + id);
    }
}
