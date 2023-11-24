/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.Usuario;

/**
 *
 * @author CHRISTOPHER
 */
public interface IUsuario 
{
    List<Usuario> GetAllUsuarios();
    void addUsuario(Usuario obj);
    void updateUsuario(Usuario obj);
    void removeUsuario(Usuario obj);
    List<Usuario> getAllBuscarPorCorreo(Usuario obj);
    int getCorrelativoUsuario();
    Boolean getValidacionLogin(String correo, String pass);
}
