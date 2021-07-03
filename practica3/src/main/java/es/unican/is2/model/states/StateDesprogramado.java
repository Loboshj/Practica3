package es.unican.is2.model.states;

import java.sql.Time;

import es.unican.is2.model.Despertador;

public class StateDesprogramado extends StateDespertador{

	@Override
	public void entryAction(Despertador contexto) {
		contexto.apagaPiloto();
		
	}

	@Override
	public void exitAction(Despertador contexto) {
		
	}

	@Override
	public void doAction(Despertador contexto) {
		
	}

	@Override
	public void alarmaOn(Despertador contexto, Time hora) {
		this.exitAction(contexto);
		contexto.cambiaHora(hora);
		contexto.setState(programado);
		programado.entryAction(contexto);
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
		
	}

	@Override
	public void stop(Despertador contexto) {
		
	}

}
