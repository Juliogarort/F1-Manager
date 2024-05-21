package codigo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {

    // Variables para los paneles
    private Jpanel_Login panelLogin;
    private JPanel_User panelUser;
    private JPanel_Admin panelAdmin;

    // Constructor
    public Principal() {

        // Reproducir sonido de fondo
        playBackgroundSound();

        // Configurar el icono de la aplicación
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/LogoF1Manager.png")); // Ruta a tu icono
        setIconImage(icono.getImage());

        // Crear instancias de los paneles
        panelLogin = new Jpanel_Login(this);
        panelUser = new JPanel_User();
        panelAdmin = new JPanel_Admin();

        // Establecer el diseño del JFrame como BorderLayout
        setLayout(new BorderLayout());

        // Agregar el panel de inicio (login) al centro del JFrame
        add(panelLogin, BorderLayout.CENTER);

        // Configurar título de la ventana
        setTitle("Login");

        // Configurar tamaño de la ventana
        setBounds(500, 250, 920, 570);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Hacer que la ventana no sea redimensionable
        setResizable(false);

        // Configurar operación de cierre
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Mostrar JFrame
        setVisible(true);
    }

    // Método para cambiar al panel de usuario
    public void mostrarPanelUsuario() {
        // Eliminar el panel de inicio
        getContentPane().remove(panelLogin);

        // Agregar el panel de usuario al centro del JFrame
        getContentPane().add(panelUser, BorderLayout.CENTER);

        // Volver a pintar el JFrame para que los cambios se reflejen
        revalidate();
        repaint();
    }

    // Método para cambiar al panel de administrador
    public void mostrarPanelAdmin() {
        // Eliminar el panel de inicio
        getContentPane().remove(panelLogin);

        // Agregar el panel de administrador al centro del JFrame
        getContentPane().add(panelAdmin, BorderLayout.CENTER);

        // Volver a pintar el JFrame para que los cambios se reflejen
        revalidate();
        repaint();
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        // Crear una instancia de la clase Principal
        Principal principal = new Principal();
    }

    // Método para reproducir el sonido de fondo
    public void playBackgroundSound() {
        try {
            // Cargar el archivo de audio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/imagenes/song.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // Reproducir el sonido en bucle continuo
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
