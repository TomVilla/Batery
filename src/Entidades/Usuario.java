/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Jeanca Moreano
 */
public class Usuario {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String email;
    private String rol;
    private String password;
    private String fechaNacimiento;

    public Usuario(String cedula, String Nombres, String Apellidos, String Telefono, String direccion, String email, String rol, String password, String fechaNacimiento) {
        this.cedula = cedula;
        this.nombres = Nombres;
        this.apellidos = Apellidos;
        this.telefono = Telefono;
        this.direccion = direccion;
        this.email = email;
        this.rol = rol;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
