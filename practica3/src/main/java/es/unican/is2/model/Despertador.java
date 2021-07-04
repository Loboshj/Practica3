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
		piloto=new Piloto();
		estado=StateDespertador.init(this);
		numPulsado=0;	
		intervaloSnooze=5;
	}
	public void alarmaOff() {
		estado.alarmaOff(this);
	}
	public void alarmaOn(Time hora) {
		estado.alarmaOn(this, hora);	
	}
	public void buzz() {
		estado.buzz(this);
	}
	public void snooze() {
		estado.snooze(this);
	}
	public void stop() {
		estado.stop(this);
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
		if(buzz) {
			System.out.println("Está sonando el pitido");
		}else {
			System.out.println("Está sonando la radio");
		}
	}
	public void desactivarAlarma() {
		System.out.println("Se ha apagado la alarma");
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
		System.out.println(intervalo);
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
