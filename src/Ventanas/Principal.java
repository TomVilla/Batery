/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Principal {
     private BorderPane root;
     private ImageView factura;
     
     private ImageView productos;
     
     private ImageView clientes;
     
     private ImageView salir;
     
     HBox f;

    public Principal() {
        root=new BorderPane();
        createCenter();
      
    }
   
    
    public void createCenter(){
        GridPane contenedor=new GridPane();
        VBox con1=new VBox();
        VBox con2=new VBox();
        VBox con3=new VBox();
        VBox con4=new VBox();
         try {
             
             factura=new ImageView(new Image(new FileInputStream("src/Recursos/factura.png")));
             factura.setFitHeight(300);
             factura.setFitWidth(300);
             
             con1.getChildren().addAll(factura, new Label("Orden de venta"));
             con1.setOnMouseClicked(e->{
                 Cargar_Scene(new VentanaOrden().getRoot(),"Orden de venta", 1500, 1500);
             
             });
             
             productos=new ImageView(new Image(new FileInputStream("src/Recursos/inventario.png")));
             productos.setFitHeight(300);
             productos.setFitWidth(300);
             
             con2.getChildren().addAll(productos, new Label ("Producto"));
             con2.setOnMouseClicked(e->{
                 Cargar_Scene(new VentanaProducto().getRoot(),"Producto", 1500, 1500);
             
             });
             
             
             
             
             clientes=new ImageView(new Image(new FileInputStream("src/Recursos/usuario.png")));
             clientes.setFitHeight(300);
             clientes.setFitWidth(300);
             
             con3.getChildren().addAll(clientes, new Label ("Cliente"));
             con3.setOnMouseClicked(e->{
                 Cargar_Scene(new VentanaCliente().getRoot(),"Cliente", 1500, 1500);
             
             });
             
             
             salir=new ImageView(new Image(new FileInputStream("src/Recursos/salir.png")));
             salir.setFitHeight(300);
             salir.setFitWidth(300);
             
             con4.getChildren().addAll(salir, new Label ("Salir"));
             con4.setOnMouseClicked(e->{
                 Cargar_Scene(new Login().getRoot(),"Login", 500, 500);
             
             });
            
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         }
         contenedor.setAlignment(Pos.CENTER);
         contenedor.add(con1, 0, 0);
         contenedor.add(con2, 1, 0);
         contenedor.add(con3, 0, 1);
         contenedor.add(con4, 1, 1);
         root.setCenter(contenedor);
    
    }

    public BorderPane getRoot() {
        return root;
    }
    
    public void Cargar_Scene(Parent r,String titulo,int width,int heigth)  {
        Stage st= (Stage)root.getScene().getWindow();
        st.setTitle(titulo);
        st.getScene().setRoot(r);
        st.setWidth(width);
        st.setHeight(heigth);
    }
    
    
    
     
     
    
}
