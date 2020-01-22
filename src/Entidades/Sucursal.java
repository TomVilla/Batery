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
public class Sucursal {
    private String idSucursal;
    private String direccion;
    private String cedulaUser;

    public Sucursal(String idSucursal, String direccion, String cedulaUser) {
        this.idSucursal = idSucursal;
        this.direccion = direccion;
        this.cedulaUser = cedulaUser;
    }
    
}
