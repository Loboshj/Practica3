package es.unican.is2.controller;

import java.awt.event.ActionEvent;
import java.sql.Time;

import javax.swing.AbstractAction;
import javax.swing.Action;

import es.unican.is2.model.Despertador;
import es.unican.is2.view.InterfazGrafica;

public class AlarmaOnAction extends AbstractAction{
	private InterfazGrafica vista;
	private Despertador despertador;
	public AlarmaOnAction(InterfazGrafica vista,Despertador despertador) {
		putValue(Action.NAME,"Alarma On");
		this.vista=vista;
		this.despertador=despertador;
	}
	public void actionPerformed(ActionEvent e) {
		int hora=vista.getHoras();
		int minuto=vista.getMinutos();
		Time t=new Time(hora,minuto,0);
		despertador.alarmaOn(t);
	}

}
