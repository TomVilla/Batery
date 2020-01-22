/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Connected.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jeanca Moreano
 */
public class VentanaCliente {
    private Conexion conectar;
    private BorderPane root;
    private Label agregar;
    private Label consultar;
    private VBox panel;
    private Label lblCedula;
    private TextField txtCedula;
    private Label lblNombre;
    private TextField txtNombre;
    private Label lblApellidos;
    private TextField txtApellidos;
    private Label lblDireccion;
    private TextField txtDireccion;
    private Label lblTelefono;
    private TextField txtTelefono;
    private Label lblEmail;
    private TextField txtEmail;
    private Button back;
    private TextField busqueda;
    private GridPane contenedorBusqueda;
    
    public VentanaCliente(){
        root = new BorderPane();
        conectar=new Conexion();
        createCenter();
        
        
    }
    
    private void createCenter(){
        HBox con=new HBox();
        agregar= new Label("AGREGAR     ");
        agregar.setOnMouseClicked(e->{
            panelCentralAgregar();
        });
        
        consultar=new Label("CONSULTAR     ");
        consultar.setOnMouseClicked(e->{
            panelCentralBuscar();
        });
        con.setSpacing(5);
        con.getChildren().addAll(agregar,consultar);
        con.setAlignment(Pos.CENTER);
        root.setTop(con);
        
    }
    
    public void panelCentralAgregar(){
        if(panel==null){
            panel=new VBox();
        }else{   
            panel.getChildren().clear();
        }
        GridPane p=new GridPane();
        lblCedula= new Label("Cedula:  ");
        txtCedula= new TextField();
        lblNombre= new Label("Nombre:  ");
        txtNombre= new TextField();
        lblApellidos= new Label("Apellido:  ");
        txtApellidos= new TextField();
        lblDireccion= new Label("Direccion:  ");
        txtDireccion= new TextField();
        lblTelefono= new Label("Telefono:  ");
        txtTelefono= new TextField();
        lblEmail= new Label("Correo:  ");
        txtEmail= new TextField();
        HBox conB=new HBox();
        Button guardar=new Button("GUARDAR");
        guardar.setOnAction(e->{
            System.out.println("no f");
            accionGuardarCliente();
        });
        if(back==null)
            back=new Button("RETROCEDER");
        back.setOnAction(e->{
            Cargar_Scene(new Principal().getRoot(),"PRINCIPAL",1500,1500);
        });
        conB.getChildren().addAll(guardar,back);
        conB.setSpacing(10);
        conB.setAlignment(Pos.CENTER);
        p.add(lblCedula,0,0);p.add(txtCedula,1,0);
        p.add(lblNombre,0,1);p.add(txtNombre,1,1);
        p.add(lblApellidos,0,2);p.add(txtApellidos,1,2);
        p.add(lblDireccion,0,3);p.add(txtDireccion,1,3);
        p.add(lblTelefono,0,4);p.add(txtTelefono,1,4);
        p.add(lblEmail,0,5);p.add(txtEmail,1,5);
        p.setAlignment(Pos.CENTER);
        panel.getChildren().addAll(p,conB);
        root.setCenter(panel);
    }
    
    public void panelCentralBuscar(){
        if(panel==null){
            panel=new VBox();
        } else{   
            panel.getChildren().clear();
        }
        VBox con=new VBox();
        Label lblModificar=new  Label("Ingrese cedula del cliente a consultar");
        busqueda=new TextField();
        
        HBox con2=new HBox();
        Button buscar=new Button("BUSCAR");
        buscar.setOnAction(e->{
            if(contenedorBusqueda==null)
                contenedorBusqueda=resultadoBusqueda(busqueda.getText().trim());
            else{
                contenedorBusqueda.getChildren().clear();
                contenedorBusqueda=resultadoBusqueda(busqueda.getText().trim());
            }
            con.getChildren().add(contenedorBusqueda);
            
        });
        if(back==null)
            back=new Button("RETROCEDER");
        
        con2.getChildren().addAll(buscar,back);
        con2.setSpacing(7);
        
        con.getChildren().addAll(lblModificar,busqueda, con2);
        
        panel.getChildren().add(con);
    }
    
   
    
    public GridPane resultadoBusqueda(String cedula){
        String [] datos=consultarCliente(cedula);
        GridPane p=new GridPane();
        
        Label lblCedula= new Label("Cedula:  ");
        TextField txtCedula= new TextField();
        txtCedula.setText(datos[0]);
        
        Label lblNombre= new Label("Nombre:  ");
        TextField txtNombre= new TextField();
        txtNombre.setText(datos[1]);
        
        Label lblApellidos= new Label("Apellido:  ");
        TextField txtApellidos= new TextField();
        txtApellidos.setText(datos[2]);
        
        Label lblDireccion= new Label("Direccion:  ");
        TextField txtDireccion= new TextField();
        txtDireccion.setText(datos[3]);
        
        Label lblTelefono= new Label("Telefono:  ");
        TextField txtTelefono= new TextField();
        txtTelefono.setText(datos[4]);
        
        Label lblEmail= new Label("Email:  ");
        TextField txtEmail= new TextField();
        txtEmail.setText(datos[5]);
        
        p.add(lblCedula,0,0);p.add(txtCedula,1,0);
        p.add(lblNombre,0,1);p.add(txtNombre,1,1);
        p.add(lblApellidos,0,2);p.add(txtApellidos,1,2);
        p.add(lblDireccion,0,3);p.add(txtDireccion,1,3);
        p.add(lblTelefono,0,4);p.add(txtTelefono,1,4);
        p.add(lblEmail,0,5);p.add(txtEmail,1,5);
        return p;
    }
    public String[] consultarCliente(String cedula) {
        String[] datos= new String[6];
        try {
            Statement s = conectar.getConection().createStatement();
            ResultSet rs = s.executeQuery ("select * from cliente");
            while(rs.next()){
                if(cedula.equals(rs.getString(1))){
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
    

    public void Cargar_Scene(Parent r,String titulo,int width,int heigth)  {
        Stage st= (Stage)root.getScene().getWindow();
        st.setTitle(titulo);
        st.getScene().setRoot(r);
        st.setWidth(width);
        st.setHeight(heigth);
    }
    
    public void accionGuardarCliente(){
        Connection cn = conectar.getConection();
            String ced,nom, ape,dir,tel,ema;
            String sql = "";
            ced = txtCedula.getText();
            nom = txtNombre.getText();
            ape = txtApellidos.getText();
            tel= txtTelefono.getText();
            dir = txtDireccion.getText();
            ema=txtEmail.getText();
            sql = "INSERT INTO cliente VALUES (?,?,?,?,?,?)";
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1,ced);
                psd.setString(2,nom);
                psd.setString(3,ape);
                psd.setString(4,dir);
                psd.setString(5,tel);
                psd.setString(6,ema);
                int indicador = psd.executeUpdate();
                
                if (indicador > 0)
                {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setHeaderText("Aviso");
                    alerta.setContentText("El cliente se registró con éxito");
                    alerta.showAndWait();
                    limpiarTextField();
                }
            }catch (SQLException ex) 
            {
                Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    public void limpiarTextField(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
    
    }
    
    public BorderPane getRoot() {
        return root;
    }
    
    
}
