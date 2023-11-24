/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author CHRISTOPHER
 */
public class Compra {
    private int idComp;
    private String fechaComp;
    private double subTotalComp;
    private double igv;
    private double totalComp;
    private String estComp;
    private String idEmpComp;
    private String idProvComp;

    public Compra(int idComp, String fechaComp, double subTotalComp, double igv, double totalComp, String estComp, String idEmpComp, String idProvComp) {
        this.idComp = idComp;
        this.fechaComp = fechaComp;
        this.subTotalComp = subTotalComp;
        this.igv = igv;
        this.totalComp = totalComp;
        this.estComp = estComp;
        this.idEmpComp = idEmpComp;
        this.idProvComp = idProvComp;
    }

    public Compra() {
    }

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public String getFechaComp() {
        return fechaComp;
    }

    public void setFechaComp(String fechaComp) {
        this.fechaComp = fechaComp;
    }

    public double getSubTotalComp() {
        return subTotalComp;
    }

    public void setSubTotalComp(double subTotalComp) {
        this.subTotalComp = subTotalComp;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotalComp() {
        return totalComp;
    }

    public void setTotalComp(double totalComp) {
        this.totalComp = totalComp;
    }

    public String getEstComp() {
        return estComp;
    }

    public void setEstComp(String estComp) {
        this.estComp = estComp;
    }

    public String getIdEmpComp() {
        return idEmpComp;
    }

    public void setIdEmpComp(String idEmpComp) {
        this.idEmpComp = idEmpComp;
    }

    public String getIdProvComp() {
        return idProvComp;
    }

    public void setIdProvComp(String idProvComp) {
        this.idProvComp = idProvComp;
    }
    
    
    
}
