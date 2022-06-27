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
import model.Tripulada;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class ComandoTripuladaController implements Initializable {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    private Tripulada vehiculo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mfc.setControlComandoTripulada(this);
    }    

    @FXML
    private void comandoComunicarse(ActionEvent event) {
        mfc.getControlNave().setTextoComando(vehiculo.comunicar());
    }
    @FXML
    private void comandoSeleccionarCapitan(ActionEvent event) {
        mfc.getControlNave().setTextoComando(vehiculo.seleccionarCapitan());
    }
    public void setVehiculo(Tripulada vehiculo) {
        this.vehiculo = vehiculo;
    }

    
}
