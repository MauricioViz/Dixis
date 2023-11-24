/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.Venta;

/**
 *
 * @author CHRISTOPHER
 */
public interface IVenta {
    List<Venta> GetAllVentas();
    void addVenta(Venta obj);
    int getCorrelativoVenta();
    String getCorrelativoSerieVenta();
}
