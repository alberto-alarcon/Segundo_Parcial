/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;

public class participantes {

    private int id;
    private String apellidos ;
    private String nombres;
    private int id_seminario;
    private int confirmado;

    public participantes() {
        this.id = 0;
        this.apellidos = "";
        this.nombres = "";
        this.id_seminario = 0;
        this.confirmado = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId_seminario() {
        return id_seminario;
    }

    public void setId_seminario(int id_seminario) {
        this.id_seminario = id_seminario;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public String toString() {
        return "participante{"+"id="+id+",apellido="+apellidos+",nombres="+nombres+",id_seminario="+id_seminario+",confirmado="+confirmado+'}';
    }
    

    
    
    
    
    
}
