package ddl;

import javax.swing.*;
import org.w3c.dom.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class DDL extends JFrame {

    private static final long serialVersionUID = 1L;
    private conectorBD metodos = new conectorBD(); 

    public DDL() {
        initialize();
    }

    private void initialize() {
        setTitle("Gestión de Base de Datos");
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnCargarXML = new JButton("Cargar XML en BD");
        btnCargarXML.setBounds(130, 80, 180, 30);
        getContentPane().add(btnCargarXML);

        btnCargarXML.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rutaArchivo = "c:\\discos.xml";

                
                metodos.crearBaseDatos();

             
                Connection conn = conectorBD.getConnection(); 

                if (conn != null) {
                    Document doc = metodos.leerXMLDesdeArchivo(rutaArchivo);
                    if (doc != null) {
                        metodos.procesarXML(doc);
                        JOptionPane.showMessageDialog(null, "XML cargado en la base de datos correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al cargar el archivo XML.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos 'prueba'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnEliminarBD = new JButton("Eliminar Base de Datos");
        btnEliminarBD.setBounds(130, 140, 180, 30);
        getContentPane().add(btnEliminarBD);
        
        JButton btnCasa = new JButton("Menú");
        btnCasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                menu volver = new menu();
              
                volver.setVisible(true);
            }
        });
    
        btnCasa.setBounds(10, 227, 89, 23);
        getContentPane().add(btnCasa);

        btnEliminarBD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar la base de datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    metodos.eliminarBaseDatos();
                    JOptionPane.showMessageDialog(null, "Base de datos eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    }

