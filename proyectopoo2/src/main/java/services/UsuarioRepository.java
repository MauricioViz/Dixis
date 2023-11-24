/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class UsuarioRepository implements IUsuario 
{
    @Override
    public List<Usuario> GetAllUsuarios() 
    {
        try
        {
            List<Usuario> lstUsuario = new ArrayList<>();
            CallableStatement ceUsuario = Conexion.ObtenerConexion().prepareCall("{CALL USPListarusuarios()}");
            ResultSet rsUsuario = ceUsuario.executeQuery();
            while(rsUsuario.next())
            {
                Usuario objUsu = new Usuario();
                objUsu.setIdUsu(rsUsuario.getInt("idusuario"));
                objUsu.setIdEmpUsu(rsUsuario.getString("idempleado"));
                objUsu.setNomUsu(rsUsuario.getString("usuario"));
                objUsu.setPassUsu(rsUsuario.getString("pass"));
                lstUsuario.add(objUsu);
            }
            return lstUsuario;
        }
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addUsuario(Usuario obj) 
    {
        try
        {
            PreparedStatement stUsuario = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPAgregarusuarios(?,?,?,?)}");
            stUsuario.setInt(1, obj.getIdUsu());
            stUsuario.setString(2,obj.getIdEmpUsu());
            stUsuario.setString(3,obj.getNomUsu());
            stUsuario.setString(4,obj.getPassUsu());
            
            stUsuario.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void updateUsuario(Usuario obj) 
    {
                try
        {
            PreparedStatement stUsuario = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPModificarusuario(?,?,?,?)}");
            stUsuario.setInt(1, obj.getIdUsu());
            stUsuario.setString(2,obj.getIdEmpUsu());
            stUsuario.setString(3,obj.getNomUsu());
            stUsuario.setString(4,obj.getPassUsu());
            
            stUsuario.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void removeUsuario(Usuario obj) 
    {
        try
        {
            PreparedStatement stUsuario = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPRemoverusuario(?)}");
            stUsuario.setInt(1,obj.getIdUsu());
            
            stUsuario.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public List<Usuario> getAllBuscarPorCorreo(Usuario obj) 
    {
        try
        {
            List<Usuario> lstUsuario = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceUsuario = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarporcorreo(?)}");
            ceUsuario.setString(1,obj.getNomUsu());

            ResultSet rsUsuario = ceUsuario.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            while(rsUsuario.next())    
            {
                Usuario objUsu = new Usuario();
                objUsu.setIdUsu(rsUsuario.getInt("idusuario"));
                objUsu.setIdEmpUsu(rsUsuario.getString("idempleado"));
                objUsu.setNomUsu(rsUsuario.getString("usuario"));
                objUsu.setPassUsu(rsUsuario.getString("pass"));
                lstUsuario.add(objUsu);
            }
            return lstUsuario;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public int getCorrelativoUsuario() 
    {
        try
        {
            int cod = 0;
            CallableStatement ceUsuario = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenermaxusu()}");
            ResultSet rsUsuario = ceUsuario.executeQuery();
            while(rsUsuario.next())
            {
                cod = rsUsuario.getInt("MAX(idusuario)");
            }
            
            int codnuevo = cod + 1;
            
            return codnuevo;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return 1;
    
    }

    @Override
    public Boolean getValidacionLogin(String correo, String pass) 
    {
        try
        {
            List<Usuario> lstUsuario = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceUsuario = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarusuario(?,?)}");
            ceUsuario.setString(1,correo);
            ceUsuario.setString(2, pass);

            ResultSet rsUsuario = ceUsuario.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            while(rsUsuario.next())    
            {
                Usuario objUsu = new Usuario();
                objUsu.setIdUsu(rsUsuario.getInt("idusuario"));
                objUsu.setIdEmpUsu(rsUsuario.getString("idempleado"));
                objUsu.setNomUsu(rsUsuario.getString("usuario"));
                objUsu.setPassUsu(rsUsuario.getString("pass"));
                lstUsuario.add(objUsu);
            }
            
            if(!lstUsuario.isEmpty())
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            e.getMessage();
        }
        return false;
    }
    
}
