/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 *
 * @author Usuario
 */
public class Estudiantes extends Persona {
    
    private String codigo;
    private String carrera;

    public Estudiantes() {
    }
    
    public Estudiantes(String codigo, String nombre, String carrera, String telefono, String correo) {
        super(nombre, telefono, correo);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    public Estudiantes(String codigo, String carrera) {
        this.codigo = codigo;
        this.carrera = carrera;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + codigo + ";" + carrera;
    }
    
    public void desplegar(){
        System.out.println(codigo + " " + nombre + " " + carrera + " " + telefono + " " + correo);
    }
    
    public boolean BuscarPersona(LinkedList<Estudiantes> ListaEstudiantes){
        boolean busqueda = false;
        String buscar = JOptionPane.showInputDialog("Ingrese el estudiante a buscar");
        
        for (int i = 0; i < ListaEstudiantes.size(); i++) {
            if(buscar.equals(ListaEstudiantes.get(i).codigo)){
                busqueda = true;
                JOptionPane.showMessageDialog(null, ListaEstudiantes.get(i));
                break;
            }       
        }        
        return busqueda;
    }

    public boolean crearArchivoXML(LinkedList<Estudiantes> listaE) {
        boolean g = false;
            
        try {
            Element universidad = new Element("universidad");
            Document doc = new Document(universidad);
            
            for (int i = 0; i < listaE.size(); i++) {
                Element estudiante = new Element("estudiante");
                estudiante.addContent(new Element("nombre").setText(listaE.get(i).getNombre()));
                estudiante.addContent(new Element("telefono").setText(listaE.get(i).getTelefono()));
                estudiante.addContent(new Element("correo").setText(listaE.get(i).getCorreo()));
                estudiante.addContent(new Element("codigo").setText(listaE.get(i).getCodigo()));
                estudiante.addContent(new Element("carrera").setText(listaE.get(i).getCarrera()));
                
                doc.getRootElement().addContent(estudiante);               
            }
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("universidad.xml"));
            
            g = true;
            
            System.out.println("Archivo Creado");
        } catch(IOException io){
            System.out.println(io.getMessage());
            g=false;
        }
        
        return g;
    }
}
