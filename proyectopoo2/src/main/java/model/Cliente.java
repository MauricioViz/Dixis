/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CHRISTOPHER
 */
public class Cliente {
    private String idCliente;
    private String razSocCli;
    private String rucCli;
    private String tlfCli;
    private String dirCli;

    public Cliente(String idCliente, String razSocCli, String rucCli, String tlfCli, String dirCli) {
        this.idCliente = idCliente;
        this.razSocCli = razSocCli;
        this.rucCli = rucCli;
        this.tlfCli = tlfCli;
        this.dirCli = dirCli;
    }

    public Cliente() {
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazSocCli() {
        return razSocCli;
    }

    public void setRazSocCli(String razSocCli) {
        this.razSocCli = razSocCli;
    }

    public String getRucCli() {
        return rucCli;
    }

    public void setRucCli(String rucCli) {
        this.rucCli = rucCli;
    }

    public String getTlfCli() {
        return tlfCli;
    }

    public void setTlfCli(String tlfCli) {
        this.tlfCli = tlfCli;
    }

    public String getDirCli() {
        return dirCli;
    }

    public void setDirCli(String dirCli) {
        this.dirCli = dirCli;
    }
    
    
    
}
