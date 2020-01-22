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
public class VentanaProducto {
    private Conexion conectar;
    private BorderPane root;
    private Label agregar;
    private Label consultar;
    private VBox panel;
    private Label lblProducto;
    private TextField txtProducto;
    private Label lblPromocion;
    private TextField txtPromocion;
    private Label lblSucursal;
    private TextField txtSucursal;
    private Label lblNombre;
    private TextField txtNombre;
    private Label lblPrecio;
    private TextField txtPrecio;
    private Label lblIva;
    private TextField txtIva;
    private Label lblTipo;
    private TextField txtTipo;
    private Label lblStock;
    private TextField txtStock;
    private Button back;
    private TextField busqueda;
    private GridPane contenedorBusqueda;
    
    public VentanaProducto(){
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
        lblProducto= new Label("Id del producto:  ");
        txtProducto= new TextField();
        
        lblPromocion= new Label("Promocion:  ");
        txtPromocion= new TextField();
        
        lblSucursal= new Label("Sucursal:  ");
        txtSucursal= new TextField();
        
        lblNombre= new Label("Nombre del producto:  ");
        txtNombre= new TextField();
        
        lblPrecio= new Label("Precio:  ");
        txtPrecio= new TextField();
        
        lblIva= new Label("Iva:  ");
        txtIva= new TextField();
        
        lblTipo= new Label("Tipo de producto:  ");
        txtTipo= new TextField();
        
        lblStock= new Label("Stock:  ");
        txtStock= new TextField();
        
        HBox conB=new HBox();
        Button guardar=new Button("GUARDAR");
        guardar.setOnAction(e->{
            System.out.println("no f");
            accionGuardarProducto();
        });
        if(back==null)
            back=new Button("RETROCEDER");
        back.setOnAction(e->{
            Cargar_Scene(new Principal().getRoot(),"PRINCIPAL",1500,1500);
        });
        conB.getChildren().addAll(guardar,back);
        conB.setSpacing(10);
        conB.setAlignment(Pos.CENTER);
        p.add(lblProducto,0,0);p.add(txtProducto,1,0);
        p.add(lblPromocion,0,1);p.add(txtPromocion,1,1);
        p.add(lblSucursal,0,2);p.add(txtSucursal,1,2);
        p.add(lblNombre,0,3);p.add(txtNombre,1,3);
        p.add(lblPrecio,0,4);p.add(txtPrecio,1,4);
        p.add(lblIva,0,5);p.add(txtIva,1,5);
        p.add(lblTipo,0,6);p.add(txtTipo,1,6);
        p.add(lblStock,0,7);p.add(txtStock,1,7);
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
        Label lblModificar=new  Label("Ingrese el codigo a consultar");
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
    
   
    
    public GridPane resultadoBusqueda(String codigo){
        String [] datos=consultarProducto(codigo);
        GridPane p=new GridPane();
        
        Label lblProducto= new Label("Producto:  ");
        TextField txtProducto= new TextField();
        txtProducto.setText(datos[0]);
        
        Label lblPromocion= new Label("Promocion:  ");
        TextField txtPromocion= new TextField();
        txtPromocion.setText(datos[1]);
        
        Label lblSucursal= new Label("Sucursal:  ");
        TextField txtSucursal= new TextField();
        txtSucursal.setText(datos[2]);
        
        Label lblNombre= new Label("Nombre del producto:  ");
        TextField txtNombre= new TextField();
        txtNombre.setText(datos[3]);
        
        Label lblPrecio= new Label("Precio:  ");
        TextField txtPrecio= new TextField();
        txtPrecio.setText(datos[4]);
        
        Label lblIva= new Label("Iva:  ");
        TextField txtIva= new TextField();
        txtIva.setText(datos[5]);
        
        Label lblTipo= new Label("Tipo de producto:  ");
        TextField txtTipo= new TextField();
        txtTipo.setText(datos[6]);
        
        Label lblStock= new Label("Stock:  ");
        TextField txtStock= new TextField();
        txtStock.setText(datos[7]);
        
        p.add(lblProducto,0,0);p.add(txtProducto,1,0);
        p.add(lblPromocion,0,1);p.add(txtPromocion,1,1);
        p.add(lblSucursal,0,2);p.add(txtSucursal,1,2);
        p.add(lblNombre,0,3);p.add(txtNombre,1,3);
        p.add(lblPrecio,0,4);p.add(txtPrecio,1,4);
        p.add(lblIva,0,5);p.add(txtIva,1,5);
        p.add(lblTipo,0,6);p.add(txtTipo,1,6);
        p.add(lblStock,0,7);p.add(txtStock,1,7);
        return p;
    }
    public String[] consultarProducto(String codigo) {
        String[] datos= new String[8];
        try {
            Statement s = conectar.getConection().createStatement();
            ResultSet rs = s.executeQuery ("select p.idProducto,pr.Publicidad, s.Direccion,p. nombrePro,p.precio,p.IVA, p.tipoProducto, p.stock from producto p,sucursal s,promocion pr where p.idSucursal=s.idSucursal and p.idPromocion=pr.idPromocion");
            while(rs.next()){
                if(codigo.equals(rs.getString(1))){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=Double.toString(rs.getDouble(5));
                    datos[5]=Double.toString(rs.getDouble(6));    
                    datos[6]=rs.getString(7);   
                    datos[7]=Integer.toString(rs.getInt(8));   
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
    
    public void accionGuardarProducto(){
        Connection cn = conectar.getConection();
            String id, pro, suc,nom, tip;
            double pre,iva;
            int stc;
            String sql = "";
            id = txtProducto.getText();
            pro = txtPromocion.getText();
            suc= txtSucursal.getText();
            nom = txtNombre.getText();
            pre = Double.parseDouble(txtPrecio.getText());
            iva = Double.parseDouble(txtIva.getText());
            tip =txtTipo.getText();
            stc = Integer.parseInt(txtStock.getText());
            sql = "INSERT INTO producto VALUES (?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1,id);
                psd.setString(2,pro);
                psd.setString(3,suc);
                psd.setString(4,nom);
                psd.setDouble(5,pre);
                psd.setDouble(6,iva);
                psd.setString(7,tip);
                psd.setInt(8,stc);
                int indicador = psd.executeUpdate();
                
                if (indicador > 0)
                {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setHeaderText("Aviso");
                    alerta.setContentText("El producto se registró con éxito");
                    alerta.showAndWait();
                    limpiarTextField();
                }
            }catch (SQLException ex) 
            {
                Logger.getLogger(VentanaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    public void limpiarTextField(){
        txtProducto.setText("");
        txtNombre.setText("");
        txtSucursal.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
        txtIva.setText("");
        txtPromocion.setText("");
        txtTipo.setText("");
    
    }
    
    public BorderPane getRoot() {
        return root;
    }
    
}
