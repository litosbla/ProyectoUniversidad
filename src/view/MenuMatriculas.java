package view;

import Servicios.MatriculasService;
import Recursos.Matricula;

import java.util.Scanner;

public class MenuMatriculas {
    private MatriculasService matriculasService;
    private Scanner scanner;

    public MenuMatriculas(MatriculasService matriculasService, Scanner scanner) {
        this.matriculasService = matriculasService;
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("----- Menú de Matrículas -----");
            System.out.println("1. Agregar matrícula");
            System.out.println("2. Eliminar matrícula");
            System.out.println("3. Buscar matrícula por ID");
            System.out.println("4. Mostrar todas las matrículas");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarMatricula();
                    break;
                case 2:
                    eliminarMatricula();
                    break;
                case 3:
                    buscarMatricula();
                    break;
                case 4:
                    mostrarTodasMatriculas();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private void agregarMatricula() {
        System.out.println("Ingrese el ID de la matrícula:");
        int id = scanner.nextInt();
        System.out.println("Ingrese el ID del alumno:");
        int idAlumno = scanner.nextInt();
        System.out.println("Ingrese el ID de la asignatura:");
        int idAsignatura = scanner.nextInt();
        System.out.println("Ingrese el día de la matrícula:");
        String dia = scanner.next();
        System.out.println("Ingrese la hora de inicio:");
        String horaInicio = scanner.next();
        System.out.println("Ingrese la hora de fin:");
        String horaFin = scanner.next();
        System.out.println("Ingrese el ID del salón:");
        int idSalon = scanner.nextInt();

        Matricula matricula = new Matricula(id, idAlumno, idAsignatura, dia, horaInicio, horaFin, idSalon);
        matriculasService.agregarMatricula(matricula);
        System.out.println("Matrícula agregada con éxito.");
    }

    private void eliminarMatricula() {
        System.out.println("Ingrese el ID de la matrícula a eliminar:");
        int id = scanner.nextInt();
        matriculasService.eliminarMatricula(id);
        System.out.println("Matrícula eliminada con éxito.");
    }

    private void buscarMatricula() {
        System.out.println("Ingrese el ID de la matrícula a buscar:");
        int id = scanner.nextInt();
        Matricula matricula = matriculasService.buscarMatricula(id);
        if (matricula != null) {
            System.out.println("Matrícula encontrada:");
            System.out.println(matricula);
        } else {
            System.out.println("Matrícula no encontrada.");
        }
    }

    private void mostrarTodasMatriculas() {
        System.out.println("Todas las matrículas:");
        for (Matricula matricula : matriculasService.obtenerTodasMatriculas()) {
            System.out.println(matricula);
        }
    }
}
