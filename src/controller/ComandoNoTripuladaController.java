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
import model.NoTripulada;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class ComandoNoTripuladaController implements Initializable {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    private NoTripulada vehiculo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mfc.setControlComandoNoTripulada(this);
    }    

    @FXML
    private void comandoScanearLugar(ActionEvent event) {
        mfc.getControlNave().setTextoComando(vehiculo.scanerLugar());
    }
    @FXML
    private void comandoTomarFotografia(ActionEvent event) {
        mfc.getControlNave().setTextoComando(vehiculo.tomarFotografia());
    }
    public void setVehiculo(NoTripulada vehiculo) {
        this.vehiculo = vehiculo;
    }

    
    
}
