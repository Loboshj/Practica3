package es.unican.is2.model;

public class Piloto {
	private boolean encendido;
	
	public Piloto() {
		encendido=false;
	}
	public void enciende() {
		encendido=true;
	}
	public void apaga() {
		encendido=false;
	}

}
