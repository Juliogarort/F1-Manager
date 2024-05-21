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

       	// Icono de la ventana
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/LogoF1Manager.png"));
        setIconImage(icono.getImage());

        // Establecer las dimensiones y posicion de la ventana
        setBounds(100, 100, 608, 360);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setBackground(new Color(21, 21, 31));
        
        // Configuración del panel de contenido
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        // JScrollPane para permitir el desplazamiento
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 574, 190);
        getContentPane().add(scrollPane);
        
        // TextArea para mostrar los datos
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Textarea no editable
        scrollPane.setViewportView(textArea);  // Añadir el jtextarea al JScrollPane
        
        
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
