public class CT extends Estudiante {
    private String lugarTrabajo;
    private double salario;

    public CT(String nombre, String apellidos, String carnetIdent, String sexo, int anoCursa,
            String lugarTrabajo, double salario) {
        super(nombre, apellidos, carnetIdent, sexo, anoCursa);
        this.lugarTrabajo = lugarTrabajo;
        this.salario = salario;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public double getSalario() {
        return salario;
    }
}
