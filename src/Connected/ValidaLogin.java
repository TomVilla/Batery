/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connected;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author user
 */
public class ValidaLogin {
     private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet res;
    private String cedula;
    private String pass;

    public ValidaLogin(String cedula,String pass) {
        this.cedula = cedula;
        this.pass = pass;
    }
    
    public boolean accionIngresar() {
        try {
            Conexion c=new Conexion();
            connection = c.getConection();
            preparedStatement = connection.prepareStatement("call iniciaSesion(?)");
            preparedStatement.setString(1, cedula);
            res = preparedStatement.executeQuery();
            if (res.next()) {
                return validaPass();
            } else {
                Alert alert =new Alert(AlertType.INFORMATION);
                alert.setTitle ("Diálogo de información");
                alert.setHeaderText ("ERROR");
                alert.setContentText ("¡El usuario ingresado no existe!");
                alert.showAndWait ();
                return false;
            }
        } catch (SQLException e) {
                Alert alert =new Alert(AlertType.INFORMATION);
                alert.setTitle ("Diálogo de información");
                alert.setHeaderText ("ERROR");
                alert.setContentText (e.getMessage());
                alert.showAndWait ();
        }
        return false;
    }
    
    public boolean validaPass() throws SQLException{
        if(res.getString("xclave").equals(pass)){
            connection.close();
            return true;
        }else{
            Alert alert =new Alert(AlertType.INFORMATION);
                alert.setTitle ("Diálogo de información");
                alert.setHeaderText ("ERROR");
                alert.setContentText ("¡La contrasena ingreasada no coincide!");
                alert.showAndWait ();
            return false;
        }
    }
    
    
    
}
