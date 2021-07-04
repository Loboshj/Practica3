package es.unican.is2.model.states;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import es.unican.is2.model.Despertador;

public class StateSonando extends StateDespertador{

	private Intervalo intervalo;
	public Timer timer=new Timer();


	@Override
	public void entryAction(Despertador contexto) {
		contexto.activarAlarma();
		intervalo=new Intervalo(contexto);
		timer.schedule(intervalo, contexto.getIntervaloAlarmaMs());
	}


	@Override
	public void exitAction(Despertador contexto) {
		contexto.desactivarAlarma();

	}

	@Override
	public void doAction(Despertador contexto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alarmaOn(Despertador contexto, Time hora) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alarmaOff(Despertador contexto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buzz(Despertador contexto) {
		contexto.cambiaBuzz();
	}

	@Override
	public void snooze(Despertador contexto) {
		this.exitAction(contexto);
		contexto.setState(snooze);
		contexto.pulsarSnooze();
		snooze.entryAction(contexto);	
	}

	@Override
	public void stop(Despertador contexto) {
		this.exitAction(contexto);
		contexto.setState(programado);
		programado.entryAction(contexto);
	}
	public class Intervalo extends TimerTask{
		private Despertador contexto;
		public Intervalo(Despertador contexto) {
			this.contexto=contexto;
		}
		public void run(){
			exitAction(contexto);
			contexto.setState(desprogramado);
			desprogramado.entryAction(contexto);
		}
	}

}
