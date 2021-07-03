package es.unican.is2.model;

import java.sql.Time;

import es.unican.is2.model.states.StateDespertador;

public class Despertador {
	private Time horaProgramada;
	private boolean buzz;
	private int intervaloSnooze;
	private static int INTERVALO_ALARMA=30;
	private int contadorSnooze;
	private StateDespertador estado;
	public Despertador(Time time) {
		this.horaProgramada=time;
		estado=StateDespertador.init(this);
		
	}
	public void activarAlarma() {

	}
	public void desactivarAlarma() {

	}
	
	
}
