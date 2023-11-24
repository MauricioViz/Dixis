/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Compra;
import services.CompraRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class CompraController 
{
    public List<Compra> GetAllCompraController()
    {
        return new CompraRepository().GetAllCompra();
    }
    public void addCompraController(Compra obj)
    {
        new CompraRepository().addCompra(obj);
    }
    public int getCorrelativoCompraController()
    {
        return new CompraRepository().getCorrelativoCompra();
    }
}
