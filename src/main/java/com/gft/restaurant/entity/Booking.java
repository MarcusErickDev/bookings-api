
package com.gft.restaurant.entity;

import com.gft.restaurant.DBConnect;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;


//@Table(name="bookings")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Booking implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    
    private String customer;
    private String date;
    private String time;
    private String timeSlot;

    public Booking() {
    }

    public Booking(int id, String customer, String date, String time, String timeSlot) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.time = time;
        this.timeSlot = timeSlot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    public void saveBooking( String customer, String date, String time, String timeSlot){
        
        setCustomer(customer);
        setDate(date);
        setTime(time);
        setTimeSlot(timeSlot);
        
        DBConnect connectionDB = new DBConnect();
        
        String query = "insert into Bookings (customer,date,time,timeSlot) values (?,?,?,?);";
        
        try {
            
            CallableStatement cs = connectionDB.connectionDB().prepareCall(query);
            
            cs.setString( 1, getCustomer() );
            cs.setString( 2, getDate() );
            cs.setString( 3, getTime() );
            cs.setString( 4, getTimeSlot() );
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "correct insert");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "incorrect insert" + e.toString() );
        }
        
    }
    
    
    public List<Booking> getAllBookings(){
        
        DBConnect connectionDB = new DBConnect();
        
        String sql="select * from Bookings;";
        
//        String[] data = new String[5];
        List<Booking> bookings = new ArrayList<Booking>();
        Statement st;
        
        try {
            
            st = connectionDB.connectionDB().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
//                data[0] = rs.getString(1);
//                data[1] = rs.getString(2);
//                data[2] = rs.getString(3);
//                data[3] = rs.getString(4);
//                data[4] = rs.getString(5);
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setCustomer(rs.getString("customer"));
                booking.setDate(rs.getString("date"));
                booking.setTime(rs.getString("time"));
                booking.setTimeSlot(rs.getString("timeSlot"));
                bookings.add(booking);
            }
            
                                      
        } catch (Exception e) {
            
        }
        
        return bookings;
    }

    public Booking findByDate(String queryParam){
        String query = "select id,customer,date,time,timeSlot from Bookings where Bookings.date=(?);";
        DBConnect connectionDB = new DBConnect();
//        Statement st;
        Booking bookingByDate = new Booking();
        try {
            
//            st = connectionDB.connectionDB().createStatement();
            CallableStatement cs = connectionDB.connectionDB().prepareCall(query);
            cs.setString(1,queryParam);
            cs.execute();
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()){
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setCustomer(rs.getString("customer"));
                booking.setDate(rs.getString("date"));
                booking.setTime(rs.getString("time"));
                booking.setTimeSlot(rs.getString("timeSlot"));
                bookingByDate = booking;
                return bookingByDate;
            }
            
                
        } catch (Exception e){
            
        }
        
        return bookingByDate;
    }

}
