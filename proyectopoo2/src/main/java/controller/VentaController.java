/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Venta;
import services.VentaRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class VentaController 
{
    public int getCorrelativoVentaController()
    {
        return new VentaRepository().getCorrelativoVenta();
    }
    public String getCorrelativoSerieVentaController() 
    {
        return new VentaRepository().getCorrelativoSerieVenta();
    }
    public List<Venta> GetAllVentaController()
    {
        return new VentaRepository().GetAllVentas();
    }
    public void addVentaController(Venta obj) 
    {
        new VentaRepository().addVenta(obj);
    }
}
