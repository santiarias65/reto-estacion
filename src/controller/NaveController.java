/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Lanzadera;
import model.NoTripulada;
import model.Tripulada;
import model.Vehiculo;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class NaveController implements Initializable {

    private ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private Label infoTipo;
    @FXML
    private Label infoNombre;
    @FXML
    private Label infoCombustible;
    @FXML
    private Label infoPeso;
    @FXML
    private Label infoEmpuje;
    @FXML
    private Label infoDescripcion;
    @FXML
    private VBox VboxAdministracion;
    @FXML
    private Label textoComando;

    private Vehiculo vehiculoSeleccionado;
    @FXML
    private VBox VBoxComandosEspecificos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mfc.setControlNave(this);
        VboxAdministracion.getChildren().clear();
        VBoxComandosEspecificos.getChildren().clear();
    }

    //----------METODOS SOBRECARGADOS--------
    //recibimos la informacion de la nave seleccionada
    public void pasarInformacion(NoTripulada vehiculo) {
        vehiculoSeleccionado = vehiculo;
        System.out.println("NoTripulada");
        VboxAdministracion.getChildren().add(mfc.getMain().complementoAdministrarNaveNoTripulada());//llamamos el complemento de la vista
        VBoxComandosEspecificos.getChildren().add(mfc.getMain().complementoComandoNoTripulada());
        mfc.getControlComandoNoTripulada().setVehiculo(vehiculo);//le pasamos el vehiculop seleccionado al controlador de los comandos
        mfc.setTextoInfoEstudio(vehiculo.getEstudio());//mandamos la informacio al complemento de la vista
        setDatos();
    }

    public void pasarInformacion(Tripulada vehiculo) {
        vehiculoSeleccionado = vehiculo;
        System.out.println("Tripulada");
        VboxAdministracion.getChildren().add(mfc.getMain().complementoAdministrarNaveTripulada());//llamamos el complemento de la vista
        VBoxComandosEspecificos.getChildren().add(mfc.getMain().complementoComandoTripulada());
        mfc.getControlComandoTripulada().setVehiculo(vehiculo);
        mfc.setTextoNaveTripulada("" + vehiculo.getNumeroTripulantes(), vehiculo.getMision());//mandamos la informacio al complemento de la vista
        setDatos();
    }

    public void pasarInformacion(Lanzadera vehiculo) {
        vehiculoSeleccionado = vehiculo;
        System.out.println("LANZADERA");
        VboxAdministracion.getChildren().add(mfc.getMain().complementoAdministrarNaveLanzadera());//llamamos el complemento de la vista
        VBoxComandosEspecificos.getChildren().add(mfc.getMain().complementoComandoLanzadera());
        mfc.getControlComandoLanzadera().setVehiculo(vehiculo);
        mfc.setTextoNaveLanzadera("" + vehiculo.getCarga(), "" + vehiculo.getPotencia());//mandamos la informacio al complemento de la vista
        setDatos();
    }

    public void setDatos() {
        infoTipo.setText(vehiculoSeleccionado.getTipoNave());
        infoNombre.setText(vehiculoSeleccionado.getNombre());
        infoCombustible.setText(vehiculoSeleccionado.getCombustible());
        infoPeso.setText(vehiculoSeleccionado.getPeso());
        infoEmpuje.setText(vehiculoSeleccionado.getEmpuje());
        infoDescripcion.setText(vehiculoSeleccionado.getDescripcion());
    }

    public void setTextoComando(String comando) {
        textoComando.setText(comando);
    }

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    @FXML
    private void comandoDespegar(ActionEvent event) {
        textoComando.setText(vehiculoSeleccionado.despegar());
    }

    @FXML
    private void comandoToString(ActionEvent event) {
        textoComando.setText(vehiculoSeleccionado.toString());
    }

    @FXML
    private void comandoCargarCombustible(ActionEvent event) {
        textoComando.setText(vehiculoSeleccionado.cargarCombustible());
    }

}
