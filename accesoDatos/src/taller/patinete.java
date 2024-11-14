package taller;

import javax.swing.*;
import java.awt.*;


public class patinete extends JFrame {
    private static final long serialVersionUID = 1L;



   
    public patinete() {
        initialize();
    }

    private void initialize() {
        setTitle("Patinetes");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

    }
}
