import java.util.ArrayList;
import java.util.List;

public class ControlEstudiantes {
        private List<Estudiante> estudiantes;

        public ControlEstudiantes() {
            estudiantes = new ArrayList<>();
        }

        // Permitir guardar la información de los estudiantes
        public void guardarInformacionEstudiante(Estudiante estudiante) {
            estudiantes.add(estudiante);
        }

        // Buscar un estudiante por su carnet de identidad
        public Estudiante buscarEstudiantePorCarnet(String carnet) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getCarnetIdent().equals(carnet)) {
                    return estudiante;
                }
            }
            return null;
        }

        // Buscar y mostrar los nombres de los estudiantes según el año que cursa y tipo
        // de Curso
        public void buscarYMostrarNombres(int anoCursa, String tipoCurso) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getAnoCursa() == anoCursa && estudiante instanceof CRD) {
                    System.out.println(estudiante.getNombre() + " " + estudiante.getApellidos());
                }
            }
        }

        // Mostrar la información de los estudiantes del CT que su salario sea mayor a
        // la media general
        public void mostrarEstudiantesCTSobreMedia() {
            double mediaSalarios = calcularMediaSalarios();
            for (Estudiante estudiante : estudiantes) {
                if (estudiante instanceof CT && ((CT) estudiante).getSalario() > mediaSalarios) {
                    System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellidos());
                    System.out.println("Carnet de Identidad: " + estudiante.getCarnetIdent());
                    System.out.println("Lugar de trabajo: " + ((CT) estudiante).getLugarTrabajo());
                    System.out.println("Salario: " + ((CT) estudiante).getSalario());
                    System.out.println("-------------------------------------");
                }
            }
        }

        // Buscar un estudiante por el nombre
        public Estudiante buscarEstudiantePorNombre(String nombre) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                    return estudiante;
                }
            }
            return null;
        }

        // Mostrar la información de los estudiantes que su índice general de 12 grado
        // sea mayor a la media
        public void mostrarEstudiantesIndiceMayorMedia() {
            double mediaIndices = calcularMediaIndices();
            for (Estudiante estudiante : estudiantes) {
                if (estudiante instanceof CRD && ((CRD) estudiante).getIndiceGeneral12() > mediaIndices) {
                    System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellidos());
                    System.out.println("Carnet de Identidad: " + estudiante.getCarnetIdent());
                    System.out.println("Centro de procedencia: " + ((CRD) estudiante).getCentroProcedencia());
                    System.out.println("Índice general de 12 grado: " + ((CRD) estudiante).getIndiceGeneral12());
                    System.out.println("-------------------------------------");
                }
            }
        }

        // Contar y Mostrar los estudiantes según un sexo
        public void contarYMostrarEstudiantesPorSexo(String sexo) {
            int count = 0;
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getSexo().equalsIgnoreCase(sexo)) {
                    count++;
                }
            }

            System.out.println("Cantidad de estudiantes del sexo " + sexo + ": " + count);
        }

        // Calcular la media de salarios de los estudiantes del CT
        private double calcularMediaSalarios() {
            double sumaSalarios = 0;
            int contadorEstudiantesCT = 0;
            for (Estudiante estudiante : estudiantes) {
                if (estudiante instanceof CT) {
                    sumaSalarios += ((CT) estudiante).getSalario();
                    contadorEstudiantesCT++;
                }
            }

            return contadorEstudiantesCT == 0 ? 0 : sumaSalarios / contadorEstudiantesCT;
        }

        // Calcular la media de los índices generales de 12 grado de los estudiantes del
        // CRD
        private double calcularMediaIndices() {
            double sumaIndices = 0;
            int contadorEstudiantesCRD = 0;
            for (Estudiante estudiante : estudiantes) {
                if (estudiante instanceof CRD) {
                    sumaIndices += ((CRD) estudiante).getIndiceGeneral12();
                    contadorEstudiantesCRD++;
                }
            }

            return contadorEstudiantesCRD == 0 ? 0 : sumaIndices / contadorEstudiantesCRD;
        }
    }