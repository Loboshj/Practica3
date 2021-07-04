package es.unican.is2.model.states;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import es.unican.is2.model.Despertador;

public class StateProgramado extends StateDespertador{
	private Programacion programacion;
	public Timer timer=new Timer();
	

	@Override
	public void entryAction(Despertador contexto) {
		Calendar c=Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, contexto.getHoraProgramada().getHours());
		c.set(Calendar.MINUTE, contexto.getHoraProgramada().getMinutes());
		c.set(Calendar.SECOND, 0);
		if(c.getTimeInMillis()<System.currentTimeMillis()){
			c.add(Calendar.DATE, 1);
		}
		programacion=new Programacion(contexto);
		Date time=c.getTime();
		timer.schedule(programacion,time);
		contexto.enciendePiloto();
	System.out.println(time);
	}
	

	@Override
	public void exitAction(Despertador contexto) {
		programacion.cancel();
	}

	@Override
	public void doAction(Despertador contexto) {
		
	}

	@Override
	public void alarmaOn(Despertador contexto, Time hora) {
		contexto.cambiaHora(hora);
		programacion.cancel();
		Calendar c=Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, contexto.getHoraProgramada().getHours());
		c.set(Calendar.MINUTE, contexto.getHoraProgramada().getMinutes());
		c.set(Calendar.SECOND, 0);
		if(c.getTimeInMillis()<System.currentTimeMillis()){
			c.add(Calendar.DATE, 1);
		}
		programacion=new Programacion(contexto);
		Date time=c.getTime();
		timer.schedule(programacion,time);
		contexto.enciendePiloto();
	System.out.println(time);
		
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
			System.out.println("alarma");
			exitAction(contexto);
			contexto.setState(sonando);
			sonando.entryAction(contexto);
		}
	}

}
