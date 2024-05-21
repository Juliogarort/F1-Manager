package codigo;

public class Piloto {

	// Atributos
	private String nombre;
	
	private String nacionalidad;
	
	private String fecha_nacimiento;
	
	//Constructor
	public Piloto(String nombre, String nacionalidad, String fecha_nacimiento) {
		
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	@Override
	public String toString() {
		return "Piloto [nombre = " + nombre + ", nacionalidad = " + nacionalidad + ", fecha_nacimiento = " + fecha_nacimiento + "]";
	}
	
}
