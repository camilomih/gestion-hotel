/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConexionDB {

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://database-mysql.cybt6irrev7m.us-east-2.rds.amazonaws.com:3306/hotel_verde","admin","database30");
            System.out.println("Ok conexion");

        } catch (SQLException e) {
            throw new Error("Problema", e);
        }
        
        return conn;
    }
}
