/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.InaveTripulada;

/**
 *
 * @author santi
 */
public class Tripulada extends Vehiculo implements InaveTripulada {

    private int numeroTripulantes;
    private String mision;
    
    public Tripulada(){}
    public Tripulada(String tipoNave, String nombre, String combustible, String peso, String empuje, String descripcion, int numeroTripulantes, String mision) {
        super(tipoNave, nombre, combustible, peso, empuje, descripcion);
        this.numeroTripulantes = numeroTripulantes;
        this.mision = mision;
    }

    //METODOS ABSTRACTOS
    @Override
    public String despegar() {
        return "Comando solicitado desde la clase Tripulada\nTipo de nave : " + getTipoNave() + "\nnombre : " + getNombre() + "\n\nLa nave realizo su Despegue";
    }

    @Override
    public String cargarCombustible() {
        return "Comando solicitado desde la clase Tripulada\nTipo de nave : " + getTipoNave() + "\nnombre : " + getNombre() + "\n\nLa nave esta cargando su combustible";
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "tipo Nave=" + super.getTipoNave() + ", nombre=" + super.getNombre() + ", combustible=" + super.getCombustible() + ", peso=" + super.getPeso() + ", empuje=" + super.getEmpuje() + ", descripcion=" + super.getDescripcion() + ", numero tripulantes=" + numeroTripulantes + ", mision=" + mision + '}';
    }
    //FIN METODOS ABSTRACTOS

    //METODOS DE LA INTERFAZ
    @Override
    public String comunicar() {
        return "Comando solicitado desde la clase Tripulada\nTipo de nave : " + getTipoNave() + "\nnombre : " + getNombre() + "\n\nLa nave se esta comunicando";
    }
    @Override
    public String seleccionarCapitan() {
        return "Comando solicitado desde la clase Tripulada\nTipo de nave : " + getTipoNave() + "\nnombre : " + getNombre() + "\n\nSe esta seleccionando capitan";
    }
    
    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }

    public void setNumeroTripulantes(int numeroTripulantes) {
        this.numeroTripulantes = numeroTripulantes;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

}
