/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Connected.Conexion;
import Entidades.Cliente;
import Entidades.Producto;
import Entidades.DetalleOrden;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;


/**
 *
 * @author Jeanca Moreano
 */
public class VentanaOrden {
    private BorderPane root;
    private Button volver;
    private VBox cabezeraIzquierda;
    private VBox cabezeraDerecha;
    private HBox panelInferior;
    private HBox cabezera;
    private Label fecha,cliente,direccion,telefono,total;
    private Label factura,facturaId;
    private TableView tableView ;
    private Conexion conectar;
    
    public VentanaOrden(){
        
        root = new BorderPane();
        cabezeraIzquierda = new VBox();
        cabezeraDerecha = new VBox();
        cabezera = new HBox();
        tableView = new TableView();
        
        
        TableColumn<String, String> column1 = new TableColumn<>("Codigo");
        column1.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        
        tableView.getItems().add(VentanaPedido.pedidos.get(3));

        TableColumn<String, String> column2 = new TableColumn<>("Producto");
        column2.setCellValueFactory(new PropertyValueFactory<>("prodcuto"));
        
        TableColumn<String, String> column3 = new TableColumn<>("Cantidad");
        column3.setCellValueFactory(new PropertyValueFactory<>("cantidad"));


        TableColumn<String, String> column4 = new TableColumn<>("Precio Unitario");
        column4.setCellValueFactory(new PropertyValueFactory<>("Precio Unitario"));
        
        TableColumn<String, String> column5 = new TableColumn<>("Descuento");
        column5.setCellValueFactory(new PropertyValueFactory<>("Descuento"));
        
        TableColumn<String, String> column6 = new TableColumn<>("Subtotal");
        column6.setCellValueFactory(new PropertyValueFactory<>("Subtotal"));


        TableColumn<String, String> column7 = new TableColumn<>("IVA");
        column7.setCellValueFactory(new PropertyValueFactory<>("IVA"));
        
        TableColumn<String, String> column8 = new TableColumn<>("TOTAL");
        column8.setCellValueFactory(new PropertyValueFactory<>("TOTAL"));
        
        tableView.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8);
        tableView.setPrefHeight(50);
        root.setCenter(tableView);
        
        fecha = new Label("FECHA: ");
        fecha.setFont(Font.font("Arial", 15));
        
        cliente = new Label("CLIENTE: ");
        cliente.setFont(Font.font("Arial", 15));
        
        direccion = new Label("DIRECCION: ");
        direccion.setFont(Font.font("Arial", 15));
        
        telefono = new Label("TELEFONO: ");
        telefono.setFont(Font.font("Arial", 15));
        
        cabezeraIzquierda.getChildren().addAll(new Label("  "), new Label(" "),new Label(" "),fecha,cliente,direccion,telefono,new Label(""));
        cabezeraIzquierda.setSpacing(10);
        
        factura = new Label("FACTURA");
        factura.setFont(Font.font("Arial", 20));
        
        facturaId = new Label("");
        facturaId.setText(new VentanaPedido().getPedidos().get(0).getIdOrden());
        facturaId.setFont(Font.font("Arial", 15));
        facturaId.setAlignment(Pos.CENTER);
        
        
        cabezeraDerecha.getChildren().addAll(factura,facturaId);
        cabezera.getChildren().addAll(cabezeraIzquierda,cabezeraDerecha);
        cabezera.setSpacing(440);
        
        root.setTop(cabezera);
        
        panelInferior = new HBox();
        total = new Label("TOTAL: 100");
        total.setFont(Font.font("Arial", 15));
        
        volver = new Button("VOLVER");
        volver.setOnAction(e->{
            Cargar_Scene(new Principal().getRoot(),"Bienvenido", 1500, 1500);
            VentanaPedido.pedidos.clear();
            
        });
        
        panelInferior.getChildren().addAll(volver,total);
        panelInferior.setAlignment(Pos.BOTTOM_RIGHT);
        panelInferior.setSpacing(480);
        
        root.setBottom(panelInferior);
        
    }

    public void Cargar_Scene(Parent r,String titulo,int width,int heigth)  {
        Stage st= (Stage)root.getScene().getWindow();
        st.setTitle(titulo);
        st.getScene().setRoot(r);
        st.setWidth(width);
        st.setHeight(heigth);
    }
    
    public BorderPane getRoot() {
        return root;
    }
    public String[] consultarProducto(String idProducto) {
        String[] datos= new String[6];
        try {
            Statement s = conectar.getConection().createStatement();
            ResultSet rs = s.executeQuery ("select * from producto");
            while(rs.next()){
                if(idProducto.equals(rs.getString(1))){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    datos[5]=rs.getString(6);      
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
}
