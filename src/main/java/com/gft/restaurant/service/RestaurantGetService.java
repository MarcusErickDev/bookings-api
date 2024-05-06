package com.gft.restaurant.service;

import com.gft.restaurant.entity.Booking;
import com.google.gson.Gson;
import io.muserver.MuRequest;
import io.muserver.MuResponse;
import io.muserver.RouteHandler;
import java.util.List;
import java.util.Map;

public class RestaurantGetService implements RouteHandler {

    @Override
    public void handle(MuRequest request, MuResponse response, Map<String, String> pathParams) {
        
        Booking newBooking = new Booking();
//        List<Booking> bookings = newBooking.getAllBookings();
//        System.out.println("All Bookings" + new Gson().toJson(bookings));
//        response.sendChunk(new Gson().toJson(bookings));
        
        
        String queryParam = request.query().get("param");
        System.out.println(queryParam);
        Booking bookingByDate = newBooking.findByDate(queryParam);
        response.sendChunk(new Gson().toJson(bookingByDate));
        
//        List<String> somethingList = request.query().getAll("something");

//        response.sendChunk(" / " + somethingList + " / ");

        // You can loop through all query string values
//        for (Map.Entry<String, List<String>> entry : request.query().all().entrySet()) {
//            response.sendChunk('\n' + entry.getKey() + "=" + entry.getValue());
//        }
    }

}
