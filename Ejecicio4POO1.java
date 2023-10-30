/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//en los "//" sabran donde va que para que se guien

package ejecicio4poo1;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author carlo
 */
public class Ejecicio4POO1 {
    public static void main(String[] args) throws Exception {
        Estudiantes2023 estudiantes2023 = new Estudiantes2023();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("BIENVENIDOS AL SISTEMA DE GESTIÓN DE ESTUDIANTES");
            System.out.println("1-NUEVO ESTUDIANTE");
            System.out.println("2-BUSCAR ESTUDIANTE");
            System.out.println("3-ELIMINAR ESTUDIANTE");
            System.out.println("4-MODIFICAR ESTUDIANTE");
            System.out.println("5-MODIFICAR APELLIDOS EN MINÚSCULAS");
            System.out.println("6-VER TODOS LOS ESTUDIANTES");
            System.out.println("7-VER TODOS LOS ESTUDIANTES POR APELLIDOS");
            System.out.println("8-VER TODOS LOS ESTUDIANTES POR PENSIÓN");
            System.out.println("9-TOTAL DE PENSIONES");
            System.out.println("10-SALIR");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // REGISTRAR A UN NUEVO ESTUDIANTE
                    System.out.println("****** REGISTRAR A UN NUEVO ESTUDIANTE ******** ");
                    System.out.print("Ingrese NOMBRES: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Ingrese APELLIDOS: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Ingrese CICLO: ");
                    int ciclo = scanner.nextInt();
                    System.out.print("Ingrese PENSION: ");
                    double pension = scanner.nextDouble();
                    Estudiante nuevoEstudiante = new Estudiante(estudiantes2023.tamano() + 1, nombres + " " + apellidos, ciclo, pension);
                    estudiantes2023.adicionar(nuevoEstudiante);
                    System.out.println("¡Se añadió con éxito!");
                    break;

                case 2:
                    // BUSCAR A UN ESTUDIANTE
                    System.out.println("****** BUSCAR A UN ESTUDIANTE ******");
                    System.out.println("Seleccione una opción de búsqueda:");
                    System.out.println("A - Búsqueda por Código");
                    System.out.println("B - Búsqueda por Apellido");
                    String opcionBusqueda = scanner.nextLine();
                    
                    if (opcionBusqueda.equalsIgnoreCase("A")) {
                        //Codigo
                        System.out.print("Ingrese el código del estudiante a buscar: ");
                        int codigo = scanner.nextInt();
                        Estudiante estudianteEncontrado = estudiantes2023.buscar(codigo);

                        if (estudianteEncontrado != null) {
                            System.out.println("Datos del estudiante:\n" + estudianteEncontrado.toString());
                        } else {
                            System.out.println("El estudiante no está registrado.");
                        }
                    } else if (opcionBusqueda.equalsIgnoreCase("B")) {
                        //Apellido
                        System.out.print("Ingrese el apellido del estudiante a buscar: ");
                        String apellidoBuscar = scanner.nextLine();
                        Estudiante estudianteApellido = estudiantes2023.buscarApellido(apellidoBuscar);

                        if (estudianteApellido != null) {
                            System.out.println("Datos del estudiante:\n" + estudianteApellido.toString());
                        } else {
                            System.out.println("No hay estudiantes registrados con el apellido " + apellidoBuscar);
                        }
                    } else {
                        System.out.println("Opción de búsqueda no válida.");
                    }
                    break;

                case 3:
                    // ELIMINACIÓN DEL ESTUDIANTE
                    System.out.println("****** ELIMINACIÓN DEL ESTUDIANTE ********");
                    System.out.print("Ingrese ID del estudiante a eliminar: ");
                    int idEstudianteEliminar = scanner.nextInt();
                    Estudiante estudianteAEliminar = estudiantes2023.buscar(idEstudianteEliminar);

                    if (estudianteAEliminar != null) {
                        estudiantes2023.eliminar(estudianteAEliminar);
                        System.out.println("¡Se eliminó con éxito!");
                    } else {
                        System.out.println("No se encontró un estudiante con el ID ingresado.");
                    }
                    break;

                case 4:
                    // MODIFICACION DEL ESTUDIANTE
                    System.out.println("****** MODIFICACION DEL ESTUDIANTE ********");
                    System.out.print("Ingrese el código del estudiante a modificar: ");
                    int codigoModificacion = scanner.nextInt();
                    Estudiante estudianteModificar = estudiantes2023.buscar(codigoModificacion);

                    if (estudianteModificar != null) {
                        System.out.print("Ingrese el nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese el nuevo ciclo: ");
                        int nuevoCiclo = scanner.nextInt();
                        System.out.print("Ingrese la nueva pensión: ");
                        double nuevaPension = scanner.nextDouble();

                        Estudiante nuevoEstudianteModificado = new Estudiante(estudianteModificar.getCodigo(), nuevoNombre, nuevoCiclo, nuevaPension);
                        estudiantes2023.modificarEstudiante(estudianteModificar, nuevoEstudianteModificado);
                        System.out.println("Estudiante modificado con éxito");
                    } else {
                        System.out.println("Estudiante no encontrado");
                    }
                    break;

                case 5:
                    // MODIFICACION ESTUDIANTE MINUSCULA
                    estudiantes2023.modificarApellidosMayuscula();
                    System.out.println("****** MODIFICACION ESTUDIANTE MINUSCULA ********");
                    System.out.println("Apellidos en Minúsculas:");
                    for (Estudiante estudiante : estudiantes2023.listarEstudiantes()) {
                        System.out.println(estudiante.getCodigo() + " " + estudiante.getNombre() + " " + estudiante.getCiclo() + " " + estudiante.getPension());
                    }
                    break;

                case 6:
                    // LISTA DE ESTUDIANTES
                    System.out.println("****** LISTA DE ESTUDIANTES ********");
                    for (Estudiante estudiante : estudiantes2023.listarEstudiantes()) {
                        System.out.println(estudiante.getCodigo() + " " + estudiante.getNombre() + " " + estudiante.getCiclo() + " " + estudiante.getPension());
                    }
                    break;

                case 7:
                    // ESTUDIANTES ORDENADOS POR APELLIDOS
                    estudiantes2023.listarEstudiantesApellido();
                    System.out.println("****** ESTUDIANTES ORDENADOS POR APELLIDOS ********");
                    for (Estudiante estudiante : estudiantes2023.listarEstudiantes()) {
                        System.out.println(estudiante.getCodigo() + " " + estudiante.getNombre() + " " + estudiante.getCiclo() + " " + estudiante.getPension());
                    }
                    break;

                case 8:
                    // ESTUDIANTES ORDENADOS POR PENSION ASCENDENTE
                    estudiantes2023.listarEstudiantesPorPensionAscendente();
                    System.out.println("****** ESTUDIANTES ORDENADOS POR PENSION ASCENDENTE ********");
                    for (Estudiante estudiante : estudiantes2023.listarEstudiantes()) {
                        System.out.println(estudiante.getCodigo() + " " + estudiante.getNombre() + " " + estudiante.getCiclo() + " " + estudiante.getPension());
                    }
                    break;

                case 9:
                    // SUMATORIA DE PENSIONES
                    double sumaPensiones = estudiantes2023.sumaTotalPensiones();
                    System.out.println("****** SUMATORIA DE PENSIONES ********");
                    System.out.println("Total de Pensiones: S/ " + sumaPensiones);
                    break;

                case 10:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 10);
    }
}

