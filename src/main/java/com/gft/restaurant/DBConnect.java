
package com.gft.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBConnect {
    Connection connect = null;
    String user="root";
    String password="root";
    String database="bookings";
    String ip="127.0.0.1";
    String port="8889";
    
    String chain = "jdbc:mysql://"+ip+":"+port+"/"+database;
    
    public Connection connectionDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(chain, user, password);
            JOptionPane.showMessageDialog(null, "success connection");
        } catch( Exception e) {
            JOptionPane.showMessageDialog(null, "no connection"+ e.toString());
        }
        return connect;
    }
}
