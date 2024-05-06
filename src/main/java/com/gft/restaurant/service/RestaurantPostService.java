package com.gft.restaurant.service;

import com.gft.restaurant.entity.Booking;
import com.google.gson.Gson;
import io.muserver.MuRequest;
import io.muserver.MuResponse;
import io.muserver.RouteHandler;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RestaurantPostService implements RouteHandler {

    @Override
    public void handle(MuRequest request, MuResponse response, Map<String, String> pathParams) throws IOException, InterruptedException {
        
        String customer = request.form().get("customer");
        String date = request.form().get("date");
        String time = request.form().get("time");
        String timeSlot = request.form().get("time");

        Booking newBooking = new Booking();
        newBooking.saveBooking(customer, date, time, timeSlot);
        
        newBooking.setCustomer(customer);
        newBooking.setDate(date);
        newBooking.setTime(time);
        newBooking.setTimeSlot(timeSlot);
        
        response.contentType("text/html;charset=utf-8");
                response.sendChunk("Will send some chunks...<br>");
                for (int i = 0; i < 10; i++) {
                    response.sendChunk("Chunk " + i + "<br>");
                    Thread.sleep(500);
                }
                response.sendChunk("<br>Response complete.<br>");
        response.sendChunk(new Gson().toJson(newBooking));
                
    }

}
