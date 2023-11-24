/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.Cliente;

/**
 *
 * @author CHRISTOPHER
 */
public interface ICliente 
{   
    List<Cliente> getAllClientes();
    void addCliente(Cliente obj);
    void removeCliente(Cliente obj);
    void updateCliente(Cliente obj);
    String getCorrelativoCliente();
    List<Cliente> getAllBuscarPorNombre(Cliente obj);
    String getRazonSocialCliente(String cod);
    Cliente getClientePorCodigo(String cod);
}
