/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.dto;

/**
 *
 * @author User
 */
public class Habitacion {
    private Integer id;
    private String codigo;
    private boolean disponibilidad;
    private Integer totalCamas;

    public Habitacion() {
        super();
    }

    public Habitacion(Integer id, String codigo, boolean disponibilidad, Integer totalCamas) {
        this.id = id;
        this.codigo = codigo;
        this.disponibilidad = disponibilidad;
        this.totalCamas = totalCamas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Integer getTotalCamas() {
        return totalCamas;
    }

    public void setTotalCamas(Integer totalCamas) {
        this.totalCamas = totalCamas;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id=" + id + ", codigo=" + codigo + ", disponibilidad=" + disponibilidad + ", totalCamas=" + totalCamas + '}';
    }
    
    
    
}
