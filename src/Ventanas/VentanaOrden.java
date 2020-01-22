/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Jeanca Moreano
 */
public class VentanaOrden {
    private BorderPane root;
    private Button volver;
    
    public VentanaOrden(){
        root = new BorderPane();
        root.setTop(new Label("VENTANA ORDEN"));
        
        volver = new Button("Volver");
        volver.setOnAction(e->{
            Cargar_Scene(new Principal().getRoot(),"Bienvenido", 1500, 1500);
        });
        
        root.setCenter(volver);
        
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
