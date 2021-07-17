package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ControlEscolar {
    private static Connection connection = null;
    private static List<Alumno> alumnos = new ArrayList<Alumno>();
    private static List<Materia> materias = new ArrayList<Materia>();
    private static List<Calificacion> calificaciones = new ArrayList<Calificacion>();

    // Obtener la información de inicio
    public static void getData() {
        openConnection();

        // #region Seleccionar a todos los alumnos de la base de datos
        boolean success = true;
        try {
            String query = "SELECT * FROM alumnos;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                alumnos.add(new Alumno(resultSet.getInt("matricula"),
                                       resultSet.getString("nombre"),
                                       resultSet.getString("apellido")));
            }
        } catch (SQLException e) {
            success = false;

            System.out.println("No se pudieron obtener los alumnos.");
        } if (success) {
            System.out.println("Alumnos obtenidos con éxito.");
        }
        // #endregion

        // #region Seleccionar todas las materias de la base de datos
        success = true;
        try {
            String query = "SELECT * FROM materias;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                materias.add(new Materia(resultSet.getInt("clave"),
                                         resultSet.getString("nombre"),
                                         resultSet.getInt("creditos")));
            }
        } catch (SQLException e) {
            success = false;

            System.out.println("No se pudieron obtener las materias.");
        } if (success) {
            System.out.println("Materias obtenidas con éxito.");
        }
        // #endregion

        // #region Seleccionar todas las calificaciones de la base de datos
        success = true;
        try {
            String query = "SELECT * FROM calificaciones;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                calificaciones.add(new Calificacion(resultSet.getInt("clave"),
                                              resultSet.getInt("matricula"),
                                              resultSet.getInt("calificacion")));
            }
        } catch (SQLException e) {
            success = false;

            System.out.println("No se pudieron obtener las calificaciones.");
        } if (success) {
            System.out.println("Calificaciones obtenidas con éxito.");
        }
        // #endregion

        closeConnection();
    }

    // Comenzar la conexión con la base de datos
    private static void openConnection() {
        boolean success = true;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            success = false;

            System.out.println("Clase no encontrada.");
        } if (success) {
            System.out.println("Clase encontrada.");
        }

        success = true;
        try {
            // String url = "jdbc:sqlite:D:/Documentos/NetBeansProjects/Sistema de control escolar/dbs/data.db";
            String url = "jdbc:sqlite:././dbs/data.db";

            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            success = false;

            System.out.println("No se pudo realizar la conexión con la base de datos.");
        } if (success) {
            System.out.println("Conexión a la base de datos realizada con éxito.");
        }
    }

    // Cerrar la conexión con la base de datos
    private static void closeConnection() {
        boolean success = true;

        try {
            connection.close();
        } catch (SQLException e) {
            success = false;

            System.out.println("Conexión con la base de datos no se pudo cerrar.");
        } if (success) {
            System.out.println("Conexión con la base de datos cerrada con éxito.");
        }
    }

    // Regresar la lista de todos los alumnos
    public static List<Alumno> getAlumnos() { return new ArrayList<>(alumnos); }

    // Regresar todas las materias
    public static List<Materia> getMaterias() { return new ArrayList<>(materias); }

    // Regresar todas las calificaciones
    public static List<Calificacion> getCalificaciones() { return new ArrayList<>(calificaciones); }

    // Agregar un alumno nuevo
    public static void addAlumno(int matricula, String nombre, String apellido) {
        String query;

        openConnection();

        query = "INSERT INTO alumnos (matricula, nombre, apellido) VALUES (" + Integer.toString(matricula) + ", \"" + nombre + "\", \"" + apellido + "\");";
        System.out.println(query);

        // #region Agregar el alumno a la tabla de alumnos
        boolean success = true;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            success = false;

            System.out.println("Error al agregar el alumno a la base de datos.");
            JOptionPane.showMessageDialog(null, "Error al agregar el alumno a la base de datos.");
        } if (success) {
            alumnos.add(new Alumno(matricula, nombre, apellido));

            System.out.println("Alumno agregado con éxito a la base de datos.");
            JOptionPane.showMessageDialog(null, "Alumno agregado con éxito a la base de datos.");
        }
        // #endregion

        // #region Agregar las calificaciones nulas al nuevo alumnos
        success = true;
        try {
            Statement statement = connection.createStatement();

            for (Materia materia : materias) {
                query = "INSERT INTO calificaciones (matricula, clave, calificacion) VALUES (" + Integer.toString(matricula) + ", " + Integer.toString(materia.getClave()) + ", " + Integer.toString(-1) + ");";

                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            success = false;

            System.out.println("Error al agregar las calificaciones del alumno nuevo.");
            JOptionPane.showMessageDialog(null, "Error al agregar las calificaciones del alumno nuevo.");
        } if (success) {
            for (Materia materia : materias) {
                calificaciones.add(new Calificacion(matricula, materia.getClave(), -1));
            }

            System.out.println("Calificaciones del alumno nuevo agregadas con éxito.");
            JOptionPane.showMessageDialog(null, "Calificaciones del alumno nuevo agregadas con éxito.");
        }
        // #endregion

        closeConnection();
    }

    // Actualizar calificacion
    public static void updateCalificacion(int matricula, int clave, int calificacion) {
        String query;

        openConnection();

        query = "UPDATE calificaciones SET calificacion = " + Integer.toString(calificacion) + " WHERE matricula = " + Integer.toString(matricula) + " AND clave = " + Integer.toString(clave) + ";";

        boolean success = true;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            success = false;

            System.out.println("Error al actualizar la calificación.");
        } if (success) {
            for (int i = 0; i < calificaciones.size(); i++) {
                if (calificaciones.get(i).getMatricula() == matricula && calificaciones.get(i).getClave() == clave) {
                    calificaciones.set(i, new Calificacion(matricula, clave, calificacion));
                }
            }

            System.out.println("Calificación actualizada con éxito.");
        }

        closeConnection();
    }

    // Obtener el promedio de los alumnos con todas las materias cursadas
    public static List<String[]> getPromedioTotalAlumnos() {
        List<String[]> valoresFinales = new ArrayList<String[]>();

        openConnection();

        boolean success = true;
        try {
            String query = "SELECT matricula, Avg(calificacion) as promedio FROM calificaciones WHERE calificacion != -1 GROUP BY matricula;";

            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String[] valores = {"1", "1"};
                valores[0] = resultSet.getString("matricula");
                valores[1] = resultSet.getString("promedio");
                valoresFinales.add(valores);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los promedios total de los alumnos.");
        } if (success) {
            System.out.println("Promedios totales de los alumnos obtenidos con éxito.");
        }

        closeConnection();

        return valoresFinales;
    }

    // Obtener el promedio de los alumnos sin materias reprobadas
    public static List<String[]> getPromedioParcialAlumnos() {
        List<String[]> valoresFinales = new ArrayList<String[]>();

        openConnection();

        boolean success = true;
        try {
            String query = "SELECT matricula, Avg(calificacion) as promedio FROM calificaciones WHERE calificacion >= 70 GROUP BY matricula;";

            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String[] valores = {"1", "1"};
                valores[0] = resultSet.getString("matricula");
                valores[1] = resultSet.getString("promedio");
                valoresFinales.add(valores);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los promedios total de los alumnos.");
        } if (success) {
            System.out.println("Promedios totales de los alumnos obtenidos con éxito.");
        }

        closeConnection();

        return valoresFinales;
    }

    // Obtener alumnos con sus respectivas materias reprobadas
    public static List<String[]> getAlumnosYReprobadas() {
        List<String[]> valoresFinales = new ArrayList<String[]>();
        String query = "SELECT matricula, clave FROM calificaciones WHERE calificacion != -1 AND calificacion < 70 GROUP BY matricula, clave;";

        boolean success = true;
        try {
            openConnection();

            Statement Statement = connection.createStatement();
            ResultSet resultSet = Statement.executeQuery(query);

            while (resultSet.next()) {
                String[] valores = {resultSet.getString("matricula"), resultSet.getString("clave")};
                valoresFinales.add(valores);
            }

            closeConnection();
        } catch (SQLException e) {
            success = false;

            System.out.println("Problema al obtener alumnos con sus materia reprobadas.");
        } if (success) {
           System.out.println("Alumnos con sus materia reprobadas obtenidos exitosamente.");
        }

        return valoresFinales;
    }

    // Obtener cantidad de extraordinarios por materia
    public static List<String[]> getExtraordinarios() {
        List<String[]> valoresFinales = new ArrayList<String[]>();
        String query = "SELECT clave, count(calificacion) as extraordinarios FROM calificaciones WHERE calificacion != -1 AND calificacion < 70 GROUP BY clave;";

        boolean success = true;
        try {
            openConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String[] valores = {resultSet.getString("clave"), resultSet.getString("extraordinarios")};
                valoresFinales.add(valores);
            }

            closeConnection();
        } catch (Exception e) {
            success = false;

            System.out.println("Problema al obtener los extraordinarios de la base de datos.");
        } if (success) {
            System.out.println("Extraordinarios obtenidos con éxito de la base de datos.");
        }

        return valoresFinales;
    }

    // Obtener nombre completo con la matrícula
    public static String getNombreByMatricula(int matricula) {
        for (Alumno alumno : alumnos) {
            if (alumno.getMatricula() == matricula) {
                String res = alumno.getNombre() + " " + alumno.getApellido();
                return res;
            }
        }
        return "error";
    }

    // Obtener el nombre de la materia con su clave
    public static String getNombreByClave(int clave) {
        for (Materia materia : materias) {
            if (materia.getClave() == clave) {
                return materia.getNombre();
            }
        }
        return "error";
    }


}