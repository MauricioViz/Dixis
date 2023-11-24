/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CHRISTOPHER
 */
public class DetalleCompra {
    private int idCompDetalleComp;
    private String idProDetalleComp;
    private int cantDetalleComp;
    private double preDetalleComp;
    private double totalDetalleComp;

    public DetalleCompra(int idCompDetalleComp, String idProDetalleComp, int cantDetalleComp, double preDetalleComp, double totalDetalleComp) {
        this.idCompDetalleComp = idCompDetalleComp;
        this.idProDetalleComp = idProDetalleComp;
        this.cantDetalleComp = cantDetalleComp;
        this.preDetalleComp = preDetalleComp;
        this.totalDetalleComp = totalDetalleComp;
    }

    public DetalleCompra() {
    }

    public int getIdCompDetalleComp() {
        return idCompDetalleComp;
    }

    public void setIdCompDetalleComp(int idCompDetalleComp) {
        this.idCompDetalleComp = idCompDetalleComp;
    }

    public String getIdProDetalleComp() {
        return idProDetalleComp;
    }

    public void setIdProDetalleComp(String idProDetalleComp) {
        this.idProDetalleComp = idProDetalleComp;
    }

    public int getCantDetalleComp() {
        return cantDetalleComp;
    }

    public void setCantDetalleComp(int cantDetalleComp) {
        this.cantDetalleComp = cantDetalleComp;
    }

    public double getPreDetalleComp() {
        return preDetalleComp;
    }

    public void setPreDetalleComp(double preDetalleComp) {
        this.preDetalleComp = preDetalleComp;
    }

    public double getTotalDetalleComp() {
        return totalDetalleComp;
    }

    public void setTotalDetalleComp(double totalDetalleComp) {
        this.totalDetalleComp = totalDetalleComp;
    }
}
