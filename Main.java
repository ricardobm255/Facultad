import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControlEstudiantes controlEstudiantes = new ControlEstudiantes();
        Scanner Leer = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Guardar estudiantes");
            System.out.println("2. Buscar información de estudiantes");
            System.out.println("0. Salir");
            System.out.print("Ingrese el número de la opción que desea: ");
            opcion = Leer.nextInt();
            Leer.nextLine();

            switch (opcion) {
                case 1:
                    guardarEstudiantes(controlEstudiantes, Leer);
                    break;
                case 2:
                    buscarInformacionEstudiantes(controlEstudiantes, Leer);
                    break;
                case 0:
                    System.out.println("Hasta luego!!!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }

            System.out.println();
        } while (opcion != 0);

        Leer.close();
    }

    public static void guardarEstudiantes(ControlEstudiantes controlEstudiantes, Scanner Leer) {
        System.out.print("Ingrese la cantidad de estudiantes que desea guardar: ");
        int cantidadEstudiantes = Leer.nextInt();
        Leer.nextLine();

        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("Ingrese la informacion del estudiante " + (i + 1) + ":");

            // Solicitar y leer los datos del estudiante

            System.out.print("Nombre: ");
            String nombre = Leer.nextLine();

            System.out.print("Apellidos: ");
            String apellidos = Leer.nextLine();

            System.out.print("Carnet de Identidad: ");
            String carnetIdent = Leer.nextLine();

            System.out.print("Sexo: ");
            String sexo = Leer.nextLine();

            System.out.print("Año que cursa: ");
            int anoCursa = Leer.nextInt();
            Leer.nextLine();

            System.out.print("Tipo de estudiante (CRD o CT): ");
            String tipoEstudiante = Leer.nextLine();

            if (tipoEstudiante.equalsIgnoreCase("CRD")) {
                // Solicitar y leer datos adicionales para CRD

                System.out.print("Centro de procedencia: ");
                String centroProcedencia = Leer.nextLine();

                System.out.print("Indice general de 12 grado: ");
                double indiceGeneral12 = Leer.nextDouble();
                Leer.nextLine();

                // Crear instancia de CRD y guardarla
                CRD CRD = new CRD(nombre, apellidos, carnetIdent, sexo, anoCursa, centroProcedencia, indiceGeneral12);
                controlEstudiantes.guardarInformacionEstudiante(CRD);
            } else if (tipoEstudiante.equalsIgnoreCase("CT")) {
                // Solicitar y leer datos adicionales para CT

                System.out.print("Lugar de trabajo: ");
                String lugarTrabajo = Leer.nextLine();
                System.out.print("Salario: ");
                double salario = Leer.nextDouble();
                Leer.nextLine();

                // Crear instancia de CT y guardarla
                CT CT = new CT(nombre, apellidos, carnetIdent, sexo, anoCursa, lugarTrabajo, salario);
                controlEstudiantes.guardarInformacionEstudiante(CT);
            } else {
                System.out.println("Tipo de estudiante no válido. No se guardó el estudiante.");
            }

            System.out.println();
        }

        System.out.println("¡Estudiantes guardados exitosamente!");
    }

    public static void buscarInformacionEstudiantes(ControlEstudiantes controlEstudiantes, Scanner Leer) {
        int opcion;
        do {
            System.out.println("----- BUSCAR INFORMACION DE ESTUDIANTES -----");
            System.out.println("1. Buscar por carnet de identidad");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Buscar y mostrar nombres según año y tipo de curso");
            System.out.println("4. Mostrar información de los estudiantes del CT con salario mayor a la media general");
            System.out.println(
                    "5. Mostrar información de los estudiantes con índice general de 12 grado mayor a la media");
            System.out.println("6. Contar y mostrar los estudiantes según un sexo");
            System.out.println("0. Regresar al menú principal");
            System.out.print("Ingrese el número de la opción que desea: ");
            opcion = Leer.nextInt();
            Leer.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el carnet de identidad del estudiante: ");
                    String carnetIdent = Leer.nextLine();
                    Estudiante estudiante = controlEstudiantes.buscarEstudiantePorCarnet(carnetIdent);
                    if (estudiante != null) {
                        System.out.println("Estudiante encontrado:");
                        System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellidos());
                        System.out.println("Carnet de Identidad: " + estudiante.getCarnetIdent());
                        System.out.println("Sexo: " + estudiante.getSexo());
                        System.out.println("Año que cursa: " + estudiante.getAnoCursa());
                    } else {
                        System.out
                                .println("No se encontró ningún estudiante con el carnet de identidad proporcionado.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = Leer.nextLine();
                    estudiante = controlEstudiantes.buscarEstudiantePorNombre(nombre);
                    if (estudiante != null) {
                        System.out.println("Estudiante encontrado:");
                        System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellidos());
                        System.out.println("Carnet de Identidad: " + estudiante.getCarnetIdent());
                        System.out.println("Sexo: " + estudiante.getSexo());
                        System.out.println("Año que cursa: " + estudiante.getAnoCursa());
                    } else {
                        System.out.println("No se encontró ningún estudiante con el nombre proporcionado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el año que cursa: ");
                    int anoCursa = Leer.nextInt();
                    Leer.nextLine();

                    System.out.print("Ingrese el tipo de curso (CRD o CT): ");
                    String tipoCurso = Leer.nextLine();

                    System.out.println("Nombres de los estudiantes encontrados:");
                    controlEstudiantes.buscarYMostrarNombres(anoCursa, tipoCurso);

                    break;
                case 4:
                    System.out.println("Estudiantes del CT con salario mayor a la media:");
                    controlEstudiantes.mostrarEstudiantesCTSobreMedia();
                    break;
                case 5:
                    System.out.println("Estudiantes con índice general de 12 grado mayor a la media:");
                    controlEstudiantes.mostrarEstudiantesIndiceMayorMedia();
                    break;
                case 6:
                    System.out.print("Ingrese el sexo a contar (M o F): ");
                    String sexo = Leer.nextLine();
                    controlEstudiantes.contarYMostrarEstudiantesPorSexo(sexo);
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println();
        } while (opcion != 0);
    }
}