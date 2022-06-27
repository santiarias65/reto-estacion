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
import model.Lanzadera;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class ComandoLanzaderaController implements Initializable {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    private Lanzadera vehiculo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mfc.setControlComandoLanzadera(this);
    }    

    @FXML
    private void comandoSoltarCarga(ActionEvent event) {
        mfc.getControlNave().setTextoComando(vehiculo.soltarCarga());
    }
    

    @FXML
    private void comandoVerificarCarga(ActionEvent event) {
        mfc.getControlNave().setTextoComando(vehiculo.verificarCarga());
    }
    
    public void setVehiculo(Lanzadera vehiculo) {
        this.vehiculo = vehiculo;
    }
}
