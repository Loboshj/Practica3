package es.unican.is2.model.states;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import es.unican.is2.model.Despertador;

public class StateProgramado extends StateDespertador{
	private Programacion programacion;
	public Timer timer=new Timer();
	

	@Override
	public void entryAction(Despertador contexto) {
		programacion=new Programacion(contexto);
		timer.schedule(programacion, contexto.getHoraProgramada());
		contexto.enciendePiloto();
	}

	@Override
	public void exitAction(Despertador contexto) {
		
	}

	@Override
	public void doAction(Despertador contexto) {
		
	}

	@Override
	public void alarmaOn(Despertador contexto, Time hora) {
		contexto.cambiaHora(hora);
	}

	@Override
	public void alarmaOff(Despertador contexto) {
		this.exitAction(contexto);
		contexto.setState(desprogramado);
		desprogramado.entryAction(contexto);
	}

	@Override
	public void buzz(Despertador contexto) {
		contexto.cambiaBuzz();
		
	}

	@Override
	public void snooze(Despertador contexto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop(Despertador contexto) {
		// TODO Auto-generated method stub
		
	}
	public class Programacion extends TimerTask{
		private Despertador contexto;
		public Programacion(Despertador contexto) {
			this.contexto=contexto;
		}
		public void run(){
			exitAction(contexto);
			contexto.setState(sonando);
			sonando.entryAction(contexto);
		}
	}

}
