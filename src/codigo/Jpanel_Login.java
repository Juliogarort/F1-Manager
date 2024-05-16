package codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jpanel_Login extends JPanel {

    private JButton login;
    private Image backgroundImage;
    private Principal principal; // Campo de referencia al JFrame principal

    // Modifica el constructor para aceptar una referencia al JFrame principal
    public Jpanel_Login(Principal principal) {
        this.principal = principal; // Asigna la referencia al campo principal

        setLayout(null);
        login = new JButton("Iniciar Sesion");
        login.setBounds(349, 386, 200, 50);
        add(login);

        // Cargar la imagen de fondo
        backgroundImage = new ImageIcon(getClass().getResource("/imagenes/Fondo_formula_1.png")).getImage();

        // Agregar ActionListener al botón login
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == login) {
                    /* Utiliza la referencia al JFrame principal para abrir la ventana secundaria */
                    VentanaSecundaria secundaria = new VentanaSecundaria(principal);
                    secundaria.setVisible(true);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}