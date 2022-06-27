/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class NaveTripuladaController implements Initializable {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    @FXML
    private Label infoTripulantes;
    @FXML
    private Label infoMision;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mfc.setControlNaveTripulada(this);
    }    
    public void setTexto(String textoTripulantes,String textoMision){
        infoTripulantes.setText(textoTripulantes);
        infoMision.setText(textoMision);
    }
}
