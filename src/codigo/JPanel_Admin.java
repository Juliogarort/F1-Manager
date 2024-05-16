package codigo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JPanel_Admin extends JPanel {

	ConexionUsuario conexionUsuario = new ConexionUsuario();
	
	public JPanel_Admin() {
		
        setLayout(null);
        
        JButton btnCrearTabla = new JButton("<html><div style='text-align: center;'>Crear<br>Registro</div></html>");
        btnCrearTabla.setBackground(new Color(130, 140, 153));
        btnCrearTabla.setBounds(190, 390, 140, 80);
        add(btnCrearTabla);
        
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
        JButton btnModificarTabla = new JButton("<html><div style='text-align: center;'>Modificar<br>Tabla</div></html>");
        btnModificarTabla.setBackground(new Color(130, 140, 153));
        btnModificarTabla.setBounds(394, 390, 140, 80);
        add(btnModificarTabla);
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
        JButton btnEliminarTabla = new JButton("<html><div style='text-align: center;'>Eliminar<br>Tabla</div></html>");
        btnEliminarTabla.setBackground(new Color(130, 140, 153));
        btnEliminarTabla.setBounds(614, 390, 140, 80);
        add(btnEliminarTabla);
        
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
	@Override
	public void paintComponent(Graphics g) {
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/F1_Admin.png"));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
	
	
	 private void updateData() throws SQLException { /* crear lo mismo a este pero para los metodos de coches y circuitos*/ 
	        conexionUsuario.updateData();
	    }
	
	 private void deleteData() throws SQLException { /* crear lo mismo a este pero para los metodos de coches y circuitos*/ 
        conexionUsuario.deleteData();
    }
	
	 private void insertData() throws SQLException { /* crear lo mismo a este pero para los metodos de coches y circuitos*/ 
	        conexionUsuario.insertData();
	    }
}
