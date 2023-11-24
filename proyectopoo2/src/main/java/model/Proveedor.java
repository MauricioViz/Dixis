/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CHRISTOPHER
 */
public class Proveedor {
    private String idProv;
    private String razSocProv;
    private String rucProv;
    private String tlfProv;
    private String dirProv;

    public Proveedor(String idProv, String razSocProv, String rucProv, String tlfProv, String dirProv) {
        this.idProv = idProv;
        this.razSocProv = razSocProv;
        this.rucProv = rucProv;
        this.tlfProv = tlfProv;
        this.dirProv = dirProv;
    }

    public Proveedor() {
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getRazSocProv() {
        return razSocProv;
    }

    public void setRazSocProv(String razSocProv) {
        this.razSocProv = razSocProv;
    }

    public String getRucProv() {
        return rucProv;
    }

    public void setRucProv(String rucProv) {
        this.rucProv = rucProv;
    }

    public String getTlfProv() {
        return tlfProv;
    }

    public void setTlfProv(String tlfProv) {
        this.tlfProv = tlfProv;
    }

    public String getDirProv() {
        return dirProv;
    }

    public void setDirProv(String dirProv) {
        this.dirProv = dirProv;
    }
    
    
}
