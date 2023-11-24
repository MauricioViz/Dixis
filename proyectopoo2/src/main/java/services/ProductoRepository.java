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
import model.Producto;
import util.Conexion;

/**
 *
 * @author CHRISTOPHER
 */
public class ProductoRepository implements IProducto {

    @Override
    public List<Producto> GetAllProductos() {
        try {
            List<Producto> lstProducto = new ArrayList<>();
            CallableStatement ceProducto = Conexion.ObtenerConexion().prepareCall("{CALL USPListarproductos()}");
            ResultSet rsProducto = ceProducto.executeQuery();
            while (rsProducto.next()) {
                Producto objPro = new Producto();
                objPro.setIdProd(rsProducto.getString("idproducto"));
                objPro.setIdProv(rsProducto.getString("idproveedor"));
                objPro.setNomProd(rsProducto.getString("nombre"));
                objPro.setPreComProd(Double.parseDouble(rsProducto.getString("prec_compra")));
                objPro.setPreVenProd(Double.parseDouble(rsProducto.getString("prec_venta")));
                objPro.setCantidad(Integer.parseInt(rsProducto.getString("cantidad")));
                lstProducto.add(objPro);
            }
            return lstProducto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addProducto(Producto obj) {
        try {
            PreparedStatement stProducto = Conexion.ObtenerConexion()
                    .prepareStatement("{CALL USPAgregarproductos(?,?,?,?,?,?)}");
            stProducto.setString(1, obj.getIdProd());
            stProducto.setString(2, obj.getIdProv());
            stProducto.setString(3, obj.getNomProd());
            stProducto.setDouble(4, obj.getPreComProd());
            stProducto.setDouble(5, obj.getPreVenProd());
            stProducto.setInt(6, obj.getCantidad());

            stProducto.executeUpdate();/*Grabar en la BD*/
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void updateProducto(Producto obj) {
        try {
            PreparedStatement stProducto = Conexion.ObtenerConexion()
                    .prepareStatement("{CALL USPModificarProducto(?,?,?,?,?,?)}");
            stProducto.setString(1, obj.getIdProd());
            stProducto.setString(2, obj.getIdProv());
            stProducto.setString(3, obj.getNomProd());
            stProducto.setDouble(4, obj.getPreComProd());
            stProducto.setDouble(5, obj.getPreVenProd());
            stProducto.setInt(6, obj.getCantidad());

            stProducto.executeUpdate();/*Grabar en la BD*/
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void removeProducto(Producto obj) {
        try {
            PreparedStatement stProducto = Conexion.ObtenerConexion()
                    .prepareStatement("{CALL USPRemoverproducto(?)}");
            stProducto.setString(1, obj.getIdProd());

            stProducto.executeUpdate();/*Grabar en la BD*/
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public List<Producto> getAllBuscarPorDescripcion(Producto obj) {
        try {
            List<Producto> lstProducto = new ArrayList<>();
            /*Llamar al Store Procedure*/
            CallableStatement ceProducto = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarpordescripcion(?)}");
            ceProducto.setString(1, obj.getNomProd());

            ResultSet rsProducto = ceProducto.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            while (rsProducto.next()) {
                Producto objProd = new Producto();
                objProd.setIdProd(rsProducto.getString("idproducto"));
                objProd.setIdProv(rsProducto.getString("idproveedor"));
                objProd.setNomProd(rsProducto.getString("nombre"));
                objProd.setPreComProd(Double.parseDouble(rsProducto.getString("prec_compra")));
                objProd.setPreVenProd(Double.parseDouble(rsProducto.getString("prec_venta")));
                objProd.setCantidad(Integer.parseInt(rsProducto.getString("cantidad")));
                lstProducto.add(objProd);
            }
            return lstProducto;
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public String getCorrelativoProd() {
        try {
            String cod = null;
            CallableStatement ceProducto = Conexion.ObtenerConexion().prepareCall("{CALL USPObtenermaxprod()}");
            ResultSet rsProducto = ceProducto.executeQuery();
            while (rsProducto.next()) {
                cod = rsProducto.getString("MAX(idproducto)");
            }

            String numeroStr = cod.substring(2);
            String letra = cod.substring(0, 2);
            int numero = Integer.parseInt(numeroStr);
            numero++;
            String correlativo = letra + String.format("%03d", numero);

            return correlativo;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Producto getAllPorCodigo(String cod) {
        try {
            Producto objProd = new Producto();
            /*Llamar al Store Procedure*/
            CallableStatement ceProducto = Conexion.ObtenerConexion().prepareCall("{CALL USPBuscarporcod(?)}");
            ceProducto.setString(1, cod);

            ResultSet rsProducto = ceProducto.executeQuery();/*Asignando los datos de la BD a estructura de datos(ResultSet)*/
            if (rsProducto.next()) {
                objProd.setIdProd(rsProducto.getString("idproducto"));
                objProd.setIdProv(rsProducto.getString("idproveedor"));
                objProd.setNomProd(rsProducto.getString("nombre"));
                objProd.setPreComProd(Double.parseDouble(rsProducto.getString("prec_compra")));
                objProd.setPreVenProd(Double.parseDouble(rsProducto.getString("prec_venta")));
                objProd.setCantidad(Integer.parseInt(rsProducto.getString("cantidad")));
            }
            return objProd;
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public boolean actualizarProducto(String idpro, int cantidad) {
        try {
            /*Llamar al Store Procedure*/
            CallableStatement ceProducto = Conexion.ObtenerConexion().prepareCall("{CALL USPActualizarproducto(?,?)}");
            ceProducto.setString(1, idpro);
            ceProducto.setInt(2, cantidad);
            return true;
        } catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }

}
