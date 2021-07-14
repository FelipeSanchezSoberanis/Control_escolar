package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ControlEscolar {
    private static Connection connection = null;
    public static List<Alumno> alumnos = new ArrayList<Alumno>();
    public static List<Materia> materias = new ArrayList<Materia>();
    public static List<Calificacion> calificaciones = new ArrayList<Calificacion>();

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
}