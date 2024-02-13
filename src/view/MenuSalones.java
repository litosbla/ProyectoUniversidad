package view;

import java.util.Scanner;
import Servicios.SalonesService;
import Recursos.Salon;

public class MenuSalones {
    private SalonesService salonesService;
    private Scanner scanner;

    public MenuSalones(SalonesService salonesService, Scanner scanner) {
        this.salonesService = salonesService;
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("----- Menú Gestionar Salones -----");
            System.out.println("1. Agregar Salón");
            System.out.println("2. Eliminar Salón");
            System.out.println("3. Buscar Salón");
            System.out.println("4. Listar Salones");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarSalon();
                    break;
                case 2:
                    eliminarSalon();
                    break;
                case 3:
                    buscarSalon();
                    break;
                case 4:
                    listarSalones();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private void agregarSalon() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del salón:");
            int id = input.nextInt();
            input.nextLine(); // Limpiar el buffer del scanner
            System.out.println("Ingrese el nombre del salón:");
            String nombre = input.nextLine();

            Salon nuevoSalon = new Salon(id, id, nombre, id, nombre);
            salonesService.agregarSalon(nuevoSalon);
        }
        System.out.println("Salón agregado con éxito.");
    }

    private void eliminarSalon() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del salón que desea eliminar:");
            int id = input.nextInt();
            
            Salon salon = salonesService.buscarSalon(id);
            if (salon != null) {
                salonesService.eliminarSalon(id);
                System.out.println("Salón eliminado con éxito.");
            } else {
                System.out.println("El salón con ID " + id + " no existe.");
            }
        }
    }

    private void buscarSalon() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Ingrese el ID del salón que desea buscar:");
            int id = input.nextInt();
            
            Salon salon = salonesService.buscarSalon(id);
            if (salon != null) {
                System.out.println("Salón encontrado:");
                System.out.println("ID: " + salon.getIDSalon());
                System.out.println("Numero: " + salon.getNumeroIdentificacion());
            } else {
                System.out.println("El salón con ID " + id + " no existe.");
            }
        }
    }

    private void listarSalones() {
        System.out.println("Lista de Salones:");
        for (Salon salon : salonesService.obtenerTodos()) {
            System.out.println("ID: " + salon.getIDSalon() + ", Numero: " + salon.getNumeroIdentificacion());
        }
    }
}
