package ddl;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class conectorBD {
    private static final String DB_NAME = "prueba";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "2713";
    private static final String TABLE_NAME = "cd";
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
        } catch (Exception e) {
            System.err.println("Error al conectarse a la base de datos: " + e.getMessage());
            return null;
        }
    }

    
    public void crearBaseDatos() {
        String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
             
            stmt.executeUpdate(sql);
            System.out.println("Base de datos 'prueba' creada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear la base de datos: " + e.getMessage());
        }
    }

   
    public Document leerXMLDesdeArchivo(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            return dBuilder.parse(archivo);
        } catch (Exception e) {
            System.err.println("Error al leer el archivo XML: " + e.getMessage());
            return null;
        }
    }

    
    public void crearTablaSiNoExiste(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + "id INT PRIMARY KEY,"
                + "titulo VARCHAR(255),"
                + "artista VARCHAR(255),"
                + "pais VARCHAR(255),"
                + "compania VARCHAR(255),"
                + "precio DOUBLE,"
                + "fecha INT"
                + ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabla 'catalogo' creada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }

   
    public void procesarXML(Document doc) {
        try (Connection conn = getConnection()) {
            if (conn != null) {

                crearTablaSiNoExiste(conn);

                NodeList cdList = doc.getElementsByTagName("cd");
                String sql = "INSERT INTO " + TABLE_NAME + " (id, titulo, artista, pais, compania, precio, fecha) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    for (int i = 0; i < cdList.getLength(); i++) {
                        Node node = cdList.item(i);

                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) node;

                            
                            int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                            String titulo = eElement.getElementsByTagName("titulo").item(0).getTextContent();
                            String artista = eElement.getElementsByTagName("artista").item(0).getTextContent();
                            String pais = eElement.getElementsByTagName("pais").item(0).getTextContent();
                            String compania = eElement.getElementsByTagName("compania").item(0).getTextContent();
                            double precio = Double.parseDouble(eElement.getElementsByTagName("precio").item(0).getTextContent());
                            int fecha = Integer.parseInt(eElement.getElementsByTagName("fecha").item(0).getTextContent());

                           
                            stmt.setInt(1, id);
                            stmt.setString(2, titulo);
                            stmt.setString(3, artista);
                            stmt.setString(4, pais);
                            stmt.setString(5, compania);
                            stmt.setDouble(6, precio);
                            stmt.setInt(7, fecha);

                            stmt.executeUpdate();
                        }
                    }
                    System.out.println("Datos insertados en la tabla.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al procesar el XML: " + e.getMessage());
        }
    }

   
    public void eliminarBaseDatos() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String sql = "DROP DATABASE IF EXISTS " + DB_NAME;
            stmt.executeUpdate(sql);
            System.out.println("Base de datos eliminada.");

        } catch (SQLException e) {
            System.err.println("Error al eliminar la base de datos: " + e.getMessage());
        }
    }
    public void cargarDiscos(DefaultTableModel tableModel) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME);
             ResultSet rs = stmt.executeQuery()) {

            
            tableModel.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String artista = rs.getString("artista");
                String pais = rs.getString("pais");
                String compania = rs.getString("compania");
                double precio = rs.getDouble("precio");
                int fecha = rs.getInt("fecha");

                tableModel.addRow(new Object[]{id, titulo, artista, pais, compania, precio, fecha});
            }

        } catch (SQLException e) {
            System.err.println("Error al cargar los discos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al cargar los discos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void buscarIDdisco(DefaultTableModel tableModel, String buscarId) {
        if (buscarId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un ID.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?")) {

            stmt.setInt(1, Integer.parseInt(buscarId));
            ResultSet rs = stmt.executeQuery();

            tableModel.setRowCount(0); 

            if (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String artista = rs.getString("artista");
                String pais = rs.getString("pais");
                String compania = rs.getString("compania");
                double precio = rs.getDouble("precio");
                int fecha = rs.getInt("fecha");

                tableModel.addRow(new Object[]{id, titulo, artista, pais, compania, precio, fecha});
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el disco con ID: " + buscarId, "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar el disco: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al buscar el disco: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

}
