package codigo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class DialogoPiloto extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public DialogoPiloto() throws SQLException {
        setTitle("Consulta de Pilotos"); 

    	getContentPane().setBackground(new Color(21, 21, 31));
    	
    	// Icono de la ventana
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/LogoF1Manager.png"));
        setIconImage(icono.getImage());

        // Establecer las dimensiones y posicion de la ventana
        setBounds(100, 100, 608, 360);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
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
        scrollPane.setViewportView(textArea); // Añadir el jtextarea al JScrollPane
        
        
        // Llamar al método para cargar los datos en el JLabel
        cargarDatos(textArea);
        
        JLabel lblNewLabel = new JLabel("Foto");
        lblNewLabel.setBounds(148, 222, 257, 91);
        getContentPane().add(lblNewLabel);

        // Cargar la imagen para el JButton
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/imagenes/pilotos.jpg")); // Modifica la ruta según corresponda
        // Escalar la imagen al tamaño del JButton
        Image image = imageIcon1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon scaledImageIcon = new ImageIcon(image);
        // Establecer el ImageIcon en el JButton
        lblNewLabel.setIcon(scaledImageIcon);
    }

    // Método para cargar los datos en el JTextArea
    public void cargarDatos(JTextArea textArea) throws SQLException {
        // Obtener la lista de datos almacenados en la clase Conexion
        ConexionUsuario conexion = new ConexionUsuario();
        List<Piloto> listaPilotos = conexion.getDataPilotos();

        // Limpiar el JTextArea
        textArea.setText("");

        // Agregar los datos al JTextArea
        for (Piloto Piloto : listaPilotos) {
            textArea.append(Piloto.toString() + "\n");
        }
    }
}
