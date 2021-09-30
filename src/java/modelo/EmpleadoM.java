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
public class EmpleadoM {
    private int id;
    private String dni;
    private String nombres;
    private String tel;
    private String estado;
    private String usua;
    
    
    public EmpleadoM(){}

    public EmpleadoM(int id, String dni, String nombres, String tel, String estado, String usua) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.tel = tel;
        this.estado = estado;
        this.usua = usua;
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

    public String getUsua() {
        return usua;
    }

    public void setUsua(String usua) {
        this.usua = usua;
    }
    
}
