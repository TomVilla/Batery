/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battery;
import Connected.Conexion;
import Ventanas.Login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Battery extends Application {
    
    @Override
    public void start(Stage primaryStage) {
     
        Conexion c=new Conexion();
        
        Scene scene = new Scene(new Login().getRoot(), 500,500);
        
        primaryStage.setTitle("LOGIN");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
