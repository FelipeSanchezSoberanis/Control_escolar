package App;

public class Materia {
    private int clave;
    private String nombre;
    private int creditos;

    Materia(int clave, String nombre, int creditos) {
        this.clave = clave;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int getClave() { return clave; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
}