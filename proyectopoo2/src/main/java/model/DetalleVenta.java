/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CHRISTOPHER
 */
public class DetalleVenta {
    private int idVenDetalleVen;
    private String idProDetalleVen;
    private int cantDetalleVen;
    private double preDetalleVen;
    private double totalDetalleVen;

    public DetalleVenta(int idVenDetalleVen, String idProDetalleVen, int cantDetalleVen, double preDetalleVen, double totalDetalleVen) {
        this.idVenDetalleVen = idVenDetalleVen;
        this.idProDetalleVen = idProDetalleVen;
        this.cantDetalleVen = cantDetalleVen;
        this.preDetalleVen = preDetalleVen;
        this.totalDetalleVen = totalDetalleVen;
    }

    public DetalleVenta() {
    }

    public int getIdVenDetalleVen() {
        return idVenDetalleVen;
    }

    public void setIdVenDetalleVen(int idVenDetalleVen) {
        this.idVenDetalleVen = idVenDetalleVen;
    }

    public String getIdProDetalleVen() {
        return idProDetalleVen;
    }

    public void setIdProDetalleVen(String idProDetalleVen) {
        this.idProDetalleVen = idProDetalleVen;
    }

    public int getCantDetalleVen() {
        return cantDetalleVen;
    }

    public void setCantDetalleVen(int cantDetalleVen) {
        this.cantDetalleVen = cantDetalleVen;
    }

    public double getPreDetalleVen() {
        return preDetalleVen;
    }

    public void setPreDetalleVen(double preDetalleVen) {
        this.preDetalleVen = preDetalleVen;
    }

    public double getTotalDetalleVen() {
        return totalDetalleVen;
    }

    public void setTotalDetalleVen(double totalDetalleVen) {
        this.totalDetalleVen = totalDetalleVen;
    }
    
    
}
