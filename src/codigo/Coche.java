package codigo;

public class Coche {

	private String modelo;
	
	private String fabricante;
	
	private int año_fabricacion;
	
	
	public Coche(String modelo, String fabricante, int año_fabricacion) {
		
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.año_fabricacion = año_fabricacion;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAño_fabricacion() {
		return año_fabricacion;
	}

	public void setAño_fabricacion(int año_fabricacion) {
		this.año_fabricacion = año_fabricacion;
	}

	@Override
	public String toString() {
		return "Coche [modelo = " + modelo + ", fabricante = " + fabricante + ", año_fabricacion = " + año_fabricacion + "]";
	}
	
}

