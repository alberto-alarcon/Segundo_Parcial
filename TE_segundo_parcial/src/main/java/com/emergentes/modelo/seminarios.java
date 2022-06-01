/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;

public class seminarios {
    
    private int id;
    private String titulo ;
    private String fecha;
    private int cupo;

    public seminarios() {
        this.id = 0;
        this.titulo = "";
        this.fecha = "";
        this.cupo =0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
        @Override
    public String toString() {
        return "participante{"+"id="+id+",titulo="+titulo+",fecha="+fecha+",cupo="+cupo+'}';
    }
    
    
}

