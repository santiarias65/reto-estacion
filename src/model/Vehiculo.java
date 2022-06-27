/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author santi
 */
public abstract class Vehiculo {
    private String tipoNave;
    private String nombre;
    private String combustible;
    private String peso;//kg o toneladas
    private String empuje;//kg o toneladas
    private String descripcion;
    
    public Vehiculo(){}
    public Vehiculo(String tipoNave,String nombre,String combustible,String peso,String empuje,String descripcion){
        this.tipoNave = tipoNave;
        this.nombre = nombre;
        this.combustible = combustible;
        this.peso = peso;
        this.empuje = empuje;
        this.descripcion = descripcion;
    }
    
    public abstract String despegar();
    public abstract String cargarCombustible();
    @Override
    public  abstract String toString();
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEmpuje() {
        return empuje;
    }

    public void setEmpuje(String empuje) {
        this.empuje = empuje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(String tipoNave) {
        this.tipoNave = tipoNave;
    }
    
}
