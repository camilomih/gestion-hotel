/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel;

import gestionhotel.database.ConexionDB;
import gestionhotel.database.EmpleadoDB;
import gestionhotel.dto.Empleado;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class GestionHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        EmpleadoDB empleado = new EmpleadoDB();
        boolean isEdit = empleado.deleteEmpleado("camilo");
        System.out.println(isEdit);
    }

}
