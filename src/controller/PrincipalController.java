/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import model.Lanzadera;
import model.NoTripulada;
import model.Tripulada;
import model.Vehiculo;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class PrincipalController implements Initializable {

    private ObservableList<Vehiculo> listaFiltro = FXCollections.observableArrayList();
    private ModelFactoryController mfc = ModelFactoryController.getInstance();
    private ObservableList<Vehiculo> observableVehiculos = FXCollections.observableList(mfc.vehiculosEnLaEstacion());
    @FXML
    private ComboBox<String> comboPeso;
    @FXML
    private ComboBox<String> comboEmpuje;
    @FXML
    private Pane pane;
    @FXML
    private TextField textoNombreNave;
    @FXML
    private ComboBox<String> comboTipoNave;
    @FXML
    private TextField textoCombustible;
    @FXML
    private TextField textoPeso;
    @FXML
    private TextField textoEmpuje;
    @FXML
    private TextArea textoDescripcion;
    @FXML
    private TableView<Vehiculo> tablaVehiculos;
    @FXML
    private TableColumn<Vehiculo, String> columnaNombre;
    @FXML
    private TableColumn<Vehiculo, String> columnaCombustible;
    @FXML
    private TableColumn<Vehiculo, String> columnaPeso;
    @FXML
    private TableColumn<Vehiculo, String> columnaEmpuje;
    @FXML
    private TableColumn<Vehiculo, String> columnaDescripcion;
    @FXML
    private TableColumn<Vehiculo, String> columnaTipoNave;
    @FXML
    private TextField textoFiltro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarCombo();
        cargarTabla();

    }

    //se cargan opciones al combo
    public void cargarCombo() {
        ArrayList<String> medida = new ArrayList<>();
        ArrayList<String> tipoNave = new ArrayList<>();
        medida.add("KG");
        medida.add("T");

        tipoNave.add("Nave No Tripulada");
        tipoNave.add("Nave Tripulada");
        tipoNave.add("Vehiculo de Lanzadera");
        comboPeso.getItems().addAll(medida);
        comboEmpuje.getItems().addAll(medida);
        comboTipoNave.getItems().addAll(tipoNave);
    }

    //cargar vehiculos a la tabla
    public void cargarTabla() {
        columnaTipoNave.setCellValueFactory(new PropertyValueFactory<>("tipoNave"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCombustible.setCellValueFactory(new PropertyValueFactory<>("combustible"));
        columnaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        columnaEmpuje.setCellValueFactory(new PropertyValueFactory<>("empuje"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tablaVehiculos.setItems(observableVehiculos);

    }

    //metodo que agrega naves a la lista
    @FXML
    private void agregarNave(ActionEvent event) {
        String tipoNave = comboTipoNave.getSelectionModel().getSelectedItem();
        //peso con su unidad de medida
        String pesoMedida = textoPeso.getText() + comboPeso.getSelectionModel().getSelectedItem();
        //empuje con su unidad de medida
        String empujeMedida = textoEmpuje.getText() + comboEmpuje.getSelectionModel().getSelectedItem();

        String seleccion = comboTipoNave.getSelectionModel().getSelectedItem();
        if (seleccion.equalsIgnoreCase("Nave No Tripulada")) {
            NoTripulada naveNoTripulada = new NoTripulada(tipoNave, textoNombreNave.getText(), textoCombustible.getText(), pesoMedida, empujeMedida, textoDescripcion.getText(), mfc.estudioNoTripulado());
            //mfc.agregarVehiculoEstacion(naveNoTripulada);
            observableVehiculos.add(naveNoTripulada);
            mfc.agregarRegistroBd(naveNoTripulada);
        }
        if (seleccion.equalsIgnoreCase("Nave Tripulada")) {
            Tripulada naveTripulada = new Tripulada(tipoNave, textoNombreNave.getText(), textoCombustible.getText(), pesoMedida, empujeMedida, textoDescripcion.getText(), mfc.numeroTripulantes(), mfc.mision());
            observableVehiculos.add(naveTripulada);
            mfc.agregarRegistroBd(naveTripulada);
        }
        if (seleccion.equalsIgnoreCase("Vehiculo de Lanzadera")) {
            Lanzadera naveLanzadera = new Lanzadera(tipoNave, textoNombreNave.getText(), textoCombustible.getText(), pesoMedida, empujeMedida, textoDescripcion.getText(), mfc.carga(), mfc.potencia());
            observableVehiculos.add(naveLanzadera);
            mfc.agregarRegistroBd(naveLanzadera);
        }
        JOptionPane.showMessageDialog(null, "Se agrego una Nueva Nave");
        limpiarDatos();
        tablaVehiculos.refresh();
    }

    public void limpiarDatos() {
        textoCombustible.setText("");
        textoDescripcion.setText("");
        textoEmpuje.setText("");
        textoFiltro.setText("");
        textoNombreNave.setText("");
        textoPeso.setText("");

        comboEmpuje.getSelectionModel().clearSelection();
        comboPeso.getSelectionModel().clearSelection();
        comboTipoNave.getSelectionModel().clearSelection();

    }

    @FXML
    private void actionTipoNave(ActionEvent event) {
        try {
            String seleccion = comboTipoNave.getSelectionModel().getSelectedItem();
            pane.getChildren().clear();
            if (seleccion.equalsIgnoreCase("Nave No Tripulada")) {
                Pane root = mfc.getMain().complementoNaveNoTripulada();
                pane.getChildren().add(root);
            }
            if (seleccion.equalsIgnoreCase("Nave Tripulada")) {
                Pane root = mfc.getMain().complementoNaveTripulada();
                pane.getChildren().add(root);
            }
            if (seleccion.equalsIgnoreCase("Vehiculo de Lanzadera")) {
                Pane root = mfc.getMain().complementoNaveLanzada();
                pane.getChildren().add(root);
            }
        } catch (Exception e) {
            //control de la excepcion al limpiar los datos cuando se crea una nave nueva
        }
    }

    @FXML
    private void filtro(KeyEvent event) {
        String filtro = textoFiltro.getText().toLowerCase();
        if (filtro.isEmpty()) {
            tablaVehiculos.setItems(observableVehiculos);
        } else {
            listaFiltro.clear();
            for (Vehiculo v : observableVehiculos) {
                if (v.getTipoNave().toLowerCase().contains(filtro) ||
                        v.getNombre().toLowerCase().contains(filtro) ||
                        v.getCombustible().contains(filtro)||
                        v.getEmpuje().contains(filtro)||
                        v.getPeso().contains(filtro)||
                        v.getDescripcion().contains(filtro)) {
                    listaFiltro.add(v);
                }
            }
            tablaVehiculos.setItems(listaFiltro);
        }
    }

    @FXML
    private void administrar(ActionEvent event) {
        Vehiculo naveSeleccionada = tablaVehiculos.getSelectionModel().getSelectedItem();
        //abrimos la vista de la administracion 
        mfc.getMain().abrirAdministracion();

        if (naveSeleccionada.getTipoNave().equals("Nave No Tripulada")) {
            mfc.administrarNave((NoTripulada) naveSeleccionada);
        }
        if (naveSeleccionada.getTipoNave().equals("Nave Tripulada")) {
            mfc.administrarNave((Tripulada) naveSeleccionada);
        }
        if (naveSeleccionada.getTipoNave().equals("Vehiculo de Lanzadera")) {
            mfc.administrarNave((Lanzadera) naveSeleccionada);
        }
    }

}
