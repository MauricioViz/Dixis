/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.DetalleCompra;
import services.DetalleCompraRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class DetalleCompraController 
{
    public List<DetalleCompra> getAllDetalleCompra()
    {
        return new DetalleCompraRepository().getAllDetalleCompra();
    }
    public void addDetalleCompra(DetalleCompra obj)
    {
        new DetalleCompraRepository().addDetalleCompra(obj);
    }
}
