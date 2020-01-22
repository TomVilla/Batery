/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Connected.Conexion;
import Entidades.DetalleOrden;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Jeanca Moreano
 */
public class VentanaPedido {
    private VBox root;
    private VBox fCedula,fFactura,fProducto,fCantidad,botonGuardar,botonAgregar,botonFactura,fCambio,fPlaca;
    private TextField cedula,factura,producto,cantidad,placa;
    private Label ced,nroFactura,pro,cant,pla;
    private Button agregar,verFactura;
    private ComboBox<String> tipoProducto = new ComboBox<>();
    public static ArrayList<DetalleOrden> pedidos = new ArrayList<>() ;
    private Conexion conectar ;
    
    private static int i = 1;
    
    public VentanaPedido(){
         conectar = new Conexion();
         root = new VBox();
         fCedula = new VBox();
         fFactura = new VBox();
         fProducto = new VBox();
         fCantidad = new VBox();
         botonGuardar = new VBox();
         botonAgregar = new VBox();
         botonFactura = new VBox();
         fCambio = new VBox();
         fPlaca = new VBox();
         tipoProducto.getItems().addAll("BATERIA","OTRO");
         
         cedula = new TextField();
         factura = new TextField();
         producto = new TextField();
         cantidad = new TextField();
         placa = new TextField();
         
         agregar = new Button("AGREGAR");
         agregar.setFont(Font.font("Times New Roman", 15));
         agregar.setAlignment(Pos.CENTER);
         agregar.setPrefWidth(140);
         verFactura = new Button("VER FACTURA");
         verFactura.setFont(Font.font("Times New Roman", 15));
         verFactura.setAlignment(Pos.CENTER);
         verFactura.setPrefWidth(140);
         
         botonAgregar.getChildren().add(agregar);
         botonAgregar.setAlignment(Pos.CENTER);
         botonFactura.getChildren().add(verFactura);
         botonFactura.setAlignment(Pos.CENTER);
         
         ced = new Label("INGRESE CEDULA CLIENTE");
         ced.setFont(Font.font("Times New Roman", 15));
         
         nroFactura = new Label("INGRESE NUMERO DE FACTURA");
         nroFactura.setFont(Font.font("Times New Roman", 15));
         
         pro = new Label("INGRESE ID DE PRODUCTO");
         pro.setFont(Font.font("Times New Roman", 15));
         
         cant = new Label("INGRESE CANTIDAD");
         cant.setFont(Font.font("Times New Roman", 15));
         
         pla = new Label("INGRESE PLACA DE VEHICULO");
         pla.setFont(Font.font("Times New Roman", 15));
                 
         fCedula.getChildren().addAll(ced,cedula);
         fCedula.setSpacing(10);
         fCedula.setAlignment(Pos.CENTER);
         
         fFactura.getChildren().addAll(nroFactura,factura);
         fFactura.setSpacing(10);
         fFactura.setAlignment(Pos.CENTER);
         
         
         
         
         
         root.getChildren().addAll(fCedula,fFactura,botonGuardar, tipoProducto,fCambio);
         root.setSpacing(10);
         
         
         tipoProducto.setOnAction(e->{
             
             if(tipoProducto.getValue().equalsIgnoreCase("OTRO")){
                 fProducto.getChildren().clear();
                 fCantidad.getChildren().clear();
                 fCambio.getChildren().clear();
                 
                 fProducto.getChildren().addAll(pro, producto);
                 fProducto.setSpacing(10);
                 fProducto.setAlignment(Pos.CENTER);

                 fCantidad.getChildren().addAll(cant, cantidad);
                 fCantidad.setSpacing(10);
                 fCantidad.setAlignment(Pos.CENTER);
                 
                 fCambio.getChildren().addAll(fProducto,fCantidad,agregar,verFactura);
                 fCambio.setSpacing(10);
                 fCambio.setAlignment(Pos.CENTER);
             }
             else{
                 fPlaca.getChildren().clear();
                 fCambio.getChildren().clear();
                 
                 
                 fPlaca.getChildren().addAll(pla,placa,agregar,verFactura);
                 fPlaca.setSpacing(10);
                 fPlaca.setAlignment(Pos.CENTER);
                 
                 fCambio.getChildren().addAll(fPlaca);
                 fCambio.setSpacing(10);
                 fCambio.setAlignment(Pos.CENTER);
             }
                 
         });
         
         agregar.setOnAction(e->{
             
             if (tipoProducto.getValue().equalsIgnoreCase("OTRO")) {
                 String[] busquedaProducto = consultarProducto(producto.getText());
                 String[] busquedaPromocion = consultarPromocion(busquedaProducto[1]);
                 DetalleOrden Do = new DetalleOrden(Integer.toString(i), factura.getText(), producto.getText(), Integer.parseInt(cantidad.getText()),Float.parseFloat(busquedaProducto[3]) ,busquedaPromocion[0]);
                 pedidos.add(Do);

                 i++;

                 producto.clear();
                 cantidad.clear();
             }
             else{
                 
             }
             
             
         });
         
         verFactura.setOnAction(e->{
             
                Cargar_Scene(new VentanaOrden().getRoot(),"Orden de venta", 658, 800);
         });
         
         
         
     }
    
    public void Cargar_Scene(Parent r,String titulo,int width,int heigth)  {
        Stage st= (Stage)root.getScene().getWindow();
        st.setTitle(titulo);
        st.getScene().setRoot(r);
        st.setWidth(width);
        st.setHeight(heigth);
    }
    public VBox getRoot() {
        return root;
    }

    public ArrayList<DetalleOrden> getPedidos() {
        return pedidos;
    }
    
     public String[] consultarProducto(String idProducto) {
        String[] datos= new String[7];
        try {
            Statement s = conectar.getConection().createStatement();
            ResultSet rs = s.executeQuery ("select * from producto");
            while(rs.next()){
                if(idProducto.equals(rs.getString(1))){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=Float.toString(rs.getFloat(4));
                    datos[4]=Float.toString(rs.getFloat(5));
                    datos[5]=rs.getString(6);      
                    datos[6]=Integer.toString(rs.getInt(7));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
     public String[] consultarPromocion(String idPromocion) {
        String[] datos= new String[5];
        try {
            Statement s = conectar.getConection().createStatement();
            ResultSet rs = s.executeQuery ("select * from promocion");
            while(rs.next()){
                if(idPromocion.equals(rs.getString(1))){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=Float.toString(rs.getFloat(3));
                    datos[3]=rs.getString(4);      
                    datos[4]=rs.getString(5);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    
    
    
}
