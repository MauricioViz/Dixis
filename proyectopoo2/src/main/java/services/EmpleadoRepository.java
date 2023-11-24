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
import model.Empleado;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class EmpleadoRepository implements IEmpleado{

    @Override
    public List<Empleado> getAllEmpleados() 
    {
        try
        {
            List<Empleado> lstEmpleado = new ArrayList<>();
            CallableStatement ceEmpleado = Conexion.ObtenerConexion().prepareCall("{CALL USPListarempleados()}");
            ResultSet rsEmpleado = ceEmpleado.executeQuery();
            while(rsEmpleado.next())
            {
                Empleado objEmp = new Empleado();
                objEmp.setIdEmp(rsEmpleado.getString("idempleado"));
                objEmp.setNomEmp(rsEmpleado.getString("nombre"));
                objEmp.setApeEmp(rsEmpleado.getString("apellidos"));
                objEmp.setDniEmp(rsEmpleado.getString("dni"));
                objEmp.setTlfEmp(rsEmpleado.getString("telefono"));
                objEmp.setSexoEmp(rsEmpleado.getString("sexo"));
                lstEmpleado.add(objEmp);
            }
            return lstEmpleado;
        }
        catch(SQLException e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public void addEmpleado(Empleado obj) 
    {
        try
        {
            PreparedStatement stEmpleado= Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPAgregarempleado(?,?,?,?,?,?)}");
            stEmpleado.setString(1,obj.getIdEmp());
            stEmpleado.setString(2,obj.getNomEmp());
            stEmpleado.setString(3,obj.getApeEmp());
            stEmpleado.setString(4,obj.getDniEmp());
            stEmpleado.setString(5,obj.getTlfEmp());
            stEmpleado.setString(6, obj.getSexoEmp());
            
            stEmpleado.executeUpdate();/*Grabar en la BD*/                
        }
        catch(SQLException e)
        {
            e.getMessage();
        }
    }

    @Override
    public void removeEmpleado(Empleado obj) 
    {
        try
        {
            PreparedStatement stEmpleado = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPRemoverempleado(?)}");
            stEmpleado.setString(1,obj.getIdEmp());
            
            stEmpleado.executeUpdate();/*Grabar en la BD*/                
        }
        catch(SQLException e)
        {
            e.getMessage();
        }
    }

    @Override
    public void updateEmpleado(Empleado obj) 
    {
        try
        {
            PreparedStatement stEmpleado= Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPModificarempleado(?,?,?,?,?,?)}");
            stEmpleado.setString(1,obj.getIdEmp());
            stEmpleado.setString(2,obj.getNomEmp());
            stEmpleado.setString(3,obj.getApeEmp());
            stEmpleado.setString(4,obj.getDniEmp());
            stEmpleado.setString(5,obj.getTlfEmp());
            stEmpleado.setString(6, obj.getSexoEmp());
            
            stEmpleado.executeUpdate();/*Grabar en la BD*/                
        }
        catch(SQLException e)
        {
            e.getMessage();
        }
    }

    @Override
    public List<Empleado> getAllBuscarPorNombre(Empleado obj) 
    {
        try
        {
            List<Empleado> lstEmpleado = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceEmpleado= Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarpornombre(?)}");
            ceEmpleado.setString(1,obj.getNomEmp());

            ResultSet rsEmpleado = ceEmpleado.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            
            while(rsEmpleado.next())
            {
                Empleado objEmp = new Empleado();
                objEmp.setIdEmp(rsEmpleado.getString("idempleado"));
                objEmp.setNomEmp(rsEmpleado.getString("nombre"));
                objEmp.setApeEmp(rsEmpleado.getString("apellidos"));
                objEmp.setDniEmp(rsEmpleado.getString("dni"));
                objEmp.setTlfEmp(rsEmpleado.getString("telefono"));
                objEmp.setSexoEmp(rsEmpleado.getString("sexo"));
                lstEmpleado.add(objEmp);
            }
            return lstEmpleado;
        }
        catch(SQLException e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String getCorrelativoEmp() 
    {
        try
        {
            String cod = null;
            CallableStatement ceEmpleado = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenermaxemp()}");
            ResultSet rsEmpleado = ceEmpleado.executeQuery();
            while(rsEmpleado.next())
            {
                cod = rsEmpleado.getString("MAX(idempleado)");
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
}
