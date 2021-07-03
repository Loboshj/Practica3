package es.unican.is2.model.states;

import java.sql.Time;

import es.unican.is2.model.Despertador;

public abstract class StateDespertador {

	public static StateDespertador init(Despertador contexto) {
		return null; //TODO
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
