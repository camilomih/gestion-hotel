/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.database;

import gestionhotel.dto.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class HabitacionDB {

    public List<Habitacion> getHabitaciones() throws Exception {
        List<Habitacion> habitaciones = new ArrayList<>();
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id,codigo,disponibilidad,total_camas from habitacion");
            while (rs.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setId(rs.getInt("id"));
                habitacion.setCodigo(rs.getString("codigo"));
                habitacion.setDisponibilidad(rs.getBoolean("disponibilidad"));
                habitacion.setTotalCamas(rs.getInt("total_camas"));
                habitaciones.add(habitacion);
            }

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return habitaciones;
    }

    public Habitacion getHabitacionByCodigo(String codigo) throws Exception {
        Habitacion habitacion = null;
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        try {

            PreparedStatement stmt = conn.prepareStatement("select id,codigo,disponibilidad,total_camas from habitacion where codigo = ?");
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                habitacion = new Habitacion();
                habitacion.setId(rs.getInt("id"));
                habitacion.setCodigo(rs.getString("codigo"));
                habitacion.setDisponibilidad(rs.getBoolean("disponibilidad"));
                habitacion.setTotalCamas(rs.getInt("total_camas"));
            }

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return habitacion;
    }

    public boolean createHabitacion(Habitacion habitacion) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean createdHabitacion = false;
        try {

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO habitacion(codigo,disponibilidad,total_camas) VALUES(?,?,?)");
            stmt.setString(1, habitacion.getCodigo());
            stmt.setBoolean(2, habitacion.isDisponibilidad());
            stmt.setInt(3, habitacion.getTotalCamas());
            createdHabitacion = stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return createdHabitacion;
    }

    public boolean editHabitacion(boolean dispo, String codigo) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean createdHabitacion = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE habitacion SET disponibilidad = ? where codigo = ?");
            stmt.setBoolean(1, dispo);
            stmt.setString(2, codigo);
            createdHabitacion = stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return createdHabitacion;
    }

    public boolean deleteHabitacion(String codigo) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean createdHabitacion = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("delete from habitacion where codigo = ?");
            stmt.setString(1, codigo);
            createdHabitacion = stmt.execute();
        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return createdHabitacion;
    }
    
    public List<Habitacion> getHabitacionesLibres() throws Exception {
        List<Habitacion> habitaciones = new ArrayList<>();
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id,codigo,disponibilidad,total_camas from habitacion where disponibilidad = true");
            while (rs.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setId(rs.getInt("id"));
                habitacion.setCodigo(rs.getString("codigo"));
                habitacion.setDisponibilidad(rs.getBoolean("disponibilidad"));
                habitacion.setTotalCamas(rs.getInt("total_camas"));
                habitaciones.add(habitacion);
            }

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return habitaciones;
    }

}
