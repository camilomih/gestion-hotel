/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.service;

import gestionhotel.database.EmpleadoDB;
import gestionhotel.dto.Empleado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class EmpleadoService {

    public boolean loginUser(String username, String contraseña) throws Exception {
        EmpleadoDB empleadoDB = new EmpleadoDB();
        Empleado empleado = empleadoDB.getUsuarioByUsername(username);
        System.out.println("em " + empleado);

        if (empleado.getContraseña() != null && empleado.getContraseña().equals(contraseña)) {
            return true;
        } else {
            return false;
        }
    }

    public Empleado getInfoEmpleado(String username) throws Exception {
        EmpleadoDB empleadoDB = new EmpleadoDB();
        Empleado empleado = empleadoDB.getUsuarioByUsername(username);
        return empleado;
    }

    public List<Empleado> getAllEmpleados() throws Exception {
        EmpleadoDB empleadoDB = new EmpleadoDB();
        return empleadoDB.getUsuarios();
    }

    public Empleado createEmpleado(Empleado empleado) throws Exception {
        EmpleadoDB empleadoDB = new EmpleadoDB();
        empleadoDB.createEmpleado(empleado);

        return empleado;
    }

    public Empleado editEmpleado(Empleado empleado) {
        EmpleadoDB empleadoDB = new EmpleadoDB();
        try {
            empleadoDB.editEmpleado(empleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleado;
    }

    public void deleteEmpleado(String username) {
        EmpleadoDB empleadoDB = new EmpleadoDB();
        try {
            empleadoDB.deleteEmpleado(username);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
