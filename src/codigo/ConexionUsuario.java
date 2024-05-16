package codigo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexionUsuario {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	//direcci�n de la BBDD MySQL
	private static final String URL = "jdbc:mysql://localhost:3307/f1_manager"; /*cambiar el pueruto a 3306 en otros ordenadores */
	//usuario y contrase�a de acceso a la BD
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	public Connection conectar() {
		Connection conexion = null;

		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			System.out.println("Conexi�n OK");

		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error en la conexi�n");
			e.printStackTrace();
		}

		return conexion;
	}


	public List<Piloto> getDataPilotos() throws SQLException {
	    List<Piloto> listaPilotos = new ArrayList<>();
	    Connection conexion = conectar();

	    if (conexion != null) {
	        try {
	            // Datos a consultar
	            String consultaSeleccion = "SELECT * FROM Pilotos";
	            System.out.println("Consulta SQL: " + consultaSeleccion);

	            Statement consul = conexion.createStatement();
	            // Ejecución de la consulta
	            ResultSet resultSet = consul.executeQuery(consultaSeleccion);

	            // Iterar sobre los resultados y agregarlos a la lista
	            while (resultSet.next()) {
	                // Crear objeto Piloto
	                Piloto piloto = new Piloto(resultSet.getString("nombre"), resultSet.getString("nacionalidad"),
	                        resultSet.getString("fecha_nacimiento"));

	                // Agregar el objeto a la lista
	                listaPilotos.add(piloto);

	                System.out.println("Piloto añadido a la lista: " + piloto.toString());
	            }

	            System.out.println("Datos de Pilotos obtenidos correctamente");

	            // Cierre del ResultSet y Statement
	            resultSet.close();
	            consul.close();

	        } finally {
	            // Cierre de la conexión
	            cerrarConexion(conexion);
	        }
	    }
	    return listaPilotos;
	}
	
	public List<Coche> getDataCoches() throws SQLException {
	    List<Coche> listaCoches = new ArrayList<>();
	    Connection conexion = conectar();

	    if (conexion != null) {
	        try {
	            // Datos a consultar
	            String consultaSeleccion = "SELECT * FROM Coches";
	            System.out.println("Consulta SQL: " + consultaSeleccion);

	            Statement consul = conexion.createStatement();
	            // Ejecución de la consulta
	            ResultSet resultSet = consul.executeQuery(consultaSeleccion);

	            // Iterar sobre los resultados y agregarlos a la lista
	            while (resultSet.next()) {
	                // Crear objeto Coche
	                Coche coche = new Coche(resultSet.getString("modelo"), resultSet.getString("fabricante"),
	                        resultSet.getInt("año_fabricacion"));

	                // Agregar el objeto a la lista
	                listaCoches.add(coche);

	                System.out.println("Coche añadido a la lista: " + coche.toString());
	            }

	            System.out.println("Datos de Coches obtenidos correctamente");

	            // Cierre del ResultSet y Statement
	            resultSet.close();
	            consul.close();

	        } finally {
	            // Cierre de la conexión
	            cerrarConexion(conexion);
	        }
	    }
	    return listaCoches;
	}

	
	public List<Pistas> getDataPistas() throws SQLException {
	    List<Pistas> listaPistas = new ArrayList<>();
	    Connection conexion = conectar();

	    if (conexion != null) {
	        try {
	            // Datos a consultar
	            String consultaSeleccion = "SELECT * FROM Pistas";
	            System.out.println("Consulta SQL: " + consultaSeleccion);

	            Statement consul = conexion.createStatement();
	            // Ejecución de la consulta
	            ResultSet resultSet = consul.executeQuery(consultaSeleccion);

	            // Iterar sobre los resultados y agregarlos a la lista
	            while (resultSet.next()) {
	                // Crear objeto Pistas
	                Pistas pista = new Pistas(resultSet.getString("nombre"), resultSet.getString("pais"),
	                        resultSet.getFloat("longitud_km"), resultSet.getString("record_vuelta"));

	                // Agregar el objeto a la lista
	                listaPistas.add(pista);

	                System.out.println("Pista añadida a la lista: " + pista.toString());
	            }

	            System.out.println("Datos de Pistas obtenidos correctamente");

	            // Cierre del ResultSet y Statement
	            resultSet.close();
	            consul.close();

	        } finally {
	            // Cierre de la conexión
	            cerrarConexion(conexion);
	        }
	    }
	    return listaPistas;
	}

	
	public void insertData() throws SQLException{
        Connection conexion = conectar();
        
        try {
            
        //Datos a insertar
            String consultasInserccion = "INSERT INTO Escuderias (nombre, jefe_de_equipo, sede) VALUES('Andretti F1 Team', 'Mario Andretti', 'Indianápolis, EE.UU.');";

            System.out.println(consultasInserccion);
        //Creación del Statement para poder reqalizar la consulta
            Statement consul = conexion.createStatement();
        //Ejecución de la consulta
            consul.executeUpdate(consultasInserccion);
            System.out.println("Datos insertados correctamente");
        //Cierre del Statement
            consul.close();
            }finally {
                //Cierre de la conexión
                cerrarConexion(conexion);
            }
    }
	
	public void deleteData() throws SQLException {
	    Connection conexion = conectar();
	    
	    try {
	        // Datos a eliminar
	        String consultaEliminacion = "DELETE FROM Escuderias WHERE nombre = 'Andretti F1 Team';";
	        System.out.println(consultaEliminacion);
	        
	        // Creación del PreparedStatement para poder realizar la consulta
	        PreparedStatement statement = conexion.prepareStatement(consultaEliminacion);
	        
	        // Ejecución de la consulta
	        statement.executeUpdate();
	        System.out.println("Datos eliminados correctamente");
	        
	    } finally {
	        // Cierre del PreparedStatement y la conexión
	        
	        cerrarConexion(conexion);
	    }
	}


    public void updateData() throws SQLException {
        Connection conexion = conectar();
        
        try {
            // Consulta de actualización
            String consultaActualizacion = "UPDATE Pilotos SET nombre = 'Esteban Bocon', nacionalidad = 'Gabacho', fecha_nacimiento = '1996-09-17' WHERE nombre = 'Esteban Ocon';";
            System.out.println(consultaActualizacion);
            
            // Creación del PreparedStatement para poder realizar la consulta
            PreparedStatement statement = conexion.prepareStatement(consultaActualizacion);
            
            // Ejecución de la consulta
            int filasActualizadas = statement.executeUpdate();
            System.out.println("Se han actualizado fila(s) correctamente.");
            
        } finally {
            // Cierre del PreparedStatement y la conexión

            cerrarConexion(conexion);
        }
    }
    
    
	

	public void addUser(String name, String email) throws SQLException {
        Connection conexion = conectar();
        Statement statement = conexion.createStatement();
        String sql = "INSERT INTO Users (nombre, contrasena) VALUES ('" + name + "', '" + email + "')";
        statement.executeUpdate(sql);
        statement.close();
    }
	
	public void cerrarConexion(Connection conection){
		try {
			//Cierre de la conexión
			conection.close();
		} catch (SQLException e) {
			System.err.println("Se ha producido un error al cerrar la conexión");

		}
	}
}