/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.Producto;

/**
 *
 * @author CHRISTOPHER
 */
public interface IProducto {
    List<Producto> GetAllProductos();
    void addProducto(Producto obj);
    void updateProducto(Producto obj);
    void removeProducto(Producto obj);
    List<Producto> getAllBuscarPorDescripcion(Producto obj);
    Producto getAllPorCodigo(String cod);
    String getCorrelativoProd();
    boolean actualizarProducto(String idpro,int cantidad);
}
