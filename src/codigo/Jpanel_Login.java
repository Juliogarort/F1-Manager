package codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jpanel_Login extends JPanel {

    // Botón de inicio de sesión
    private JButton login;
    // Imagen de fondo del panel
    private Image backgroundImage;
    // Referencia al JFrame principal
    private Principal principal;

    // Constructor que acepta una referencia al JFrame principal
    public Jpanel_Login(Principal principal) {
        // Asigna la referencia al JFrame principal al campo de clase
        this.principal = principal;

        // Establece el layout del panel como null para usar coordenadas absolutas
        setLayout(null);

        // Crea y configura el botón de inicio de sesión
        login = new JButton("Iniciar Sesion");
        login.setBounds(349, 386, 200, 50); // Establece la posición y tamaño del botón
        add(login); // Añade el botón al panel

        // Cargar la imagen de fondo desde los recursos
        backgroundImage = new ImageIcon(getClass().getResource("/imagenes/Fondo_formula_1.png")).getImage();

        // Agrega un ActionListener al botón de inicio de sesión
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verifica si el evento de acción es del botón de inicio de sesión
                if (e.getSource() == login) {
                    // Crea y muestra una ventana secundaria utilizando la referencia al JFrame principal
                    VentanaSecundaria secundaria = new VentanaSecundaria(principal);
                    secundaria.setVisible(true); // Muestra la ventana secundaria
                }
            }
        });
    }

    // Sobrescribe el método paintComponent para dibujar la imagen de fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método de la superclase para asegurar el comportamiento predeterminado
        // Dibujar la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen en todo el panel
    }
}
