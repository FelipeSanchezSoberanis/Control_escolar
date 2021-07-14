package App;

public class App {
    public static void main(String[] args) {
        ControlEscolar.getData();

        for (Alumno alumno : ControlEscolar.alumnos) {
            System.out.println("Matricula: " + Integer.toString(alumno.getMatricula()) + " | Nombre completo: " + alumno.getNombre() + " " + alumno.getApellido());
        }

        for (Materia materia : ControlEscolar.materias) {
            System.out.println("Clave: " + Integer.toString(materia.getClave()) + " | Nombre: " + materia.getNombre() + " | Créditos: " + Integer.toString(materia.getCreditos()));
        }

        for (Calificacion calificacion : ControlEscolar.calificaciones) {
            System.out.println("Clave: " + Integer.toString(calificacion.getClave()) + " | Matricula: " + Integer.toString(calificacion.getMatricula()) + " | Calificacion: " + Integer.toString(calificacion.getCalificacion()));
        }
    }
}