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
public class DetalleOrden {
    private String idDetalle;
    private String idOrden;
    private String idProducto;
    private int cantidad;
    private double precio;
    private String idPromocion;
    
    public DetalleOrden(String idDetalle, String idOrden, String idProducto, int cantidad, double precio) {
        this.idDetalle = idDetalle;
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    

    public DetalleOrden(String idDetalle, String idOrden, String idProducto, int cantidad, double precio, String idPromocion) {
        this.idDetalle = idDetalle;
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idPromocion = idPromocion;
    }

    @Override
    public String toString() {
        return  idOrden ;
    }

    public String getIdDetalle() {
        return idDetalle;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getIdPromocion() {
        return idPromocion;
    }

    
}
