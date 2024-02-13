package view;

import java.util.List;
import java.util.Scanner;
import Servicios.TarifasService;
import Recursos.Tarifa;

public class MenuTarifas {
    private TarifasService tarifasService;
    private Scanner scanner;

    public MenuTarifas(TarifasService tarifasService, Scanner scanner) {
        this.tarifasService = tarifasService;
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("----- Menú Tarifas -----");
            System.out.println("1. Agregar Tarifa");
            System.out.println("2. Eliminar Tarifa");
            System.out.println("3. Buscar Tarifa por ID");
            System.out.println("4. Mostrar todas las Tarifas");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarTarifa();
                    break;
                case 2:
                    eliminarTarifa();
                    break;
                case 3:
                    buscarTarifa();
                    break;
                case 4:
                    mostrarTodasTarifas();
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

    private void agregarTarifa() {
        System.out.println("Ingrese el ID de la tarifa:");
        int idTarifa = scanner.nextInt();
        System.out.println("Ingrese el costo de la tarifa:");
        double costo = scanner.nextDouble();
        System.out.println("Ingrese el ID del periodo:");
        int idPeriodo = scanner.nextInt();
        System.out.println("Ingrese el ID del programa:");
        int idPrograma = scanner.nextInt();
        
        Tarifa nuevaTarifa = new Tarifa(idTarifa, costo, idPeriodo, idPrograma);
        tarifasService.agregarTarifa(nuevaTarifa);
        System.out.println("Tarifa agregada con éxito.");
    }
    

    private void eliminarTarifa() {
        System.out.println("Ingrese el ID de la tarifa a eliminar:");
        int idTarifa = scanner.nextInt();
        tarifasService.eliminarTarifa(idTarifa);
        System.out.println("Tarifa eliminada con éxito.");
    }

    private void buscarTarifa() {
        System.out.println("Ingrese el ID de la tarifa a buscar:");
        int idTarifa = scanner.nextInt();
        Tarifa tarifaEncontrada = tarifasService.buscarTarifa(idTarifa);
        if (tarifaEncontrada != null) {
            System.out.println("Tarifa encontrada:");
            System.out.println(tarifaEncontrada);
        } else {
            System.out.println("No se encontró ninguna tarifa con el ID especificado.");
        }
    }

    private void mostrarTodasTarifas() {
        List<Tarifa> todasTarifas = tarifasService.obtenerTodas();
        if (!todasTarifas.isEmpty()) {
            System.out.println("Todas las tarifas:");
            for (Tarifa tarifa : todasTarifas) {
                System.out.println(tarifa);
            }
        } else {
            System.out.println("No hay tarifas registradas.");
        }
    }
}
