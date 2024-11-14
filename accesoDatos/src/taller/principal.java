package taller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;



import javax.swing.JButton;

public class principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
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
	public principal() {
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
		
		JLabel lblPregunta = new JLabel("Seleccione un vehículo:");
		lblPregunta.setBounds(160, 11, 188, 14);
		frame.getContentPane().add(lblPregunta);
		
		JButton btnCoche = new JButton("Coche");
		btnCoche.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 coche mostrarCoche = new coche(); 
	            	 mostrarCoche.setVisible(true);
	            }
	        });
		btnCoche.setBounds(160, 62, 89, 23);
		frame.getContentPane().add(btnCoche);
		
		JButton btnMoto = new JButton("Moto");
		btnMoto.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 moto mostrarMoto = new moto(); 
	            	 mostrarMoto.setVisible(true);
	            }
	        });
		btnMoto.setBounds(160, 133, 89, 23);
		frame.getContentPane().add(btnMoto);
		
		JButton btnPatinete = new JButton("Patinete");
		btnPatinete.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 patinete mostrarPatinete = new patinete(); 
	            	 mostrarPatinete.setVisible(true);
	            }
	        });
		btnPatinete.setBounds(160, 200, 89, 23);
		frame.getContentPane().add(btnPatinete);
	}
}
