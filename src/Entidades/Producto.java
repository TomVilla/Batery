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
public class Producto {
    private String idProducto;
    private String idPromocion;
    private String nombreProducto;
    private float precio;
    private float iva;
    private String tipoProducto;
    private int stock;

    public Producto(String idProducto, String idPromocion,String idSucursal, String nombreProducto, float precio, float iva, String tipoProducto, int stock) {
        this.idProducto = idProducto;
        this.idPromocion = idPromocion;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.iva = iva;
        this.tipoProducto = tipoProducto;
        this.stock = stock;
    }

    public Producto(String idProducto, String nombreProducto, float precio, float iva, String tipoProducto, int stock) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.iva = iva;
        this.tipoProducto = tipoProducto;
        this.stock = stock;
    }
    
}
