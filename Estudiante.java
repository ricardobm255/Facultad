public class Estudiante {
    private String nombre;
    private String apellidos;
    private String carnetIdent;
    private String sexo;
    private int anoCursa;

    public Estudiante(String nombre, String apellidos, String carnetIdent, String sexo, int anoCursa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.carnetIdent = carnetIdent;
        this.sexo = sexo;
        this.anoCursa = anoCursa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCarnetIdent() {
        return carnetIdent;
    }

    public void setCarnetIdent(String carnetIdent) {
        this.carnetIdent = carnetIdent;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAnoCursa() {
        return anoCursa;
    }

    public void setAnoCursa(int anoCursa) {
        this.anoCursa = anoCursa;
    }

}