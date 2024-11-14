package peliculas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class login {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
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
    public login() {
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
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(150, 40, 120, 14);
        frame.getContentPane().add(lblUsuario);
        
        JTextArea txtUsuario = new JTextArea();
        txtUsuario.setBounds(150, 70, 120, 22);
        frame.getContentPane().add(txtUsuario);
        
        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(150, 130, 120, 14);
        frame.getContentPane().add(lblContra);
        
        JTextArea txtContra = new JTextArea();
        txtContra.setBounds(150, 167, 120, 22);
        frame.getContentPane().add(txtContra);
        
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contrasena = new String(txtContra.getText());

                if ("sakila".equals(usuario) && "12345".equals(contrasena)) {
                    JOptionPane.showMessageDialog(frame, "¡Acceso permitido!");
                    menu mostrarMenu = new menu(); 
                    mostrarMenu.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEntrar.setBounds(168, 227, 89, 23);
        frame.getContentPane().add(btnEntrar);
    }
}
