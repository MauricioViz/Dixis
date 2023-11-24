/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CHRISTOPHER
 */
public class Empleado {
    private String idEmp;
    private String nomEmp;
    private String apeEmp;
    private String dniEmp;
    private String tlfEmp;
    private String sexoEmp;

    public Empleado(String idEmp, String nomEmp, String apeEmp, String dniEmp, String tlfEmp, String sexoEmp) {
        this.idEmp = idEmp;
        this.nomEmp = nomEmp;
        this.apeEmp = apeEmp;
        this.dniEmp = dniEmp;
        this.tlfEmp = tlfEmp;
        this.sexoEmp = sexoEmp;
    }

    public Empleado() {
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getApeEmp() {
        return apeEmp;
    }

    public void setApeEmp(String apeEmp) {
        this.apeEmp = apeEmp;
    }

    public String getDniEmp() {
        return dniEmp;
    }

    public void setDniEmp(String dniEmp) {
        this.dniEmp = dniEmp;
    }

    public String getTlfEmp() {
        return tlfEmp;
    }

    public void setTlfEmp(String tlfEmp) {
        this.tlfEmp = tlfEmp;
    }
    
    public String getSexoEmp() {
        return sexoEmp;
    }

    public void setSexoEmp(String sexoEmp) {
        this.sexoEmp = sexoEmp;
    }
}
