package App;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ControlEscolar.getData();
        List<String[]> promediosTotales = ControlEscolar.getPromedioTotalAlumnos();
        List<String[]> promediosParciales = ControlEscolar.getPromedioParcialAlumnos();
        List<String[]> alumnosConReprobadas = ControlEscolar.getAlumnosYReprobadas();
        List<String[]> extraordinarios = ControlEscolar.getExtraordinarios();


        for (String[] promedio : promediosTotales) {
            System.out.println("Matricula: " + promedio[0] + " | Promedio Total: " + promedio[1]);
        }

        for (String[] promedio : promediosParciales) {
            System.out.println("Matricula: " + promedio[0] + " | Promedio Parcial: " + promedio[1]);
        }

        for (String[] alumno : alumnosConReprobadas) {
            System.out.println("Matricula: " + alumno[0] + " | Clave: " + alumno[1]);
        }

        for (String[] extraordinario : extraordinarios) {
            System.out.println("Clave: " + extraordinario[0] + " | Extraordinarios: " + extraordinario[1]);
        }

    }
}