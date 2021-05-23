/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.dto;

import java.util.Date;

/**
 *
 * @author User
 */
public class Reserva {

    private Integer id;
    private String cedulaCliente;
    private String nombreCliente;
    private String idHabitacion;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean activo;

    public Reserva(Integer id, String cedulaCliente, String nombreCliente, String idHabitacion, Date fechaInicio, Date fechaFin, boolean activo) {
        this.id = id;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.idHabitacion = idHabitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = activo;
    }

    public Reserva() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", cedulaCliente=" + cedulaCliente + ", nombreCliente=" + nombreCliente + ", idHabitacion=" + idHabitacion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", activo=" + activo + '}';
    }
    
    

}
