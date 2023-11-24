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
import model.Venta;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class VentaRepository implements IVenta
{
    @Override
    public List<Venta> GetAllVentas() 
    {
        try
        {
            List<Venta> lstVenta = new ArrayList<>();
            CallableStatement ceVenta = Conexion.ObtenerConexion().prepareCall("{CALL USPListarventa()}");
            ResultSet rsVenta= ceVenta.executeQuery();
            while(rsVenta.next())
            {
                Venta objVen = new Venta();
                objVen.setIdVen(rsVenta.getInt("idventa"));
                objVen.setFecha(rsVenta.getString("fecha"));
                objVen.setSubTotalVen(rsVenta.getDouble("subtotal"));
                objVen.setTotalVen(rsVenta.getDouble("total"));
                objVen.setIdEmpVen(rsVenta.getString("idempleado"));
                objVen.setIdCliVen(rsVenta.getString("idcliente"));
                objVen.setSerieVenta(rsVenta.getString("serie"));
                objVen.setIgv(rsVenta.getDouble("igv"));
                lstVenta.add(objVen);
            }
            return lstVenta;
        }
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public int getCorrelativoVenta() 
    {
        try
        {
            int cod = 0;
            CallableStatement ceVenta = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenermaxven()}");
            ResultSet rsVenta = ceVenta.executeQuery();
            while(rsVenta.next())
            {
                cod = rsVenta.getInt("MAX(idVenta)");
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
        }
        return 0;
    }

    @Override
    public void addVenta(Venta obj) 
    {
        try
        {
            PreparedStatement stVenta = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPGuardarventa(?,?,?,?,?,?,?,?)}");
            stVenta.setInt(1,obj.getIdVen());
            stVenta.setString(2,obj.getFecha());
            stVenta.setDouble(3,obj.getSubTotalVen());
            stVenta.setDouble(4,obj.getTotalVen());
            stVenta.setString(5,obj.getIdEmpVen());
            stVenta.setString(6, obj.getIdCliVen());
            stVenta.setString(7, obj.getSerieVenta());
            stVenta.setDouble(8, obj.getIgv());
                    
            stVenta.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public String getCorrelativoSerieVenta() 
    {
        try
        {
            String cod = null;
            String correlativo;
            
            CallableStatement ceVenta = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenermaxserie()}");
            ResultSet rsVenta = ceVenta.executeQuery();
            while(rsVenta.next())
            {
                cod = rsVenta.getString("MAX(serie)");
            }
            
            if(cod == null)
            {
                correlativo = "FACT-000001";
                return correlativo;
            }
            else
            {
                String dato = cod;
                String num = dato.substring(5);
                String letra = dato.substring(0,5);
                int numero = Integer.parseInt(num);
                numero++;
                correlativo = letra + String.format("%06d", numero);
                return correlativo;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
