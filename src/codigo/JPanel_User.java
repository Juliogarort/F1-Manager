package codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class JPanel_User extends JPanel {
    // Instancia de la clase ConexionUsuario para manejar la base de datos
    ConexionUsuario conexionUsuario = new ConexionUsuario();
    private JTable tablepilotos; // Tabla para mostrar datos de pilotos

    public JPanel_User() {
        setLayout(null); // Usar un layout absoluto

        // Crear y configurar el botón 'circuito'
        JButton circuito = new JButton("");
        circuito.setBounds(351, 379, 210, 57);
        circuito.setContentAreaFilled(false); // Hacer que el área de contenido no esté rellena (fondo transparente)
        circuito.setBorderPainted(false); // Eliminar el borde
        add(circuito); // Añadir el botón al panel

        // Agregar ActionListener al botón 'circuito'
        circuito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mostrar pistas y abrir el diálogo correspondiente
                    mostrarPistas();
                    DialogoPista dialogoPista = new DialogoPista();
                    dialogoPista.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción si ocurre
                }
            }
        });

        // ------------------------------------------------------------------------------------
        // Cargar y escalar la imagen para el JButton 'circuito'
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imagenes/circuito.png")); // Modifica la ruta según corresponda
        Image image = imageIcon.getImage().getScaledInstance(circuito.getWidth(), circuito.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        circuito.setIcon(scaledImageIcon); // Establecer el ImageIcon en el JButton
        // -----------------------------------------------------------------------------------------

        // Crear y configurar el botón 'botoncoche'
        JButton botoncoche = new JButton();
        botoncoche.setBounds(140, 359, 140, 85);
        botoncoche.setContentAreaFilled(false); // Hacer que el área de contenido no esté rellena (fondo transparente)
        botoncoche.setBorderPainted(false); // Eliminar el borde
        add(botoncoche); // Añadir el botón al panel

        // Cargar y escalar la imagen para el JButton 'botoncoche'
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/imagenes/coche.png")); // Modifica la ruta según corresponda
        Image image1 = imageIcon1.getImage().getScaledInstance(botoncoche.getWidth(), botoncoche.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon1 = new ImageIcon(image1);
        botoncoche.setIcon(scaledImageIcon1); // Establecer el ImageIcon en el JButton

        // Agregar ActionListener al botón 'botoncoche'
        botoncoche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mostrar coches y abrir el diálogo correspondiente
                    mostrarCoches();
                    DialogoCoche dialogoCoche = new DialogoCoche();
                    dialogoCoche.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción si ocurre
                }
            }
        });

        // ----------------------------------------------------------------------------------------------------------------------------
        // Crear y configurar el botón 'piloto'
        JButton piloto = new JButton("");
        piloto.setBounds(614, 347, 105, 89);
        piloto.setContentAreaFilled(false); // Hacer que el área de contenido no esté rellena (fondo transparente)
        piloto.setBorderPainted(false); // Eliminar el borde
        add(piloto); // Añadir el botón al panel

        // Cargar y escalar la imagen para el JButton 'piloto'
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/imagenes/piloto.png")); // Modifica la ruta según corresponda
        Image image2 = imageIcon2.getImage().getScaledInstance(piloto.getWidth(), piloto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon2 = new ImageIcon(image2);
        piloto.setIcon(scaledImageIcon2); // Establecer el ImageIcon en el JButton

        // Agregar ActionListener al botón 'piloto'
        piloto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mostrar pilotos y abrir el diálogo correspondiente
                    mostrarPilotos();
                    DialogoPiloto dialogoPiloto = new DialogoPiloto();
                    dialogoPiloto.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción si ocurre
                }
            }
        });
    }

    // Métodos para obtener datos de la base de datos
    private void mostrarPilotos() throws SQLException {
        conexionUsuario.getDataPilotos();
    }

    private void mostrarCoches() throws SQLException {
        conexionUsuario.getDataCoches();
    }

    private void mostrarPistas() throws SQLException {
        conexionUsuario.getDataPistas();
    }

    // Sobrescribir el método paintComponent para dibujar la imagen de fondo
    @Override
    public void paintComponent(Graphics g) {
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/F1_User.png"));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintComponent(g); // Llama al método de la superclase para asegurar el comportamiento predeterminado
    }
}
