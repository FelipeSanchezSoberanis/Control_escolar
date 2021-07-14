package App;

public class Calificacion {
    private int matricula;
    private int clave;
    private int calificacion;

    Calificacion(int matricula, int clave, int calificacion) {
        this.matricula = matricula;
        this.clave = clave;
        this.calificacion = calificacion;
    }

    public int getMatricula() { return matricula; }
    public int getClave() { return clave; }
    public int getCalificacion() { return calificacion; }
}