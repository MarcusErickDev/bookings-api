
package com.gft.restaurant;

import com.gft.restaurant.entity.Booking;
import com.gft.restaurant.persistence.BookingPersistenceController;
import com.gft.restaurant.service.RestaurantGetService;
import com.gft.restaurant.service.RestaurantPostService;
import com.google.gson.Gson;
import io.muserver.Method;
import io.muserver.MuServer;
//import io.muserver.MuServerBuilder;
import static io.muserver.MuServerBuilder.httpServer;
import java.util.Arrays;
import java.util.List;

public class Restaurant {

    public static void main(String[] args) {
        
//        DBConnect connectionDB = new DBConnect();
//        connectionDB.connectionDB();
        
//        BookingPersistenceController persistenceController = new BookingPersistenceController();
                
//        Booking newBooking = new Booking();
//        List<Booking> bookings = newBooking.getAllBookings();
//        System.out.println("All Bookings" + new Gson().toJson(bookings));
        
//        newBooking.saveBooking("Erick","06-05-2024","14:00","14-16");
//        newBooking.setId(0);
//        newBooking.setCustomer("Customer Name");
//        newBooking.setDate("03/05/2024");
//        newBooking.setTime("13:00");
//        newBooking.setTimeSlot("13:00 to 15:00");
//        System.out.println("New Booking created " + newBooking);        
//        System.out.println("New Booking created " + new Gson().toJson(newBooking));
       
//        MuServer server = httpServer()
//                        .addHandler(Method.POST, "/book", new RestaurantPostService())
//                        .start();
//        System.out.println("Form data example (requires POST): " + server.uri().resolve("/book"));
        
        
        MuServer server = httpServer()
                .withHttpPort(8080)
//                .addHandler(Method.GET, "/", new RestaurantGetService())
                .addHandler(Method.GET, "/query", new RestaurantGetService())
                .start();
        System.out.println("Form data example (requires POST): " + server.uri().resolve("/book"));
//            .addHandler(Method.GET, "/", (request, response, pathParams) -> {
//                response.write("Hello, world");
//            })
//            .start();
//        System.out.println("Started server at " + server.uri());
    }
}
