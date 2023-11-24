/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class ClienteRepository implements ICliente{

    @Override
    public List<Cliente> getAllClientes() 
    {
        try
        {
            List<Cliente> lstCliente = new ArrayList<>();
            CallableStatement ceCliente = Conexion.ObtenerConexion().prepareCall("{CALL USPListarclientes()}");
            ResultSet rsCliente = ceCliente.executeQuery();
            while(rsCliente.next())
            {
                Cliente objCli = new Cliente();
                objCli.setIdCliente(rsCliente.getString("idcliente"));
                objCli.setRazSocCli(rsCliente.getString("razonsocial"));
                objCli.setRucCli(rsCliente.getString("ruc"));
                objCli.setTlfCli(rsCliente.getString("telefono"));
                objCli.setDirCli(rsCliente.getString("direccion"));
                lstCliente.add(objCli);
            }
            return lstCliente;
        }
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addCliente(Cliente obj) 
    {
        try
        {
            PreparedStatement stCliente = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPAgregarcliente(?,?,?,?,?)}");
            stCliente.setString(1,obj.getIdCliente());
            stCliente.setString(2,obj.getRazSocCli());
            stCliente.setString(3,obj.getRucCli());
            stCliente.setString(4,obj.getTlfCli());
            stCliente.setString(5,obj.getDirCli());
            
            stCliente.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void removeCliente(Cliente obj) 
    {
        try
        {
            PreparedStatement stCliente = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPRemovercliente(?)}");
            stCliente.setString(1,obj.getIdCliente());
            
            stCliente.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    } 
    
    @Override
    public void updateCliente(Cliente obj) 
    {
        try
        {
            PreparedStatement stCliente = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPModificarcliente(?,?,?,?,?)}");
            stCliente.setString(1,obj.getIdCliente());
            stCliente.setString(2,obj.getRazSocCli());
            stCliente.setString(3,obj.getRucCli());
            stCliente.setString(4,obj.getTlfCli());
            stCliente.setString(5,obj.getDirCli());

            stCliente.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public String getCorrelativoCliente() 
    {
        try
        {
            String cod = null;
            CallableStatement ceCliente = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenermaxcli()}");
            ResultSet rsCliente = ceCliente.executeQuery();
            while(rsCliente.next())
            {
                cod = rsCliente.getString("MAX(idcliente)");
            }
            
            String numeroStr = cod.substring(1);
            String letra = cod.substring(0, 1);
            int numero = Integer.parseInt(numeroStr);
            numero++;
            String correlativo = letra + String.format("%04d", numero);
            
            return correlativo;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Cliente> getAllBuscarPorNombre(Cliente obj) {
        try
        {
            List<Cliente> lstCliente = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceCliente = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenernombrecli(?)}");
            ceCliente.setString(1,obj.getRazSocCli());

            ResultSet rsCliente = ceCliente.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            while(rsCliente.next())    
            {
                Cliente objCli = new Cliente();
                objCli.setIdCliente(rsCliente.getString("idcliente"));
                objCli.setRazSocCli(rsCliente.getString("razonsocial"));
                objCli.setRucCli(rsCliente.getString("ruc"));
                objCli.setTlfCli(rsCliente.getString("telefono"));
                objCli.setDirCli(rsCliente.getString("direccion"));
                lstCliente.add(objCli);
            }
            return lstCliente;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public String getRazonSocialCliente(String cod) {
        try
        {
            String raz = null;
            CallableStatement ceCliente = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenerrazsoccli(?)}");
            ceCliente.setString(1, cod);
            
            ResultSet rsCliente = ceCliente.executeQuery();
            while(rsCliente.next())
            {
                raz = rsCliente.getString("razonsocial");
            }
            
            return raz;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Cliente getClientePorCodigo(String cod) 
    {
        try
        {
            Cliente obj = new Cliente();
            /*Llamar al Store Procedure*/
            CallableStatement ceCliente = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenercodcliente(?)}");
            ceCliente.setString(1,cod);

            ResultSet rsCliente = ceCliente.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            if(rsCliente.next())    
            {
                obj.setIdCliente(rsCliente.getString("idcliente"));
                obj.setRazSocCli(rsCliente.getString("razonsocial"));
                obj.setRucCli(rsCliente.getString("ruc"));
                obj.setTlfCli(rsCliente.getString("telefono"));
                obj.setDirCli(rsCliente.getString("direccion"));
            }
            return obj;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }
    
}
