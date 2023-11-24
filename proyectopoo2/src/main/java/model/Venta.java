/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
/**
 *
 * @author CHRISTOPHER
 */
public class Venta {
    private int idVen;
    private String fecha;
    private double subTotalVen;
    private double totalVen;
    private String idEmpVen;
    private String idCliVen;
    private String serieVenta;
    private double igv;

    public Venta(int idVen, String fecha, double subTotalVen, double totalVen, String idEmpVen, String idCliVen, String serieVenta, double igv) {
        this.idVen = idVen;
        this.subTotalVen = subTotalVen;
        this.igv = igv;
        this.totalVen = totalVen;
        this.serieVenta = serieVenta;
        this.fecha = fecha;
        this.idEmpVen = idEmpVen;
        this.idCliVen = idCliVen;
    }

    public String getSerieVenta() {
        return serieVenta;
    }

    public void setSerieVenta(String serieVenta) {
        this.serieVenta = serieVenta;
    }
    
    public Venta() {
    }
        
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdVen() {
        return idVen;
    }

    public void setIdVen(int idVen) {
        this.idVen = idVen;
    }

    public double getSubTotalVen() {
        return subTotalVen;
    }

    public void setSubTotalVen(double subTotalVen) {
        this.subTotalVen = subTotalVen;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotalVen() {
        return totalVen;
    }

    public void setTotalVen(double totalVen) {
        this.totalVen = totalVen;
    }
    
    public String getIdEmpVen() {
        return idEmpVen;
    }

    public void setIdEmpVen(String idEmpVen) {
        this.idEmpVen = idEmpVen;
    }

    public String getIdCliVen() {
        return idCliVen;
    }

    public void setIdCliVen(String idCliVen) {
        this.idCliVen = idCliVen;
    }
    
    
    
    
}
