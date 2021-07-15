package App;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ControlEscolar.getData();
        List<String[]> promediosTotales = ControlEscolar.getPromedioTotalAlumnos();
        List<String[]> promediosParciales = ControlEscolar.getPromedioParcialAlumnos();

        for (String[] promedio : promediosTotales) {
            System.out.println("Matricula: " + promedio[0] + " | Promedio Total: " + promedio[1]);
        }

        for (String[] promedio : promediosParciales) {
            System.out.println("Matricula: " + promedio[0] + " | Promedio Parcial: " + promedio[1]);
        }

        ControlEscolar.updateCalificacion(2851, 97346, 100);
    }
}