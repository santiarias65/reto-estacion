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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class VistaTripuladaController implements Initializable {
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    @FXML
    private TextField textoNumeroIntegrantes;
    @FXML
    private TextArea textoMision;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mfc.setControlTripuladaController(this);
    }    

    public TextField getTextoNumeroIntegrantes() {
        return textoNumeroIntegrantes;
    }

    public void setTextoNumeroIntegrantes(TextField textoNumeroIntegrantes) {
        this.textoNumeroIntegrantes = textoNumeroIntegrantes;
    }

    public TextArea getTextoMision() {
        return textoMision;
    }

    public void setTextoMision(TextArea textoMision) {
        this.textoMision = textoMision;
    }
    
}
