/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.DetalleVenta;

/**
 *
 * @author CHRISTOPHER
 */
public interface IDetalleVenta 
{
    List<DetalleVenta> getAllDetalleVenta();
    void addDetalleVenta(DetalleVenta obj);
}
