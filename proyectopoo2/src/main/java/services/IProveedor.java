/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import javax.swing.JComboBox;
import model.Proveedor;

/**
 *
 * @author CHRISTOPHER
 */
public interface IProveedor {
    List<Proveedor> GetAllProveedores();
    void addProveedor(Proveedor obj);
    void updateProveedor(Proveedor obj);
    void removeProveedor(Proveedor obj);
    List<Proveedor> getAllBuscarPorRazonSocial(Proveedor obj);
    Proveedor getProveedorPorCodigo(String cod);
    String getCorrelativoProv();
}
