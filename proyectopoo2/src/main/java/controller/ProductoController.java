/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Producto;
import services.ProductoRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class ProductoController {
    public List<Producto> getAllProductoController()
    {
        return new ProductoRepository().GetAllProductos();
    }
    
    public void addProductoController(Producto obj) 
    {
        new ProductoRepository().addProducto(obj);
    }
    
    public void removeProductoController(Producto obj)
    {
        new ProductoRepository().removeProducto(obj);
    }
    public void updateProductoController(Producto obj)
    {
        new ProductoRepository().updateProducto(obj);
    }
    public List<Producto> getBuscarDescripcionProductoController(Producto obj)
    {
        return new ProductoRepository().getAllBuscarPorDescripcion(obj);
    }
    public String getCorrelativoProducto()
    {
        return new ProductoRepository().getCorrelativoProd();
    }
    public Producto getBuscarCodigoProductoController(String cod)
    {
        return new ProductoRepository().getAllPorCodigo(cod);
    }
    public boolean actualizarProductoController(String idpro, int cantidad)
    {
        return new ProductoRepository().actualizarProducto(idpro, cantidad);
    }
}
