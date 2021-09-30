/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author PERSONAL
 */
public class ClienteM {
    private int id;
    private String dni;
    private String nombres;
    private String direc;
    private String tel;
    private String estado;
    
    public ClienteM(){}
    
     public ClienteM(int id, String dni, String nombres,String direc, String tel, String estado) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.direc = direc;
        this.tel = tel;
        this.estado = estado;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
