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
	private Piloto piloto;
	private int numPulsado;
	public Despertador(Time time) {
		this.horaProgramada=time;
		estado=StateDespertador.init(this);
		piloto=new Piloto();
		numPulsado=0;
		
	}
	public void pulsarSnooze() {
		numPulsado++;
	}
	public void resetSnooze() {
		numPulsado=0;
	}
	public int getNumPulsado() {
		return numPulsado;
	}
	public void activarAlarma() {

	}
	public void desactivarAlarma() {

	}
	public void enciendePiloto() {
		piloto.enciende();
	}
	public void apagaPiloto() {
		piloto.apaga();
	}
	public void setState(StateDespertador state) {
		estado=state;
	}
	public void cambiaHora(Time hora) {
		horaProgramada=hora;
	}
	public void cambiaBuzz() {
		buzz=!buzz;
	}
	public Time getHoraProgramada() {
		return horaProgramada;
	}
	public void anhadeIntervalo() {
		intervaloSnooze+=5;
	}
	public void setIntervalo(int intervalo) {
		intervaloSnooze=intervalo;
	}
	public int getIntervalo() {
		return intervaloSnooze;
	}
	public long getIntervaloInMs() {
		return intervaloSnooze*60*1000;
	}
	public int getIntervaloAlarma() {
		return INTERVALO_ALARMA;
	}
	public int getIntervaloAlarmaMs() {
		return INTERVALO_ALARMA*60*1000;
	}
}
