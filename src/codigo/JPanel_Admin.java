package codigo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JPanel_Admin extends JPanel {

	// Instancia de ConexionUsuario para interactuar con la base de datos
	ConexionUsuario conexionUsuario = new ConexionUsuario();
	
	public JPanel_Admin() {
		
		 // Establece el layout como null para usar coordenadas absolutas
        setLayout(null);
        
        // Botón para crear un registro
        JButton btnCrearTabla = new JButton("<html><div style='text-align: center;'>Crear<br>Registro</div></html>");
        btnCrearTabla.setBackground(new Color(130, 140, 153)); // Color de fondo del botón
        btnCrearTabla.setBounds(190, 390, 140, 80); // Posición y tamaño del botón
        add(btnCrearTabla); // Añadir el botón al panel
        
        // Escuchador para el boton de crear tabla
        btnCrearTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Llamar al método para insertar datos
                    insertData();
                    
                    // Mostrar un mensaje de éxito en un JDialog
                    JOptionPane.showMessageDialog(null, "Los datos se han insertado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción si ocurre
                }
            }
        });
        
        // ----------------------------------------------------------------------
        // Botón para modificar la tabla
        JButton btnModificarTabla = new JButton("<html><div style='text-align: center;'>Modificar<br>Tabla</div></html>");
        btnModificarTabla.setBackground(new Color(130, 140, 153)); // Color de fondo del botón
        btnModificarTabla.setBounds(394, 390, 140, 80); // Posición y tamaño del botón
        add(btnModificarTabla); // Añadir el botón al panel
        
        // Escuchador para el boton de modificar tabla
        btnModificarTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	updateData();
                	// Mostrar un mensaje de éxito en un JDialog
                    JOptionPane.showMessageDialog(null, "Los datos se han modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción si ocurre
                }
            }
        });

        
        // ----------------------------------------------------------------------
        // Botón para eliminar la tabla
        JButton btnEliminarTabla = new JButton("<html><div style='text-align: center;'>Eliminar<br>Tabla</div></html>");
        btnEliminarTabla.setBackground(new Color(130, 140, 153)); // Color de fondo del botón
        btnEliminarTabla.setBounds(614, 390, 140, 80); // Posición y tamaño del botón
        add(btnEliminarTabla); // Añadir el botón al panel
        
        // Escuchador para el boton de eliminar tabla
        btnEliminarTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	deleteData();
                	// Mostrar un mensaje de éxito en un JDialog
                    JOptionPane.showMessageDialog(null, "Los datos se han eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción si ocurre
                }
            }
        });
        // ----------------------------------------------------------------------
	}
	// Método para pintar el fondo del panel
	@Override
	public void paintComponent(Graphics g) {
        Dimension dimension = this.getSize(); // Obtener el tamaño del panel
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/F1_Admin.png")); // Cargar la imagen de fondo
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null); // Dibujar la imagen en el panel
        setOpaque(false); // Hacer el panel transparente
        super.paintComponent(g); // Llamar al método de la superclase
    }
	
    // Método para actualizar datos, actualmente solo llama al método updateData de ConexionUsuario
	 private void updateData() throws SQLException {
	        conexionUsuario.updateData();
	    }
	 
	 // Método para eliminar datos, actualmente solo llama al método deleteData de ConexionUsuario
	 private void deleteData() throws SQLException { 
        conexionUsuario.deleteData();
    }
	 
	 // Método para insertar datos, actualmente solo llama al método insertData de ConexionUsuario
	 private void insertData() throws SQLException { 
	        conexionUsuario.insertData();
	    }
}
