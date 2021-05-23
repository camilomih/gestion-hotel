/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.database;

import gestionhotel.dto.Empleado;
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
public class EmpleadoDB {

    public List<Empleado> getUsuarios() throws Exception {
        List<Empleado> empleados = new ArrayList<>();
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select username,firstname,lastname,email,contraseña from usuario");
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setUsuario(rs.getString("username"));
                empleado.setFirstname(rs.getString("firstname"));
                empleado.setLastname(rs.getString("lastname"));
                empleado.setEmail(rs.getString("email"));
                empleado.setContraseña(rs.getString("contraseña"));
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return empleados;
    }

    public Empleado getUsuarioByUsername(String username) throws Exception {
        Empleado empleado = new Empleado();
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        try {

            PreparedStatement stmt = conn.prepareStatement("select username,firstname,lastname,email,contraseña from usuario where username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                empleado.setUsuario(rs.getString("username"));
                empleado.setFirstname(rs.getString("firstname"));
                empleado.setLastname(rs.getString("lastname"));
                empleado.setEmail(rs.getString("email"));
                empleado.setContraseña(rs.getString("contraseña"));
            }

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return empleado;
    }

    public boolean createEmpleado(Empleado empleado) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean createdEmpleado = false;
        try {

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuario(username,firstname,lastname,email,contraseña) VALUES(?,?,?,?,?)");
            stmt.setString(1, empleado.getUsuario());
            stmt.setString(2, empleado.getFirstname());
            stmt.setString(3, empleado.getLastname());
            stmt.setString(4, empleado.getEmail());
            stmt.setString(5, empleado.getContraseña());
            createdEmpleado = stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return createdEmpleado;
    }

    public boolean editEmpleado(Empleado empleado) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean createdEmpleado = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET firstname = ?, lastname = ?, email = ?, contraseña = ? where username = ?");
            stmt.setString(1, empleado.getFirstname());
            stmt.setString(2, empleado.getLastname());
            stmt.setString(3, empleado.getEmail());
            stmt.setString(4, empleado.getContraseña());
            stmt.setString(5, empleado.getUsuario());
            createdEmpleado = stmt.execute();

        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return createdEmpleado;
    }
    
    public boolean deleteEmpleado(String username) throws Exception {
        ConexionDB con = new ConexionDB();
        Connection conn = con.getConnection();
        boolean deletedEmpleado = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("delete from usuario where username = ?");
            stmt.setString(1, username);
            deletedEmpleado = stmt.execute();
        } catch (SQLException e) {
            throw new Exception("Error al consultar", e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return deletedEmpleado;
    }
}
