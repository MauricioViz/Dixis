/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JComboBox;
import model.Proveedor;
import services.ProveedorRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class ProveedorController {
    public List<Proveedor> getAllProveedorController()
    {
        return new ProveedorRepository().GetAllProveedores();
    }
    public void addProveedorController(Proveedor obj) 
    {
        new ProveedorRepository().addProveedor(obj);
    }
    public void removeProveedorController(Proveedor obj)
    {
        new ProveedorRepository().removeProveedor(obj);
    }
    public void updateProveedorController(Proveedor obj)
    {
        new ProveedorRepository().updateProveedor(obj);
    }
    public List<Proveedor> getBuscarRazonSocialProveedorController(Proveedor obj)
    {
        return new ProveedorRepository().getAllBuscarPorRazonSocial(obj);
    }
    public String getCorrelativoProveedor()
    {
        return new ProveedorRepository().getCorrelativoProv();
    }
    public Proveedor getPorCodigoProveedorController(String cod)
    {
        return new ProveedorRepository().getProveedorPorCodigo(cod);
    }
}
