/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author user
 */
public class Info {
    String codigo;
    String producto;
    int cantidad;
    double precio;
    double descuento;
    double subtotal;

    public Info(String codigo, String producto, int cantidad, double precio, double descuento, double subtotal) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.subtotal = subtotal;
        
    }
    
}
