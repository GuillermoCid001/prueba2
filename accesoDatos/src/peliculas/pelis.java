package peliculas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pelis extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    
    conectorPelis metodos = new conectorPelis();
    
    public pelis() {
        initialize();
    }

    private void initialize() {
        setTitle("Películas");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tableModel = new DefaultTableModel(new String[]{"ID", "Título"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 560, 250);
        getContentPane().add(scrollPane);

        JButton btnCasa = new JButton("Menú");
        btnCasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu volver = new menu();
                volver.setVisible(true);
                dispose();
            }
        });
        btnCasa.setBounds(10, 300, 89, 23);
        getContentPane().add(btnCasa);

        JButton btnCargarDatos = new JButton("Cargar Películas");
        btnCargarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarPeliculas();
            }
        });
        btnCargarDatos.setBounds(110, 300, 150, 23);
        getContentPane().add(btnCargarDatos);
    }

    private void cargarPeliculas() {
        tableModel.setRowCount(0); 
        metodos.consultarPelis(tableModel);
    }
}
