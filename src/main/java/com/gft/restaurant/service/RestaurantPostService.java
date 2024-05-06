package com.gft.restaurant.service;

import com.gft.restaurant.entity.Booking;
import io.muserver.MuRequest;
import io.muserver.MuResponse;
import io.muserver.RouteHandler;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RestaurantPostService implements RouteHandler {

    @Override
    public void handle(MuRequest request, MuResponse response, Map<String, String> pathParams) throws IOException {
        
        // Returns null if there is no parameter with that value
        String customer = request.form().get("customer");
        String date = request.form().get("date");
        String time = request.form().get("time");
        String timeSlot = request.form().get("time");

        // Specifying a default value:
//        String somethingElse = request.form().get("something", "default value");

        // Gets a number, or returns the default value if it's missing or not a number.
        // There are also getFloat, getDouble, getLong and getBoolean methods
//        int intValue = request.form().getInt("numberValue", 42);

//        boolean checkboxValue = request.form().getBoolean("checkboxValue");
        
        
        Booking newBooking = new Booking();
        newBooking.saveBooking(customer, date, time, timeSlot);
        
//        newBooking.setCustomer(customer);
//        newBooking.setDate(date);
//        newBooking.setTime(time);
//        newBooking.setTimeSlot(timeSlot);
        

//        response.sendChunk(something + "\n" + somethingElse + "\n" + intValue + "\n" + checkboxValue);
        response.sendChunk(customer + "\n" + date + "\n" + time + "\n" + timeSlot);

        // You can loop through all the form data
        response.sendChunk("\n\nLooping through all form values:");
        for (Map.Entry<String, List<String>> entry : request.form().all().entrySet()) {
            response.sendChunk('\n' + entry.getKey() + "=" + entry.getValue());
        }
    }

}
