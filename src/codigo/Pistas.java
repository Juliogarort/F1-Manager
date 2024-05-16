package codigo;

public class Pistas {

	private String nombre;
	
	private String pais;
	
	private float longitud_km;
	
	private String record_vuelta;
	
	public Pistas(String nombre, String pais, float longitud_km, String record_vuelta) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.longitud_km = longitud_km;
		this.record_vuelta = record_vuelta;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public float getLongitud_km() {
		return longitud_km;
	}

	public void setLongitud_km(float longitud_km) {
		this.longitud_km = longitud_km;
	}

	public String getRecord_vuelta() {
		return record_vuelta;
	}

	public void setRecord_vuelta(String record_vuelta) {
		this.record_vuelta = record_vuelta;
	}

	
	@Override
	public String toString() {
		return "Circuito [nombre = " + nombre + ", pais = " + pais + ", longitud_km = " + longitud_km + ", record_vuelta = " + record_vuelta + "]";
	}
	
}