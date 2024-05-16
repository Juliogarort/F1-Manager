package codigo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Principal extends JFrame {

	// Variables
	private Jpanel_Login panelLogin;
	private JPanel_User panelUser;
	private JPanel_Admin panelAdmin;

	// Constructor
	public Principal() {

		playBackgroundSound();


		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/LogoF1Manager.png")); // Ruta a tu icono
		setIconImage(icono.getImage());

		// Crear instancias de los paneles
		panelLogin = new Jpanel_Login(this);
		panelUser = new JPanel_User();
		panelAdmin = new JPanel_Admin();


		// Establecer el diseño del JFrame como BorderLayout
		setLayout(new BorderLayout());

		// Agregar el panel de inicio al centro del JFrame
		add(panelLogin, BorderLayout.CENTER);

		// Título
		setTitle("Login");

		// Tamaño de la ventana
		setBounds(500, 250, 920, 570);
		
		// Centrar la ventana en la pantalla
		setLocationRelativeTo(null);

		// No redimensionable
		setResizable(false);

		// Cerrar proceso al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Mostrar JFrame
		setVisible(true);
	}

	// Método para cambiar al panel de usuario
	public void mostrarPanelUsuario() {
		// Eliminar el panel de inicio
		getContentPane().remove(panelLogin);

		// Agregar el panel de usuario al centro del JFrame
		getContentPane().add(panelUser /*panelAdmin para comprobarlo*/, BorderLayout.CENTER);
		// Volver a pintar el JFrame para que los cambios se reflejen
		revalidate();
		repaint();
	}

	public void mostrarPanelAdmin() {
		// Eliminar el panel de inicio
		getContentPane().remove(panelLogin);

		// Agregar el panel de usuario al centro del JFrame
		getContentPane().add(panelAdmin, BorderLayout.CENTER);
		// Volver a pintar el JFrame para que los cambios se reflejen
		revalidate();
		repaint();		
	}

	// Método principal para probar la clase
	public static void main(String[] args) {
		// Crear una instancia de la clase Principal
		Principal principal = new Principal();
		principal.playBackgroundSound();

	}


	// Método para reproducir el sonido de fondo
	public void playBackgroundSound() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/imagenes/song.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}   
}
