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
import model.DetalleCompra;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class DetalleCompraRepository implements IDetalleCompra
{

    @Override
    public List<DetalleCompra> getAllDetalleCompra() {
        try
        {
            List<DetalleCompra> lstDetCompra = new ArrayList<>();
            CallableStatement ceDetCompra = Conexion.ObtenerConexion().prepareCall("{CALL USPListardetallecompra()}");
            
            ResultSet rsDetCompra = ceDetCompra.executeQuery();
            while(rsDetCompra.next())
            {
                DetalleCompra obj = new DetalleCompra();
                obj.setIdCompDetalleComp(rsDetCompra.getInt("idcompra"));
                obj.setIdProDetalleComp(rsDetCompra.getString("idproducto"));
                obj.setCantDetalleComp(rsDetCompra.getInt("cantidad"));
                obj.setPreDetalleComp(rsDetCompra.getDouble("precio"));
                obj.setTotalDetalleComp(rsDetCompra.getDouble("total"));
                lstDetCompra.add(obj);
            }
            return lstDetCompra;
        }
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addDetalleCompra(DetalleCompra obj) {
        try
        {
            PreparedStatement stDetCompra = Conexion.ObtenerConexion()
                      .prepareStatement("{CALL USPGuardardetallecompra(?,?,?,?,?)}");
            stDetCompra.setInt(1,obj.getIdCompDetalleComp());
            stDetCompra.setString(2,obj.getIdProDetalleComp());
            stDetCompra.setInt(3,obj.getCantDetalleComp());
            stDetCompra.setDouble(4,obj.getPreDetalleComp());
            stDetCompra.setDouble(5,obj.getTotalDetalleComp());
            
            stDetCompra.executeUpdate();/*Grabar en la BD*/                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
}
