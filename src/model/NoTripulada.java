/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.InaveNoTripulada;

/**
 *
 * @author santi
 */
public class NoTripulada extends Vehiculo implements InaveNoTripulada{
    private String estudio;
    
    public NoTripulada(){}
    public NoTripulada(String tipoNave,String nombre,String combustible,String peso,String empuje,String descripcion,String estudio){
        super(tipoNave,nombre,combustible,peso,empuje,descripcion);
        this.estudio=estudio;
    }
    //METODOS ABSTRACTOS
    @Override
    public String despegar() {
        return "Comando solicitado desde la clase NoTripulada\nTipo de nave : "+getTipoNave()+"\nnombre : "+getNombre()+"\n\nLa nave realizo su Despegue";
    }
    @Override
    public String cargarCombustible() {
        return "Comando solicitado desde la clase NoTripulada\nTipo de nave : "+getTipoNave()+"\nnombre : "+getNombre()+"\n\nLa nave esta cargando su combustible";
    }
    @Override
    public String toString() {
        return "Vehiculo{"+"tipo Nave="+super.getTipoNave() + ", nombre=" + super.getNombre() + ", combustible=" + super.getCombustible() + ", peso=" + super.getPeso() + ", empuje=" + super.getEmpuje() + ", descripcion=" + super.getDescripcion() + ", estudio=" +estudio + '}';
    }
    
    //FIN METODOS ABSTRACTOS
    
    //METODOS DE LA INTERFAZ
    @Override
    public String scanerLugar() {
        return "Comando solicitado desde la clase NoTripulada\nTipo de nave : "+getTipoNave()+"\nnombre : "+getNombre()+"\n\nLa nave esta scaniando el lugar";
    }
    @Override
    public String tomarFotografia() {
        return "Comando solicitado desde la clase NoTripulada\nTipo de nave : "+getTipoNave()+"\nnombre : "+getNombre()+"\n\nLa nave esta tomando fotografias al lugar";
    }
    
    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    

}
