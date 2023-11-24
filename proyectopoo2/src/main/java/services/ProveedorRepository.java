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
import javax.swing.JComboBox;
import model.Proveedor;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class ProveedorRepository implements IProveedor{

    @Override
    public List<Proveedor> GetAllProveedores() {
        try
        {
            List<Proveedor> lstProveedor = new ArrayList<>();
            CallableStatement ceProveedor = Conexion.ObtenerConexion().prepareCall("{CALL USPListarproveedores()}");
            ResultSet rsProveedor = ceProveedor.executeQuery();
            while(rsProveedor.next())
            {
                Proveedor objPro= new Proveedor();
                objPro.setIdProv(rsProveedor.getString("idproveedor"));
                objPro.setRazSocProv(rsProveedor.getString("razonsocial"));
                objPro.setRucProv(rsProveedor.getString("ruc"));
                objPro.setTlfProv(rsProveedor.getString("telefono"));
                objPro.setDirProv(rsProveedor.getString("direccion"));
                lstProveedor.add(objPro);
            }
            return lstProveedor;
        }
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addProveedor(Proveedor obj) {
        try
        {
            PreparedStatement stProveedor= Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPAgregarproveedor(?,?,?,?,?)}");
            stProveedor.setString(1,obj.getIdProv());
            stProveedor.setString(2,obj.getRazSocProv());
            stProveedor.setString(3,obj.getRucProv());
            stProveedor.setString(4,obj.getTlfProv());
            stProveedor.setString(5,obj.getDirProv());
            
            stProveedor.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void updateProveedor(Proveedor obj) 
    {
        try
        {
            PreparedStatement stProveedor = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPModificarproveedor(?,?,?,?,?)}");
            stProveedor.setString(1,obj.getIdProv());
            stProveedor.setString(2,obj.getRazSocProv());
            stProveedor.setString(3,obj.getRucProv());
            stProveedor.setString(4,obj.getTlfProv());
            stProveedor.setString(5,obj.getDirProv());

            stProveedor.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void removeProveedor(Proveedor obj) 
    {
        try
        {
            PreparedStatement stProveedor = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPRemoverproveedor(?)}");
            stProveedor.setString(1,obj.getIdProv());
            
            stProveedor.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public List<Proveedor> getAllBuscarPorRazonSocial(Proveedor obj) 
    {
        try
        {
            List<Proveedor> lstProveedor = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceProveedor = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarporrazonsocial(?)}");
            ceProveedor.setString(1,obj.getRazSocProv());

            ResultSet rsProveedor = ceProveedor.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            while(rsProveedor.next())    
            {
                Proveedor objProv = new Proveedor();
                objProv.setIdProv(rsProveedor.getString("idproveedor"));
                objProv.setRazSocProv(rsProveedor.getString("razonsocial"));
                objProv.setRucProv(rsProveedor.getString("ruc"));
                objProv.setTlfProv(rsProveedor.getString("telefono"));
                objProv.setDirProv(rsProveedor.getString("direccion"));
                lstProveedor.add(objProv);
            }
            return lstProveedor;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public String getCorrelativoProv() 
    {
        try
        {
            String cod = null;
            CallableStatement ceProveedor = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenermaxprov()}");
            ResultSet rsProveedor = ceProveedor.executeQuery();
            while(rsProveedor.next())
            {
                cod = rsProveedor.getString("MAX(idProveedor)");
            }
            
            String numeroStr = cod.substring(2);
            String letra = cod.substring(0, 2);
            int numero = Integer.parseInt(numeroStr);
            numero++;
            String correlativo = letra + String.format("%03d", numero);
            
            return correlativo;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Proveedor getProveedorPorCodigo(String cod) 
    {
        try
        {
            Proveedor obj = new Proveedor();
            /*Llamar al Store Procedure*/
            CallableStatement ceProveedor = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenercodproveedor(?)}");
            ceProveedor.setString(1,cod);

            ResultSet rsProveedor = ceProveedor.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            if(rsProveedor.next())    
            {
                obj.setIdProv(rsProveedor.getString("idproveedor"));
                obj.setRazSocProv(rsProveedor.getString("razonsocial"));
                obj.setRucProv(rsProveedor.getString("ruc"));
                obj.setTlfProv(rsProveedor.getString("telefono"));
                obj.setDirProv(rsProveedor.getString("direccion"));
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
