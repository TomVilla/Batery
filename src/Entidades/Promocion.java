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
public class Promocion {
    private String idPromocion;
    private String descuentoProm;
    private float porcenPromocion;
    private String publicidad;
    private String fechaInicio;
    private String fechaFin;

    public Promocion(String idPromocion, String descuentoProm, float porcenPromocion, String publicidad, String fechaInicio, String fechaFin) {
        this.idPromocion = idPromocion;
        this.descuentoProm = descuentoProm;
        this.porcenPromocion = porcenPromocion;
        this.publicidad = publicidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    
}
