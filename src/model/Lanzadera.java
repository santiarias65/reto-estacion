/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.InaveLanzadera;

/**
 *
 * @author santi
 */
public class Lanzadera extends Vehiculo implements InaveLanzadera {

    private double carga;
    private double potencia;

    public Lanzadera() {
    }

    public Lanzadera(String tipoNave, String nombre, String combustible, String peso, String empuje, String descripcion, double carga, double potencia) {
        super(tipoNave, nombre, combustible, peso, empuje, descripcion);
        this.carga = carga;
        this.potencia = potencia;
    }

    //METODOS ABSTRACTOS
    @Override
    public String despegar() {
        return "Comando solicitado desde la clase Lanzadera\nTipo de nave : " + getTipoNave() + "\nnombre : " + getNombre() + "\n\nLa nave realizo su Despegue";
    }

    @Override
    public String cargarCombustible() {
        return "Comando solicitado desde la clase Lanzadera\nTipo de nave : " + getTipoNave() + "\nnombre : " + getNombre() + "\n\nLa nave esta cargando su combustible";

    }

    @Override
    public String toString() {
        return "Vehiculo{" + "tipo Nave=" + super.getTipoNave() + ", nombre=" + super.getNombre() + ", combustible=" + super.getCombustible() + ", peso=" + super.getPeso() + ", empuje=" + super.getEmpuje() + ", descripcion=" + super.getDescripcion() + ", carga=" + carga + ", potencia=" + potencia + '}';
    }
    //FIN METODOS ABSTRACTOS

    //METODOS DE LA INTERFAZ
    @Override
    public String soltarCarga() {
        return "Comando solicitado desde la clase Lanzadera\nTipo de nave : " + getTipoNave() + "\nnombre : " + getNombre() + "\n\nLa nave solto la carga";

    }

    @Override
    public String verificarCarga() {
        return "Comando solicitado desde la clase Lanzadera\nTipo de nave : " + getTipoNave() + "\nnombre : " + getNombre() + "\n\nLa nave esta verificando la carga";
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

}
