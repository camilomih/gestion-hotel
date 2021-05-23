/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.service;

import gestionhotel.database.HabitacionDB;
import gestionhotel.database.ReservaDB;
import gestionhotel.dto.Reserva;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ReservaService {

    private ReservaDB reservaDB;
    private HabitacionDB habitacionDB;

    public ReservaService() {
        reservaDB = new ReservaDB();
        habitacionDB = new HabitacionDB();
    }

    public List<Reserva> getReservas() {
        List<Reserva> reservas = null;
        try {
            reservas = reservaDB.getReservas();
        } catch (Exception ex) {
            Logger.getLogger(ReservaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservas;
    }

    public Reserva crearReserva(Reserva reserva) {
        try {
            reservaDB.createReserva(reserva);
            habitacionDB.editHabitacion(false, reserva.getIdHabitacion());
        } catch (Exception ex) {
            Logger.getLogger(ReservaService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reserva;
    }

    public Reserva editReserva(Reserva reserva) {
        try {
            reservaDB.editReserva(reserva);
            habitacionDB.editHabitacion(!reserva.isActivo(), reserva.getIdHabitacion());
        } catch (Exception ex) {
            Logger.getLogger(ReservaService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reserva;
    }

    public void deleteReserva(Reserva reserva) {
        try {
            reservaDB.deleteReserva(reserva.getId());
            habitacionDB.editHabitacion(true, reserva.getIdHabitacion());
        } catch (Exception ex) {
            Logger.getLogger(ReservaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
