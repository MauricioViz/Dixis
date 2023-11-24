/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import javax.swing.JComboBox;
import model.Empleado;

/**
 *
 * @author CHRISTOPHER
 */
public interface IEmpleado {
    List<Empleado> getAllEmpleados();
    void addEmpleado(Empleado obj);
    void removeEmpleado(Empleado obj);
    void updateEmpleado(Empleado obj);
    List<Empleado> getAllBuscarPorNombre(Empleado obj);
    String getCorrelativoEmp();
}
