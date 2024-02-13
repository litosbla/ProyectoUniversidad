import java.util.Scanner;

import Servicios.AlumnosService;
import Servicios.AsignaturasService;
import Servicios.CursoService;
import Servicios.DepartamentosService;
import Servicios.MatriculasService;
import Servicios.ProfesoresService;
import Servicios.ProgramasService;
import Servicios.SalonesService;
import Servicios.TarifasService;
import view.MenuAlumnos;
import view.MenuAsignaturas;
import view.MenuCursos;
import view.MenuDepartamentos;
import view.MenuMatriculas;
import view.MenuProfesores;
import view.MenuProgramas;
import view.MenuSalones;
import view.MenuTarifas;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Ingrese el usuario de la base de datos: ");
        //String usuario = scanner.nextLine();
        //System.out.println("Ingrese la contraseña de la base de datos: ");
        //String contraseña = scanner.nextLine();

        //Conexion conexion = new Conexion("Proyecto", usuario, contraseña);
        //conexion.conectar();


        // Si la conexión se establece correctamente, proceder con el menú principal
        //if (conexion.conectar() != null) 
        {
            DepartamentosService departamentosService = new DepartamentosService();
            ProfesoresService profesorService = new ProfesoresService();
            AlumnosService alumnoService = new AlumnosService();
            CursoService cursoService = new CursoService();
            AsignaturasService asignaturaService = new AsignaturasService();
            ProgramasService ProgramasService = new ProgramasService();
            SalonesService salonService = new SalonesService();
            TarifasService tarifaService = new TarifasService();
            MatriculasService matriculaService = new MatriculasService();

            int opcion;
            do {
                // Mostrar el menú principal
                System.out.println("----- Menú Principal -----");
                System.out.println("1. Gestionar Departamentos");
                System.out.println("2. Gestionar Profesores");
                System.out.println("3. Gestionar Alumnos");
                System.out.println("4. Gestionar Cursos");
                System.out.println("5. Gestionar Asignaturas");
                System.out.println("6. Gestionar Programas");
                System.out.println("7. Gestionar Salones");
                System.out.println("8. Gestionar Tarifas");
                System.out.println("9. Gestionar Matrículas");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                
                // Consumir el carácter de nueva línea pendiente
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        // Gestionar Departamentos
                        MenuDepartamentos menuDepartamentos = new MenuDepartamentos(departamentosService, scanner);
                        menuDepartamentos.mostrarMenu();
                        break;
                    case 2:
                        // Gestionar Profesores
                        MenuProfesores menuProfesores = new MenuProfesores(profesorService, scanner);
                        menuProfesores.mostrarMenu();
                        break;
                    case 3:
                        // Gestionar Alumnos
                        MenuAlumnos menuAlumnos = new MenuAlumnos(alumnoService, scanner);
                        menuAlumnos.mostrarMenu();
                        break;
                    case 4:
                        // Gestionar Cursos
                        MenuCursos menuCursos = new MenuCursos(cursoService, scanner);
                        menuCursos.mostrarMenu();
                        break;
                    case 5:
                        // Gestionar Asignaturas
                        MenuAsignaturas menuAsignaturas = new MenuAsignaturas(asignaturaService, scanner);
                        menuAsignaturas.mostrarMenu();
                        break;
                    case 6:
                        //gestionar Programas
                        MenuProgramas MenuProgramas = new MenuProgramas(ProgramasService, scanner);
                        MenuProgramas.mostrarMenu();

                    case 7:
                        // Gestionar Salones
                        MenuSalones MenuSalones = new MenuSalones(salonService, scanner);
                        MenuSalones.mostrarMenu();
                        break;
                    case 8:
                        // Gestionar Tarifas
                        MenuTarifas MenuTarifas = new MenuTarifas(tarifaService, scanner);
                        MenuTarifas.mostrarMenu();
                        break;
                    case 9:
                        // Gestionar Matrículas
                        MenuMatriculas MenuMatriculas = new MenuMatriculas(matriculaService, scanner);
                        MenuMatriculas.mostrarMenu();
                        break;
                    case 0:
                        // Salir del sistema
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                        break;
                }

            } while (opcion != 0);
        } 
        //else {
        //    System.out.println("No se pudo establecer la conexión a la base de datos. Saliendo del sistema...");}
        scanner.close();
    }
}
