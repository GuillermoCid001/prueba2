package interfazmapas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class menu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private HashMap<String, String[]> datosMap = new HashMap<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dni");
		lblNewLabel.setBounds(67, 14, 66, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(67, 45, 66, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblNmero = new JLabel("Número");
		lblNmero.setBounds(67, 76, 66, 14);
		frame.getContentPane().add(lblNmero);
		
		textField = new JTextField();
		textField.setBounds(143, 11, 180, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 42, 180, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 73, 180, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = textField.getText();
				String nombre = textField_1.getText();
				String numero = textField_2.getText();

				datosMap.put(dni, new String[]{nombre, numero});
				
				JOptionPane.showMessageDialog(frame, "Datos guardados correctamente.");
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnNewButton.setBounds(182, 104, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = textField_3.getText();

				if (datosMap.containsKey(dni)) {
					String[] datos = datosMap.get(dni);
					String nombre = datos[0];
					String numero = datos[1];
					JOptionPane.showMessageDialog(frame, "Nombre: " + nombre + "\nNúmero: " + numero);
				} else {
					JOptionPane.showMessageDialog(frame, "DNI no encontrado.");
				}
			}
		});
		btnBuscar.setBounds(10, 211, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblBuscar = new JLabel("Introduce DNI para buscar:");
		lblBuscar.setBounds(10, 157, 200, 14);
		frame.getContentPane().add(lblBuscar);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 182, 180, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnFichero = new JButton("Fichero");
		btnFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (FileWriter writer = new FileWriter("c:\\eclipse\\prueba.csv")) {
					
					writer.write("DNI,Nombre,Teléfono\n");

					for (String dni : datosMap.keySet()) {
						String[] datos = datosMap.get(dni);
						writer.write(dni + "," + datos[0] + "," + datos[1] + "\n");
					}
					
					JOptionPane.showMessageDialog(frame, "Fichero generado correctamente.");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame, "Ocurrió un error al escribir en el archivo.");
					e1.printStackTrace();
				}
			}
		});
		btnFichero.setBounds(281, 153, 89, 23);
		frame.getContentPane().add(btnFichero);
		
		JButton btnXml = new JButton("Xml");
        btnXml.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (FileWriter writer = new FileWriter("c:\\eclipse\\prueba.xml")) {
                    writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                    writer.write("<usuarios>\n");
                    
                    for (String dni : datosMap.keySet()) {
                        String[] datos = datosMap.get(dni);
                        String nombre = datos[0];
                        String telefono = datos[1];
                        
                        writer.write("    <usuario>\n");
                        writer.write("        <dni>" + dni + "</dni>\n");
                        writer.write("        <nombre>" + nombre + "</nombre>\n");
                        writer.write("        <telefono>" + telefono + "</telefono>\n");
                        writer.write("    </usuario>\n");
                    }
                    
                    writer.write("</usuarios>\n");
                    
                    JOptionPane.showMessageDialog(frame, "Fichero XML generado correctamente.");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, "Ocurrió un error al escribir el archivo XML.");
                    e1.printStackTrace();
                }
            }
        });
        
        btnXml.setBounds(281, 211, 89, 23);
        frame.getContentPane().add(btnXml);
    }
}