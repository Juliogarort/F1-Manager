package codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class JPanel_User extends JPanel {
	ConexionUsuario conexionUsuario = new ConexionUsuario();
	private JTable tablepilotos;

	public JPanel_User() {
		
		setLayout(null); // Usar un layout absoluto

		JButton circuito = new JButton("");
		circuito.setBounds(351, 379, 210, 57);
		circuito.setContentAreaFilled(false); // Hacer que el área de contenido no esté rellena (fondo transparente)
		circuito.setBorderPainted(false); // Eliminar el borde
		add(circuito);
		
		circuito.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Realizar la acción existente
		        	mostrarPistas();
		            DialogoPista DialogoPista = new DialogoPista();

		            DialogoPista.setVisible(true);


		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            // Manejar la excepción si ocurre
		        }
		    }
		});
		
		


		// ------------------------------------------------------------------------------------
		// Cargar la imagen para el JButton
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imagenes/circuito.png")); // Modifica la ruta según corresponda
		// Escalar la imagen al tamaño del JButton
		Image image = imageIcon.getImage().getScaledInstance(circuito.getWidth(), circuito.getHeight(), Image.SCALE_SMOOTH);
		// Crear un nuevo ImageIcon con la imagen escalada
		ImageIcon scaledImageIcon = new ImageIcon(image);
		// Establecer el ImageIcon en el JButton
		circuito.setIcon(scaledImageIcon);
		// -----------------------------------------------------------------------------------------

		JButton botoncoche = new JButton();
		botoncoche.setBounds(140, 359, 140, 85);
		botoncoche.setContentAreaFilled(false); // Hacer que el área de contenido no esté rellena (fondo transparente)
		botoncoche.setBorderPainted(false); // Eliminar el borde
		add(botoncoche);
		// Cargar la imagen para el JButton
		ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/imagenes/coche.png")); // Modifica la ruta según corresponda
		// Escalar la imagen al tamaño del JButton
		Image image1 = imageIcon1.getImage().getScaledInstance(botoncoche.getWidth(), botoncoche.getHeight(), Image.SCALE_SMOOTH);
		// Crear un nuevo ImageIcon con la imagen escalada
		ImageIcon scaledImageIcon1 = new ImageIcon(image1);
		// Establecer el ImageIcon en el JButton
		botoncoche.setIcon(scaledImageIcon1);


		botoncoche.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Realizar la acción existente
		        	mostrarCoches();
		            DialogoCoche DialogoCoche = new DialogoCoche();

		            DialogoCoche.setVisible(true);


		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            // Manejar la excepción si ocurre
		        }
		    }
		});
		
		// ----------------------------------------------------------------------------------------------------------------------------
		JButton piloto = new JButton(""); // Crear el botón piloto
		piloto.setBounds(614, 347, 105, 89);
		piloto.setContentAreaFilled(false); // Hacer que el área de contenido no esté rellena (fondo transparente)
		piloto.setBorderPainted(false); // Eliminar el borde
		add(piloto);


		// Cargar la imagen para el JButton
		ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/imagenes/piloto.png")); // Modifica la ruta según corresponda
		// Escalar la imagen al tamaño del JButton
		Image image2 = imageIcon2.getImage().getScaledInstance(piloto.getWidth(), piloto.getHeight(), Image.SCALE_SMOOTH);
		// Crear un nuevo ImageIcon con la imagen escalada
		ImageIcon scaledImageIcon2 = new ImageIcon(image2);
		// Establecer el ImageIcon en el JButton
		piloto.setIcon(scaledImageIcon2);
	

		 // Llamar al método para obtener datos de pilotos cuando se hace clic en el botón piloto
		piloto.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Realizar la acción existente
		        	mostrarPilotos();
		        	DialogoPiloto DialogoPiloto = new DialogoPiloto();

		        	DialogoPiloto.setVisible(true);


		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            // Manejar la excepción si ocurre
		        }
		    }
		});
    }


	 private void mostrarPilotos() throws SQLException { /* crear lo mismo a este pero para los metodos de coches y circuitos*/ 
	        conexionUsuario.getDataPilotos();
	    }
	 
	 private void mostrarCoches() throws SQLException { /* crear lo mismo a este pero para los metodos de coches y circuitos*/ 
	        conexionUsuario.getDataCoches();
	    }
	 private void mostrarPistas() throws SQLException { /* crear lo mismo a este pero para los metodos de coches y circuitos*/ 
	        conexionUsuario.getDataPistas();
	    }



	@Override
	public void paintComponent(Graphics g) {
		Dimension dimension = this.getSize();
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/F1_User.png"));
		g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}