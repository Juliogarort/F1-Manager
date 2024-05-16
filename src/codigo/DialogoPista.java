package codigo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class DialogoPista extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public DialogoPista() throws SQLException {
        setTitle("Consulta de Circuitos"); 

    	getContentPane().setBackground(new Color(21, 21, 31));

        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/LogoF1Manager.png"));
        setIconImage(icono.getImage());

        setBounds(100, 100, 608, 360);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setBackground(new Color(21, 21, 31));
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 574, 190);
        getContentPane().add(scrollPane);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
        
        
        // Llamar al método para cargar los datos en el JLabel
        cargarDatos(textArea);
        
        
    }

    // Método para cargar los datos en el JTextArea
    public void cargarDatos(JTextArea textArea) throws SQLException {
        // Obtener la lista de datos almacenados en la clase Conexion
        ConexionUsuario conexion = new ConexionUsuario();
        List<Pistas> listaPistas = conexion.getDataPistas();

        // Limpiar el JTextArea
        textArea.setText("");

        // Agregar los datos al JTextArea
        for (Pistas pista : listaPistas) {
            textArea.append(pista.toString() + "\n");
        }
    }
}
