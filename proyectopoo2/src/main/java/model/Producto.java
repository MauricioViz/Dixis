/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CHRISTOPHER
 */
public class Producto {
    private String idProd;
    private String idProv;
    private String nomProd;
    private double preComProd;
    private double preVenProd;
    private int cantidad;

    public Producto(String idProd, String idProv, String nomProd, double preComProd, double preVenProd, int cantidad) {
        this.idProd = idProd;
        this.idProv = idProv;
        this.nomProd = nomProd;
        this.preComProd = preComProd;
        this.preVenProd = preVenProd;
        this.cantidad = cantidad;
    }

    public Producto() {
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public double getPreComProd() {
        return preComProd;
    }

    public void setPreComProd(double preComProd) {
        this.preComProd = preComProd;
    }

    public double getPreVenProd() {
        return preVenProd;
    }

    public void setPreVenProd(double preVenProd) {
        this.preVenProd = preVenProd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
