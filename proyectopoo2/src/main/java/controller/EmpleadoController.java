/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JComboBox;
import model.Empleado;
import services.EmpleadoRepository;

/**
 *
 * @author CHRISTOPHER
 */
public class EmpleadoController {
    public List<Empleado> getAllEmpleadoController()
    {
        return new EmpleadoRepository().getAllEmpleados();
    }
    public void addEmpleadoController(Empleado obj) 
    {
        new EmpleadoRepository().addEmpleado(obj);
    }
    public void removeEmpleadoController(Empleado obj)
    {
        new EmpleadoRepository().removeEmpleado(obj);
    }
    public void updateEmpleadoController(Empleado obj)
    {
        new EmpleadoRepository().updateEmpleado(obj);
    }
    public List<Empleado> getBuscarNombreEmpleadoController(Empleado obj)
    {
        return new EmpleadoRepository().getAllBuscarPorNombre(obj);
    }
    public String getCorrelativoEmpleadoController()
    {
        return new EmpleadoRepository().getCorrelativoEmp();
    }
}
