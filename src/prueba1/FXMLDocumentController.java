/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import Modelo.Estudiantes;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author daniel.cosme
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtNombre,txtTelefono,txtCorreo,txtCodigo,txtCarrera;
    @FXML
    private Button btnAgregar,btnGuardar; 
    
    LinkedList<Estudiantes> listaE;
    
    @FXML
    public void AgregarEstudiante(ActionEvent e){
        String nombreE = txtNombre.getText();
        String telefonoE = txtTelefono.getText();
        String correoE = txtCorreo.getText();
        String codigoE = txtCodigo.getText();
        String carreraE = txtCarrera.getText();
        
        Estudiantes objE = new Estudiantes(codigoE, nombreE, carreraE, telefonoE, correoE);
        listaE.add(objE);
        
    }
    
    @FXML
    private void guardarXML(ActionEvent event){
        Estudiantes objV = new Estudiantes();
        
        boolean guardar = objV.crearArchivoXML(listaE);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaE = new LinkedList<>();
    }    
    
}
