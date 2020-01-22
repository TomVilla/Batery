/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connected;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Conexion {
    private static Connection conn;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/baterias?characterEncoding=latin1";

    public Conexion() {
        
        conn = null;
        try
        {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);// esta línea me permitirá conectarme a la base de datos
            //Para asegurar que me he conectado, uso un if
            if (conn != null)
            {
                System.out.println("Conexion Exitosa ...");
            }
        }catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error al conectar: "+e);
            
        }
    }
    //Metodo que nos retornara la conexion
    public Connection getConection()
    {
        return conn;
    }
    
    //Metodo que sirve para desconectarnos de la base de datos
    public void desconected()
    {
        conn = null;
        if(conn == null)
        {
            System.out.println("Conexion Finalizada ...");
        }
    }
}
