/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.ModelFactoryController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author santi
 */
public class App extends Application {

    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    private Stage stagePrincipal;
    private Stage administracion;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mfc.setMain(this);//guardamos el main en el model factory
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            //Stage stage = new Stage();
            stagePrincipal = primaryStage;
            stagePrincipal.setScene(scene);
            //stagePrincipal.getIcons().add(new Image("/img/pacmanDerecha.png"));
            stagePrincipal.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void abrirAdministracion() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Nave.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            //Stage stage = new Stage();
            administracion = new Stage();
            administracion.setScene(scene);
            //stagePrincipal.getIcons().add(new Image("/img/pacmanDerecha.png"));
            administracion.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //complementos de las vistas de agregar naves
    public Pane complementoNaveNoTripulada() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaNoTripulada.fxml"));
            Pane root = loader.load();
            return root;
        } catch (IOException ex) {
            return null;
        }
    }

    public Pane complementoNaveTripulada() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaTripulada.fxml"));
            Pane root = loader.load();
            return root;
        } catch (IOException ex) {
            return null;
        }
    }

    public Pane complementoNaveLanzada() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaLanzadera.fxml"));
            Pane root = loader.load();
            return root;
        } catch (IOException ex) {
            return null;
        }
    }
    
    //fin complemento agregar naves
    
    //complementos administrar naves
    public VBox complementoAdministrarNaveNoTripulada(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NaveNoTripulada.fxml"));
            Pane root = loader.load();
            return (VBox) root;
        } catch (IOException ex) {
            return null;
        }
    }
    
    public VBox complementoAdministrarNaveTripulada(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NaveTripulada.fxml"));
            Pane root = loader.load();
            return (VBox) root;
        } catch (IOException ex) {
            return null;
        }
    }
    
    public VBox complementoAdministrarNaveLanzadera(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NaveLanzadera.fxml"));
            Pane root = loader.load();
            return (VBox) root;
        } catch (IOException ex) {
            return null;
        }
    }
    //fin complemento administracion nava
    
    //inicio complemento comandos
    public VBox complementoComandoNoTripulada(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ComandoNoTripulada.fxml"));
            Pane root = loader.load();
            return (VBox) root;
        } catch (IOException ex) {
            return null;
        }
    }
    public VBox complementoComandoTripulada(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ComandoTripulada.fxml"));
            Pane root = loader.load();
            return (VBox) root;
        } catch (IOException ex) {
            return null;
        }
    }
    public VBox complementoComandoLanzadera(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ComandoLanzadera.fxml"));
            Pane root = loader.load();
            return (VBox) root;
        } catch (IOException ex) {
            return null;
        }
    }
}
