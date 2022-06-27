/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class VistaNoTripuladaController implements Initializable {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    
    @FXML
    private TextArea textoEstudio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mfc.setControlNoTripuladaController(this);
    }    

    public String getTextoEstudio() {
        return textoEstudio.getText();
    }

    
}
