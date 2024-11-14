package ddl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DML extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtSearchId;

    conectorBD metodos = new conectorBD();
    public DML() {
        initialize();
    }

    private void initialize() {
        setTitle("Gestión de Discos");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

       
        tableModel = new DefaultTableModel(new String[]{"ID", "Título", "Artista", "País", "Compañía", "Precio", "Fecha"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Buscar por ID:"));
        txtSearchId = new JTextField(10);
        searchPanel.add(txtSearchId);

        JButton btnSearch = new JButton("Buscar");
        searchPanel.add(btnSearch);
        getContentPane().add(searchPanel, BorderLayout.NORTH);
        
        JButton btnCasa = new JButton("Menú");
        btnCasa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                menu volver = new menu();
              
                volver.setVisible(true);
                DML.this.setVisible(false);
            }
        });
        searchPanel.add(btnCasa);
        

       
        metodos.cargarDiscos(tableModel);  

       
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buscarId = txtSearchId.getText().trim();  
                metodos.buscarIDdisco(tableModel, buscarId);  
            }
        });
    }
}
