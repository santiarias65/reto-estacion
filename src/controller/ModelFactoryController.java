package controller;

import app.App;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estacion;
import model.Lanzadera;
import model.NoTripulada;
import model.Tripulada;
import model.Vehiculo;

public class ModelFactoryController {

    private App main;
    private Estacion estacion;
    //controladores de vehiculo
    private VistaNoTripuladaController controlNoTripuladaController;
    private VistaTripuladaController controlTripuladaController;
    private VistaLanzaderaController controlLanzaderaController;
    
    //controlador info nave
    private NaveController controlNave;
    private NaveNoTripuladaController controlNaveNoTripulada;
    private NaveTripuladaController controlNaveTripulada;
    private NaveLanzaderaController controlNaveLanzadera;
    
    //controlador comandos nave
    private ComandoNoTripuladaController controlComandoNoTripulada;
    private ComandoTripuladaController controlComandoTripulada;
    private ComandoLanzaderaController controlComandoLanzadera;
    
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aqu� al ser protected

        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // M�todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        estacion = new Estacion("NASA");
        abrirConexion();
        cargarDatosBd();
        cerrarConexion();
    }
    //---------------METODOS DE LA BASE DE DATOS--------------------
    private void abrirConexion() {
        try {   //servidor //usuario //clave
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost", "root", "");
            stmt = con.createStatement();
            rs = stmt.executeQuery("use estacion;");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    private void cerrarConexion() {
        try {
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //metodos sobrecargados
    public void agregarRegistroBd(NoTripulada vehiculo){
        abrirConexion();
        try {
            String query ="INSERT INTO vehiculo VALUES(null,'"+vehiculo.getTipoNave()+"','"+vehiculo.getNombre()+"','"
                    +vehiculo.getCombustible()+"','"+vehiculo.getPeso()+"','"+vehiculo.getEmpuje()+"','"+vehiculo.getDescripcion()+"');";
            stmt.executeUpdate(query);
            
            int ultimoId = obtenerUltimoIdVehiculo();
            query = "INSERT INTO notripulada VALUES('"+vehiculo.getEstudio()+"',"+ultimoId+");";
            stmt.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
    }
    public void agregarRegistroBd(Tripulada vehiculo){
        abrirConexion();
        try {
            String query ="INSERT INTO vehiculo VALUES(null,'"+vehiculo.getTipoNave()+"','"+vehiculo.getNombre()+"','"
                    +vehiculo.getCombustible()+"','"+vehiculo.getPeso()+"','"+vehiculo.getEmpuje()+"','"+vehiculo.getDescripcion()+"');";
            stmt.executeUpdate(query);
            
            int ultimoId = obtenerUltimoIdVehiculo();
            query = "INSERT INTO tripulada VALUES("+vehiculo.getNumeroTripulantes()+",'"+vehiculo.getMision()+"',"+ultimoId+");";
            stmt.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
    }
    public void agregarRegistroBd(Lanzadera vehiculo){
        abrirConexion();
        try {
            String query ="INSERT INTO vehiculo VALUES(null,'"+vehiculo.getTipoNave()+"','"+vehiculo.getNombre()+"','"
                    +vehiculo.getCombustible()+"','"+vehiculo.getPeso()+"','"+vehiculo.getEmpuje()+"','"+vehiculo.getDescripcion()+"');";
            stmt.executeUpdate(query);
            
            int ultimoId = obtenerUltimoIdVehiculo();
            query = "INSERT INTO lanzadera VALUES("+vehiculo.getCarga()+","+vehiculo.getPotencia()+","+ultimoId+");";
            stmt.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cerrarConexion();
    }
    
    public int obtenerUltimoIdVehiculo(){
        
        try {
            String query ="SELECT MAX(id) AS id FROM vehiculo;";
            rs = stmt.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    private void cargarDatosBd(){
        cargarDatosBdNoTripulada();
        cargarDatosBdTripulada();
        cargarDatosBdLanzadera();
    }
    private void cargarDatosBdNoTripulada(){
        try {
            String query = "SELECT v.tipo_nave,v.nombre,v.combustible,v.peso,v.empuje,v.descripcion,n.estudio FROM vehiculo v JOIN notripulada n ON n.VEHICULO_id = v.id;";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                NoTripulada vehiculo = new NoTripulada();
                
                //seteamos los datos al objeto
                vehiculo.setTipoNave(rs.getString(1));
                vehiculo.setNombre(rs.getString(2));
                vehiculo.setCombustible(rs.getString(3));
                vehiculo.setPeso(rs.getString(4));
                vehiculo.setEmpuje(rs.getString(5));
                vehiculo.setDescripcion(rs.getString(6));
                vehiculo.setEstudio(rs.getString(7));
                estacion.getListaVehiculos().add(vehiculo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cargarDatosBdTripulada(){
        try {
            String query = "SELECT v.tipo_nave,v.nombre,v.combustible,v.peso,v.empuje,v.descripcion,n.numero_tripulantes,n.mision FROM vehiculo v JOIN tripulada n ON n.VEHICULO_id = v.id;";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Tripulada vehiculo = new Tripulada();
                
                //seteamos los datos al objeto
                vehiculo.setTipoNave(rs.getString(1));
                vehiculo.setNombre(rs.getString(2));
                vehiculo.setCombustible(rs.getString(3));
                vehiculo.setPeso(rs.getString(4));
                vehiculo.setEmpuje(rs.getString(5));
                vehiculo.setDescripcion(rs.getString(6));
                vehiculo.setNumeroTripulantes(rs.getInt(7));
                vehiculo.setMision(rs.getString(8));
                estacion.getListaVehiculos().add(vehiculo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cargarDatosBdLanzadera(){
        try {
            String queryNoTripulada = "SELECT v.tipo_nave,v.nombre,v.combustible,v.peso,v.empuje,v.descripcion,n.carga,n.potencia FROM vehiculo v JOIN lanzadera n ON n.VEHICULO_id = v.id;";
            rs = stmt.executeQuery(queryNoTripulada);
            while(rs.next()){
                Lanzadera vehiculo = new Lanzadera();
                
                //seteamos los datos al objeto
                vehiculo.setTipoNave(rs.getString(1));
                vehiculo.setNombre(rs.getString(2));
                vehiculo.setCombustible(rs.getString(3));
                vehiculo.setPeso(rs.getString(4));
                vehiculo.setEmpuje(rs.getString(5));
                vehiculo.setDescripcion(rs.getString(6));
                vehiculo.setCarga(rs.getDouble(7));
                vehiculo.setPotencia(rs.getDouble(8));
                estacion.getListaVehiculos().add(vehiculo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelFactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----------------FIN METODOS BASE DE DATOS----------------
    public void agregarVehiculoEstacion(Vehiculo vehiculo) {
        estacion.getListaVehiculos().add(vehiculo);
    }

    //variables del controlador de naves no tripuladas CREAR
    public String estudioNoTripulado() {
        return controlNoTripuladaController.getTextoEstudio();
    }
    //----------------------------------------------------
    
    //variables del controlador naves tripuladas CREAR
    public int numeroTripulantes(){
        return Integer.parseInt(controlTripuladaController.getTextoNumeroIntegrantes().getText());
    }
    public String mision(){
        return controlTripuladaController.getTextoMision().getText();
    }
    //--------------------------------------------------
    
    //variables del controlador lanzaderas CREAR
    public double carga(){
        return Double.parseDouble(controlLanzaderaController.getTextoCarga().getText());
    }
    public double potencia(){
        return Double.parseDouble(controlLanzaderaController.getTextoPotencia().getText());
    }
    
    //variables del controlador navesNoTripuladas ADMINISTRACIO
    public void setTextoInfoEstudio(String texto){
        controlNaveNoTripulada.setTextoEstudio(texto);
    }
    public void setTextoNaveTripulada(String tripulantes,String mision){
        controlNaveTripulada.setTexto(tripulantes, mision);
    }
    public void setTextoNaveLanzadera(String carga,String potencia){
        controlNaveLanzadera.setTextoLanzadera(carga, potencia);
    }
    //----------------------fin control naves administracion--------------------
    //se retorna los vehiculos que se encuentran en la estacion
    public ArrayList<Vehiculo> vehiculosEnLaEstacion() {
        return estacion.getListaVehiculos();
    }
    
    //metodo que manda el objeto de la nave seleccionado a la administraccion
    public void administrarNave(NoTripulada vehiculo){
        controlNave.pasarInformacion(vehiculo);
    }
    public void administrarNave(Tripulada vehiculo){
        controlNave.pasarInformacion(vehiculo);
    }
    public void administrarNave(Lanzadera vehiculo){
        controlNave.pasarInformacion(vehiculo);
    }
    //------fin metodos sobre cargados
    public App getMain() {
        return main;
    }

    public void setMain(App main) {
        this.main = main;
    }

    public VistaNoTripuladaController getControlNoTripuladaController() {
        return controlNoTripuladaController;
    }

    public void setControlNoTripuladaController(VistaNoTripuladaController contrlNoTripuladaController) {
        this.controlNoTripuladaController = contrlNoTripuladaController;
    }

    public VistaTripuladaController getControlTripuladaController() {
        return controlTripuladaController;
    }

    public void setControlTripuladaController(VistaTripuladaController controlTripuladaController) {
        this.controlTripuladaController = controlTripuladaController;
    }

    public VistaLanzaderaController getControlLanzaderaController() {
        return controlLanzaderaController;
    }

    public void setControlLanzaderaController(VistaLanzaderaController controlLanzaderaController) {
        this.controlLanzaderaController = controlLanzaderaController;
    }

    public NaveController getControlNave() {
        return controlNave;
    }

    public void setControlNave(NaveController controlNave) {
        this.controlNave = controlNave;
    }

    public NaveNoTripuladaController getControlNaveNoTripulada() {
        return controlNaveNoTripulada;
    }

    public void setControlNaveNoTripulada(NaveNoTripuladaController controlNaveNoTripulada) {
        this.controlNaveNoTripulada = controlNaveNoTripulada;
    }

    public NaveTripuladaController getControlNaveTripulada() {
        return controlNaveTripulada;
    }

    public void setControlNaveTripulada(NaveTripuladaController controlNaveTripulada) {
        this.controlNaveTripulada = controlNaveTripulada;
    }

    public NaveLanzaderaController getControlNaveLanzadera() {
        return controlNaveLanzadera;
    }

    public void setControlNaveLanzadera(NaveLanzaderaController controlNaveLanzadera) {
        this.controlNaveLanzadera = controlNaveLanzadera;
    }

    public ComandoNoTripuladaController getControlComandoNoTripulada() {
        return controlComandoNoTripulada;
    }

    public void setControlComandoNoTripulada(ComandoNoTripuladaController controlComandoNoTripulada) {
        this.controlComandoNoTripulada = controlComandoNoTripulada;
    }

    public ComandoTripuladaController getControlComandoTripulada() {
        return controlComandoTripulada;
    }

    public void setControlComandoTripulada(ComandoTripuladaController controlComandoTripulada) {
        this.controlComandoTripulada = controlComandoTripulada;
    }

    public ComandoLanzaderaController getControlComandoLanzadera() {
        return controlComandoLanzadera;
    }

    public void setControlComandoLanzadera(ComandoLanzaderaController controlComandoLanzadera) {
        this.controlComandoLanzadera = controlComandoLanzadera;
    }
    

}
