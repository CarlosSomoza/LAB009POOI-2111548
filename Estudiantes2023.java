/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecicio4poo1;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class Estudiantes2023 {
    private ArrayList<Estudiante> estudiantes;

    public Estudiantes2023() {
        estudiantes = new ArrayList<>();
        cargarArchivo();
    }

    public void adicionar(Estudiante estudiante) {
        int nuevoCodigo = obtenerSiguienteCodigoDisponible(); 
        estudiante.setCodigo(nuevoCodigo);
        estudiantes.add(estudiante);
        guardarArchivo();
    }
    
    public void eliminar(Estudiante estudiante) {
       estudiantes.remove(estudiante);
        guardarArchivo();
    }
//
	
    public boolean eliminarEstudiante(int codigo) {
    for (Estudiante estudiante : estudiantes) {
        if (estudiante.getCodigo() == codigo) {
            estudiantes.remove(estudiante);
            return true; // Estudiante eliminado con éxito
        }
    }
    return false; // No se encontró el estudiante a eliminar
}

   public void verTodosLosEstudiantes() {
    if (estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes registrados.");
    } else {
        System.out.println("Lista de estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
  // Generar codigo a estudiante nuevo
    private int obtenerSiguienteCodigoDisponible() {
        if (!estudiantes.isEmpty()) {
            int ultimoCodigo = estudiantes.get(estudiantes.size() - 1).getCodigo();
            return ultimoCodigo + 1; 
        } else {
            return 100; 
        }
    }

    //Busqueda por apellido
    public Estudiante buscarApellido(String apellido) {
        for (Estudiante estudiante : estudiantes) {
            String[] partesNombre = estudiante.getNombre().split(" ");
            if (partesNombre.length > 1) {
                if (partesNombre[1].equalsIgnoreCase(apellido)) {
                    return estudiante;
                }
            }
        }
        return null;
    }

    // M�todos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            createStudent(st);
        }
        br.close();
    }

	// M�todo que a�adir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createStudent(StringTokenizer st){
int codigo = Integer.parseInt(st.nextToken().trim());
String nombre = st.nextToken().trim();
int ciclo = Integer.parseInt(st.nextToken().trim());
double pension = Double.parseDouble(st.nextToken().trim());
Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
adicionar(estudiante);


    }

    // M�todos para manipular el archivo de texto
    private void cargarArchivo() {
        try {
            File file = new File("./src/ejecicio4poo1/estudiantes.txt");
            Class<Estudiantes2023> clazz = Estudiantes2023.class;
            InputStream inputStream = clazz.getResourceAsStream("./estudiantes.txt");
            if (file.exists()) {
                readFromInputStream(inputStream);
            } else
                JOptionPane.showMessageDialog(null,
                        "El archivo estudiantes.txt no existe");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }
}
