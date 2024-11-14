package taller;

import javax.swing.*;
import java.awt.*;


public class coche extends JFrame {
    private static final long serialVersionUID = 1L;



   
    public coche() {
        initialize();
    }

    private void initialize() {
        setTitle("Coches");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

    }
}
