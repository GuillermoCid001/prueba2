package peliculas;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class actores extends JFrame {

    private static final long serialVersionUID = 1L;
    conectorPelis metodos = new conectorPelis();
	public actores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		  setTitle("Actores");
	        setBounds(100, 100, 450, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);
	        
	        
	        
	        JButton btnCasa = new JButton("Menú");
	        btnCasa.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	                menu volver = new menu();
	              
	                volver.setVisible(true);
	            }
	        });
	    
	        btnCasa.setBounds(10, 227, 89, 23);
	        getContentPane().add(btnCasa);

	        
	}

}
