package es.unican.is2.model.states;

import java.sql.Time;

import es.unican.is2.model.Despertador;

public abstract class StateDespertador {
	
	protected static StateDesprogramado desprogramado=new StateDesprogramado();
	protected static StateProgramado programado=new StateProgramado();
	protected static StateSnooze snooze=new StateSnooze();
	protected static StateSonando sonando=new StateSonando();
	
	public static StateDespertador init(Despertador contexto) {
		desprogramado.entryAction(contexto);
		return desprogramado;
		
	}
	
	public abstract void entryAction(Despertador contexto);
	public abstract void exitAction(Despertador contexto);
	public abstract void doAction(Despertador contexto);
	public abstract void alarmaOn(Despertador contexto,Time hora);
	public abstract void alarmaOff(Despertador contexto);
	public abstract void buzz(Despertador contexto);
	public abstract void snooze(Despertador contexto);
	public abstract void stop(Despertador contexto);
	
	
}
