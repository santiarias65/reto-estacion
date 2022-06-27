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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class VistaLanzaderaController implements Initializable {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    @FXML
    private TextField textoCarga;
    @FXML
    private TextField textoPotencia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mfc.setControlLanzaderaController(this);
    }    

    public TextField getTextoCarga() {
        return textoCarga;
    }

    public void setTextoCarga(TextField textoCarga) {
        this.textoCarga = textoCarga;
    }

    public TextField getTextoPotencia() {
        return textoPotencia;
    }

    public void setTextoPotencia(TextField textoPotencia) {
        this.textoPotencia = textoPotencia;
    }
    
}
