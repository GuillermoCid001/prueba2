package formulario;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class recogidaDatos extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSubir;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setBounds(100, 100, 450, 300);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                    recogidaDatos panel = new recogidaDatos();
                    frame.getContentPane().add(panel);
                    
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application panel.
     */
    public recogidaDatos() {
        initialize();
    }

    /**
     * Initialize the contents of the panel.
     */
    private void initialize() {
        setLayout(null); // Configuración del diseño del panel
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 22, 89, 14);
        add(lblNombre);
        
        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setBounds(10, 64, 89, 14);
        add(lblCorreo);
        
        JLabel lblSexo = new JLabel("Sexo");
        lblSexo.setBounds(10, 117, 89, 14);
        add(lblSexo);
        
        JLabel lblInteres = new JLabel("Intereses");
        lblInteres.setBounds(10, 170, 89, 14);
        add(lblInteres);
        
        btnSubir = new JButton("Subir");
        btnSubir.setBounds(340, 230, 89, 23);
        add(btnSubir);
        
        JTextArea textAreaNombre = new JTextArea();
        textAreaNombre.setBounds(140, 17, 162, 22);
        add(textAreaNombre);
        
        JTextArea textAreaCorreo = new JTextArea();
        textAreaCorreo.setBounds(140, 59, 162, 22);
        add(textAreaCorreo);
        
        JRadioButton btnH = new JRadioButton("H");
        btnH.setBounds(158, 113, 42, 23);
        add(btnH);
        
        JRadioButton btnM = new JRadioButton("M");
        btnM.setBounds(252, 113, 42, 23);
        add(btnM);
        
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(140, 166, 162, 22);
        comboBox.addItem("Informática");
        comboBox.addItem("Deportes");
        comboBox.addItem("Ninguno");
       

        add(comboBox);
        
        JComboBox<String>comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(205, 230, 125, 22);
        comboBox_1.addItem("bbdd1");
        comboBox_1.addItem("bbdd2");
        comboBox_1.addItem("bbdd3");
        add(comboBox_1);
        
        JLabel lblBaseDatos = new JLabel("Seleccione base de datos:");
        lblBaseDatos.setBounds(10, 234, 185, 14);
        add(lblBaseDatos);
    }
}
