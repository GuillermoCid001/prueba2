package peliculas;


import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;



public class menu extends JFrame {

    private static final long serialVersionUID = 1L;

    public menu() {
        initialize();
    }

    private void initialize() {
        setTitle("Menú Principal");
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JButton btnPeliculas = new JButton("Peliculas");
        btnPeliculas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                pelis mostrarPelis = new pelis();
              
                mostrarPelis.setVisible(true);
            }
        });
        btnPeliculas.setBounds(120, 56, 180, 23);
        getContentPane().add(btnPeliculas);
        
        JButton btnActores = new JButton("Actores");
        btnActores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                actores mostrarActores = new actores();
              
                mostrarActores.setVisible(true);
            }
        });
        
        btnActores.setBounds(120, 133, 180, 23);
        getContentPane().add(btnActores);
        
        JLabel lblMenu = new JLabel("Selecione una opción");
        lblMenu.setBounds(158, 11, 129, 14);
        getContentPane().add(lblMenu);

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