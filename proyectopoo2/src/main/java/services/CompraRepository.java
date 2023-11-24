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
import model.Compra;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class CompraRepository implements ICompra
{

    @Override
    public List<Compra> GetAllCompra() 
    {
        try
        {
            List<Compra> lstCompra = new ArrayList<>();
            CallableStatement ceCompra = Conexion.ObtenerConexion().prepareCall("{CALL USPListarcompra()}");
            
            ResultSet rsCompra = ceCompra.executeQuery();
            while(rsCompra.next())
            {
                Compra obj = new Compra();
                obj.setIdComp(rsCompra.getInt("idcompra"));
                obj.setFechaComp(rsCompra.getString("fecha"));
                obj.setSubTotalComp(rsCompra.getDouble("subtotal"));
                obj.setIgv(rsCompra.getDouble("igv"));
                obj.setTotalComp(rsCompra.getDouble("total"));
                obj.setEstComp(rsCompra.getString("estado"));
                obj.setIdEmpComp(rsCompra.getString("idempleado"));
                obj.setIdProvComp(rsCompra.getString("idproveedor"));
                
                lstCompra.add(obj);
            }
            return lstCompra;
        }
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addCompra(Compra obj) 
    {   
        try
        {
        PreparedStatement stCompra = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPGuardarcompra(?,?,?,?,?,?,?,?)}");
            stCompra.setInt(1,obj.getIdComp());
            stCompra.setString(2, obj.getFechaComp());
            stCompra.setDouble(3,obj.getSubTotalComp());
            stCompra.setDouble(4,obj.getIgv());
            stCompra.setDouble(5,obj.getTotalComp());
            stCompra.setString(6, obj.getEstComp());
            stCompra.setString(7, obj.getIdEmpComp());
            stCompra.setString(8, obj.getIdProvComp());
            
            stCompra.executeQuery();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public int getCorrelativoCompra() 
    {
        try
        {
            int cod = 0;
            CallableStatement ceCompra = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenermaxcompra()}");
            ResultSet rsCompra = ceCompra.executeQuery();
            while(rsCompra.next())
            {
                cod = rsCompra.getInt("MAX(idcompra)");
            }
            
            if(cod == 0)
            {
                return 1;
            }
            else
            {
                return cod + 1;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
}
