package codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class VentanaSecundaria extends JDialog implements ActionListener {

    private JButton boton2;
    private JTextField TF_nombre;
    private JPasswordField passwordField;
    private Principal principal;

    // Constructor
    public VentanaSecundaria(Principal principal) {
        super(principal, true);
        this.principal = principal;

        // Centrar el JDialog en la pantalla
        setLocationRelativeTo(null);

        // Establecer el tamaño y otras propiedades del JDialog
        getContentPane().setBackground(new Color(21, 21, 31));
        getContentPane().setLayout(null);
        setBounds(540, 150, 460, 520);

        // Configurar etiqueta y campo de texto para el nombre de usuario
        JLabel label1_1 = new JLabel("Nombre de Usuario");
        label1_1.setForeground(new Color(255, 255, 255));
        label1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        label1_1.setHorizontalAlignment(SwingConstants.CENTER);
        label1_1.setBounds(98, 52, 227, 30);
        getContentPane().add(label1_1);

        TF_nombre = new JTextField();
        TF_nombre.setBounds(115, 92, 200, 30);
        getContentPane().add(TF_nombre);
        TF_nombre.setColumns(10);

        // Configurar etiqueta y campo de texto para la contraseña
        JLabel label1 = new JLabel("Contraseña");
        label1.setForeground(new Color(255, 255, 255));
        label1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBounds(115, 161, 200, 30);
        getContentPane().add(label1);

        passwordField = new JPasswordField();
        passwordField.setBounds(115, 202, 200, 30);
        getContentPane().add(passwordField);

        // Configurar botón de inicio de sesión
        boton2 = new JButton("Iniciar");
        boton2.setBounds(115, 349, 200, 40);
        getContentPane().add(boton2);
        boton2.addActionListener(this);

        // Configurar etiqueta para la imagen de fondo
        JLabel lblNewLabel = new JLabel("Foto");
        lblNewLabel.setBounds(115, 242, 200, 97);
        getContentPane().add(lblNewLabel);

        // Cargar y escalar la imagen
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/imagenes/f1logo.png")); // Modifica la ruta según corresponda
        Image image = imageIcon1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        lblNewLabel.setIcon(scaledImageIcon);

        // Agregar KeyListener al campo de texto de la contraseña para permitir el inicio de sesión con Enter
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    saveUser();
                }
            }
        });
    }

    // Método para manejar el inicio de sesión o registro de usuarios
    private void saveUser() {
        String nombre = TF_nombre.getText();
        String contrasena = new String(passwordField.getPassword());

        // Verificar si los campos de texto están vacíos
        if (nombre.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, introduzca nombre de usuario y contraseña.");
            return; // Detener el proceso si los campos están vacíos
        }

        // Verificar el nombre de usuario y la contraseña
        if (nombre.equals("admin") && contrasena.equals("admin123")) {
            // Si el nombre de usuario y la contraseña son correctos, mostrar JPanel_Admin
            principal.mostrarPanelAdmin();
        } else {
            // Si el nombre de usuario y la contraseña no son correctos, mostrar JPanel_User
            try {
                // Guardar el usuario en la base de datos
                ConexionUsuario usuario = new ConexionUsuario();
                usuario.addUser(nombre, contrasena);
                JOptionPane.showMessageDialog(this, "Usuario añadido con éxito.");
                // Mostrar el panel de usuario en el JFrame principal
                principal.mostrarPanelUsuario();
                // Cerrar el JDialog después de guardar el usuario
                dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }

        // Cerrar el JDialog después de verificar el usuario
        dispose();
    }

    // Método para manejar eventos de acción
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton2) {
            saveUser();
        }
    }
}
