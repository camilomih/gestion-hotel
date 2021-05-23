/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.database;

import gestionhotel.dto.Reserva;
import java.sql.Connection;
import java.sql.Date;
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
public class ReservaDB {

    public List<Reserva> getReservas() throws Exception {
        List<Reserva> reservas = new ArrayList<>();
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from reservas");
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setCedulaCliente(rs.getString("cedula_cliente"));
                reserva.setNombreCliente(rs.getString("nombre_cliente"));
                reserva.setIdHabitacion(rs.getString("id_habitacion"));
                reserva.setFechaInicio(rs.getDate("finicio"));
                reserva.setFechaFin(rs.getDate("ffin"));
                reserva.setActivo(rs.getBoolean("activo"));
                reservas.add(reserva);
            }

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return reservas;
    }

    public boolean createReserva(Reserva reserva) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean createReserva = false;
        try {

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO reservas (cedula_cliente,nombre_cliente,id_habitacion, finicio,ffin,activo) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, reserva.getCedulaCliente());
            stmt.setString(2, reserva.getNombreCliente());
            stmt.setString(3, reserva.getIdHabitacion());
            stmt.setDate(4, new java.sql.Date(reserva.getFechaInicio().getTime()));
            stmt.setDate(5, new java.sql.Date(reserva.getFechaFin().getTime()));
            stmt.setBoolean(6, reserva.isActivo());
            createReserva = stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return createReserva;
    }

    public boolean editReserva(Reserva reserva) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean createReserva = false;
        try {

            PreparedStatement stmt = conn.prepareStatement("UPDATE reservas set cedula_cliente = ?, nombre_cliente = ?, id_habitacion = ?, finicio= ?, ffin= ?, activo=? where id = ?");
            stmt.setString(1, reserva.getCedulaCliente());
            stmt.setString(2, reserva.getNombreCliente());
            stmt.setString(3, reserva.getIdHabitacion());
            stmt.setDate(4, new java.sql.Date(reserva.getFechaInicio().getTime()));
            stmt.setDate(5, new java.sql.Date(reserva.getFechaFin().getTime()));
            stmt.setBoolean(6, reserva.isActivo());
            stmt.setInt(7, reserva.getId());
            createReserva = stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return createReserva;
    }

    public boolean deleteReserva(Integer id) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean deletedReserva = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("delete from reservas where id = ?");
            stmt.setInt(1, id);
            deletedReserva = stmt.execute();
        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return deletedReserva;
    }
    

}
