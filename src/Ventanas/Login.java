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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class Login {
    private BorderPane root;
    private Label lblUser;
    private Label lblKey;
    private TextField txtUser;
    private TextField txtKey;
    private Button login;

    public Login() {
        root=new BorderPane();
        title();
        esquemaCentral();
    }
    
     private void title(){ 
        VBox contenedorTitulo = new VBox();
        Label titulo = new Label("Ingrese sus datos");
        contenedorTitulo.getChildren().add(titulo);
        contenedorTitulo.setAlignment(Pos.CENTER);
        root.setTop(contenedorTitulo);
    }   
    
    private void esquemaCentral(){
        VBox contenedor = new VBox();
        
        GridPane con=new GridPane();
        HBox con2=new HBox();
        this.lblUser = new Label("Usuario: ");
        this.lblKey = new Label("Contraseña: ");
        this.txtKey = new TextField();
        this.txtUser = new TextField();
        this.login=new Button("Conectar");

        con.add(lblUser, 0, 1);
        con.add(txtUser, 1, 1);
        con.add(lblKey, 0, 2);
        con.add(txtKey, 1, 2);
        con.add(login,1,3);
        con.setAlignment(Pos.CENTER);
        ImageView bateria;
        try {
            bateria=new ImageView(new Image(new FileInputStream("src/Recursos/bateira.png")));
            bateria.setFitHeight(300);
            bateria.setFitWidth(300);
            con2.getChildren().add(bateria);
            con2.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        
        login.setOnAction(e->{
            Cargar_Scene(new Principal().getRoot(),"Bienvenido", 1500,1500);
        });
        
        
        contenedor.getChildren().addAll(con2,con);
        root.setCenter(contenedor);
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
    
    
}
