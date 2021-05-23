/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.service;

import gestionhotel.database.HabitacionDB;
import gestionhotel.dto.Habitacion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class HabitacionService {

    private HabitacionDB habitacionDB;

    public HabitacionService() {
        habitacionDB = new HabitacionDB();
    }

    public Habitacion createHabitacion(Habitacion habitacion) throws Exception {
        try {
            Habitacion hab = habitacionDB.getHabitacionByCodigo(habitacion.getCodigo());
            if (hab != null) {
                return null;
            }

            habitacionDB.createHabitacion(habitacion);

            return habitacion;

        } catch (Exception ex) {
            Logger.getLogger(HabitacionService.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }
    }

    public List<Habitacion> getHabitaciones() {
        try {
            return habitacionDB.getHabitaciones();
        } catch (Exception ex) {
            Logger.getLogger(HabitacionService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Habitacion> getHabitacionesLibres() {
        try {
            return habitacionDB.getHabitacionesLibres();
        } catch (Exception ex) {
            Logger.getLogger(HabitacionService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void editHabitacion(boolean dispo, String codigo) throws Exception {
        habitacionDB.editHabitacion(dispo, codigo);
    }

    public void borrarHabitacion(String codigo) throws Exception {
        habitacionDB.deleteHabitacion(codigo);
    }

}
