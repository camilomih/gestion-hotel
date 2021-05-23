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
public class Empleado {
    private String usuario;
    private String firstname;
    private String lastname;
    private String email;
    private String contraseña;

    public Empleado(String usuario, String firstname, String lastname, String email, String contraseña) {
        this.usuario = usuario;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Empleado() {
        super();
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Empleado{" + "usuario=" + usuario + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}
