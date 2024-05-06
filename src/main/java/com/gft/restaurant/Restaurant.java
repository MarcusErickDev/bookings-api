package com.gft.restaurant;

//import com.gft.restaurant.entity.Booking;
//import com.gft.restaurant.persistence.BookingPersistenceController;
import com.gft.restaurant.service.RestaurantGetByDateService;
import com.gft.restaurant.service.RestaurantGetService;
import com.gft.restaurant.service.RestaurantPostService;
import io.muserver.Method;
import io.muserver.MuServer;
import static io.muserver.MuServerBuilder.httpServer;

public class Restaurant {

    public static void main(String[] args) {

//        DBConnect connectionDB = new DBConnect();
//        connectionDB.connectionDB();
//        BookingPersistenceController persistenceController = new BookingPersistenceController();
        MuServer server = httpServer()
                .withHttpPort(8080)
                .addHandler(Method.POST, "/book", new RestaurantPostService())
                .addHandler(Method.GET, "/", new RestaurantGetService())
                .addHandler(Method.GET, "/query", new RestaurantGetByDateService())
                .start();
        System.out.println("Started server at " + server.uri());
        System.out.println("Form data example (requires POST): " + server.uri().resolve("/book"));

    }
}
