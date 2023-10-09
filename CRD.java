public class CRD extends Estudiante {
    private String centroProcedencia;
    private double indiceGeneral12;

    public CRD(String nombre, String apellidos, String carnetIdent, String sexo, int anoCursa,
            String centroProcedencia, double indiceGeneral12) {
        super(nombre, apellidos, carnetIdent, sexo, anoCursa);
        this.centroProcedencia = centroProcedencia;
        this.indiceGeneral12 = indiceGeneral12;
    }

    public String getCentroProcedencia() {
        return centroProcedencia;
    }

    public double getIndiceGeneral12() {
        return indiceGeneral12;
    }
}
