/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Cliente;
import services.ClienteRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class ClienteController {
    public List<Cliente> getAllClienteController()
    {
        return new ClienteRepository().getAllClientes();
    }
    public void addClienteController(Cliente obj) 
    {
        new ClienteRepository().addCliente(obj);
    }
    public void removeClienteController(Cliente obj)
    {
        new ClienteRepository().removeCliente(obj);
    }
    public void updateClienteController(Cliente obj)
    {
        new ClienteRepository().updateCliente(obj);
    }
    public String correlativoClienteController()
    {
        return new ClienteRepository().getCorrelativoCliente();
    }
    public List<Cliente> getBuscarNombreClienteController(Cliente obj)
    {
        return new ClienteRepository().getAllBuscarPorNombre(obj);
    }
    public String getRazonSocialClienteController(String cod)
    {
        return new ClienteRepository().getRazonSocialCliente(cod);
    }
    public Cliente getPorCodigoClienteController(String cod)
    {
        return new ClienteRepository().getClientePorCodigo(cod);
    }
}
