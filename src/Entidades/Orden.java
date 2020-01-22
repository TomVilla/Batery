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
public class Orden {
    private String idOrden;
    private String idCliente;
    private String cedulaUser;
    private String fecha;
    private int descuento;
    private String placa;
    private double iva;
    private double subtotal;
    private double total;

    public Orden(String idOrden, String idCliente, String cedulaUser, String fecha, int descuento, String placa, double iva, double subtotal, double total) {
        this.idOrden = idOrden;
        this.idCliente = idCliente;
        this.cedulaUser = cedulaUser;
        this.fecha = fecha;
        this.descuento = descuento;
        this.placa = placa;
        this.iva = iva;
        this.subtotal = subtotal;
        this.total = total;
    }
    
}
