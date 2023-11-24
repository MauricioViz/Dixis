/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DetalleVenta;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class DetalleVentaRepository implements IDetalleVenta
{
    @Override
    public List<DetalleVenta> getAllDetalleVenta() 
    {
        try
        {
            List<DetalleVenta> lstDetVenta = new ArrayList<>();
            CallableStatement ceDetVenta = Conexion.ObtenerConexion().prepareCall("{CALL USPListardetalleventa()}");
            
            ResultSet rsDetVenta = ceDetVenta.executeQuery();
            while(rsDetVenta.next())
            {
                DetalleVenta objDet = new DetalleVenta();
                objDet.setIdVenDetalleVen(rsDetVenta.getInt("idventa"));
                objDet.setIdProDetalleVen(rsDetVenta.getString("idproducto"));
                objDet.setCantDetalleVen(rsDetVenta.getInt("cantidad"));
                objDet.setPreDetalleVen(rsDetVenta.getDouble("precio"));
                objDet.setTotalDetalleVen(rsDetVenta.getDouble("total"));
                lstDetVenta.add(objDet);
            }
            return lstDetVenta;
        }
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addDetalleVenta(DetalleVenta obj) 
    {
        try
        {
            PreparedStatement stDetVenta = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPGuardardetalleventa(?,?,?,?,?)}");
            stDetVenta.setInt(1,obj.getIdVenDetalleVen());
            stDetVenta.setString(2,obj.getIdProDetalleVen());
            stDetVenta.setInt(3,obj.getCantDetalleVen());
            stDetVenta.setDouble(4,obj.getPreDetalleVen());
            stDetVenta.setDouble(5,obj.getTotalDetalleVen());
            
            stDetVenta.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
}
