
package com.gft.restaurant.service;

import com.gft.restaurant.entity.Booking;
import com.google.gson.Gson;
import io.muserver.MuRequest;
import io.muserver.MuResponse;
import io.muserver.RouteHandler;
import java.util.Map;


public class RestaurantGetByDateService implements RouteHandler{

    @Override
    public void handle(MuRequest request, MuResponse response, Map<String, String> pathParams) {
        
        Booking newBooking = new Booking();

        String queryParam = request.query().get("param");
        System.out.println(queryParam);
        Booking bookingByDate = newBooking.findByDate(queryParam);
        response.sendChunk(new Gson().toJson(bookingByDate));
        
    }
    
}
