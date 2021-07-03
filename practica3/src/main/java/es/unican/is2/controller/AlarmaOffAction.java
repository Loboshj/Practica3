package es.unican.is2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.model.Despertador;
import es.unican.is2.view.InterfazGrafica;

public class AlarmaOffAction extends AbstractAction{
	private InterfazGrafica vista;
	private Despertador despertador;
	public AlarmaOffAction(InterfazGrafica vista,Despertador despertador) {
		putValue(Action.NAME,"Alarma Off");
		this.vista=vista;
		this.despertador=despertador;
	}
	public void actionPerformed(ActionEvent arg0) {
		despertador.alarmaOff();
	}

}
