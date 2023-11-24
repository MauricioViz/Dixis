/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.DetalleVenta;
import services.DetalleVentaRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class DetalleVentaController 
{
    public List<DetalleVenta> getAllDetalleVentaController()
    {
        return new DetalleVentaRepository().getAllDetalleVenta();
    }
    public void addDetalleVentaController(DetalleVenta obj)
    {
        new DetalleVentaRepository().addDetalleVenta(obj);
    }
}
