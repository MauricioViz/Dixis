/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author CHRISTOPHER
 */
public class Conexion {
    public Conexion(){}
    public static Connection ObtenerConexion()
    {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddixis", "root", "");
            System.out.println("Conexión exitosa");
            return con;
        }
        catch(Exception e)
        {
            System.out.println("Error al conectar la base de datos " + e.getMessage());
        }
        return con;
    }
}
