package es.unican.is2.model.states;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import es.unican.is2.model.Despertador;

public class StateSnooze extends StateDespertador{
	private Intervalo intervalo;
	public Timer timer=new Timer();


	@Override
	public void entryAction(Despertador contexto) {
		intervalo=new Intervalo(contexto);
		timer.schedule(intervalo, contexto.getIntervaloInMs());
	}

	@Override
	public void exitAction(Despertador contexto) {
		contexto.resetSnooze();

	}

	@Override
	public void doAction(Despertador contexto) {

	}

	@Override
	public void alarmaOn(Despertador contexto, Time hora) {

	}

	@Override
	public void alarmaOff(Despertador contexto) {

	}

	@Override
	public void buzz(Despertador contexto) {
		contexto.cambiaBuzz();		

	}

	@Override
	public void snooze(Despertador contexto) {
		if(contexto.getNumPulsado()>=3) {
			exitAction(contexto);
			contexto.setState(programado);
			programado.entryAction(contexto);
		}else {
			contexto.pulsarSnooze();
		}
	}
	@Override
	public void stop(Despertador contexto) {
		// TODO Auto-generated method stub
	}
	public class Intervalo extends TimerTask{
		private Despertador contexto;
		public Intervalo(Despertador contexto) {
			this.contexto=contexto;
		}
		public void run(){
			exitAction(contexto);
			contexto.setState(sonando);
			sonando.entryAction(contexto);
		}
	}
}
