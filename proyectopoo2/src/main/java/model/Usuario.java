/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CHRISTOPHER
 */
public class Usuario {
    private int idUsu;
    private String idEmpUsu;
    private String nomUsu;
    private String passUsu;

    public Usuario(int idUsu, String idEmpUsu, String nomUsu, String passUsu) {
        this.idUsu = idUsu;
        this.idEmpUsu = idEmpUsu;
        this.nomUsu = nomUsu;
        this.passUsu = passUsu;
    }

    public Usuario() {
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getIdEmpUsu() {
        return idEmpUsu;
    }

    public void setIdEmpUsu(String idEmpUsu) {
        this.idEmpUsu = idEmpUsu;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getPassUsu() {
        return passUsu;
    }

    public void setPassUsu(String passUsu) {
        this.passUsu = passUsu;
    }
}
