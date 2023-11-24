/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Usuario;
import services.UsuarioRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class UsuarioController 
{
    public List<Usuario> getAllUsuarioController()
    {
        return new UsuarioRepository().GetAllUsuarios();
    }
    
    public void addUsuarioController(Usuario obj) 
    {
        new UsuarioRepository().addUsuario(obj);
    }
    
    public void removeUsuarioController(Usuario obj)
    {
        new UsuarioRepository().removeUsuario(obj);
    }
    public void updateUsuarioController(Usuario obj)
    {
        new UsuarioRepository().updateUsuario(obj);
    }
    public List<Usuario> getBuscarPorCorreoUsuarioController(Usuario obj)
    {
        return new UsuarioRepository().getAllBuscarPorCorreo(obj);
    }
    public int getCorrelativoUsuarioController()
    {
        return new UsuarioRepository().getCorrelativoUsuario();
    }
    public Boolean getValidacionLoginUsuarioController(String correo, String pass)
    {
        return new UsuarioRepository().getValidacionLogin(correo, pass);
    }
}
