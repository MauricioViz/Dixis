/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.Compra;

/**
 *
 * @author CHRISTOPHER
 */
public interface ICompra 
{
    List<Compra> GetAllCompra();
    void addCompra(Compra obj);
    int getCorrelativoCompra();
}
