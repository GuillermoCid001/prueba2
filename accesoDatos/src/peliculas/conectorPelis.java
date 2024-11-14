package peliculas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class conectorPelis {
    private static final String DB_NAME = "sakila";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "2713";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
        } catch (Exception e) {
            System.err.println("Error al conectarse a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public void consultarPelis(DefaultTableModel tableModel) {
        String consulta = "SELECT film_id, title FROM film";
        
        try (Connection conexion = getConnection();
             PreparedStatement statement = conexion.prepareStatement(consulta);
             ResultSet recogerDatos = statement.executeQuery()) {

            while (recogerDatos.next()) {
                int id = recogerDatos.getInt("film_id");
                String titulo = recogerDatos.getString("title");
                String descripcion = recogerDatos.getString("description");
                int año = recogerDatos.getInt("release_year");
                int lenguaje = recogerDatos.getInt("languaje_id");
                int lenguajeOrigunal = recogerDatos.getInt("original_languaje_id");
                int alquiler = recogerDatos.getInt("rental_duration");
                int ratio = recogerDatos.getInt("rental_rate");
                
                tableModel.addRow(new Object[]{id, titulo,descripcion,año,lenguaje,lenguajeOrigunal,alquiler,ratio});
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}
