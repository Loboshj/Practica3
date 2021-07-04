package es.unican.is2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.model.Despertador;
import es.unican.is2.view.InterfazGrafica;

public class SnoozeController extends AbstractAction{
	private InterfazGrafica vista;
	private Despertador despertador;
	public SnoozeController(InterfazGrafica vista,Despertador despertador) {
		putValue(Action.NAME,"Snooze");
		this.vista=vista;
		this.despertador=despertador;
	}
	public void actionPerformed(ActionEvent e) {
		despertador.setIntervalo(vista.getSnooze());
	}

}
