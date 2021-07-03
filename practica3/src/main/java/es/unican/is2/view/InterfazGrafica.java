package es.unican.is2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InterfazGrafica extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazGrafica frame = new InterfazGrafica();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public InterfazGrafica() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnAlarmaOn = new JButton("Alarma On");
        btnAlarmaOn.setBounds(61, 38, 103, 49);
        contentPane.add(btnAlarmaOn);
        
        JButton btnAlarmaOff = new JButton("Alarma off");
        btnAlarmaOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnAlarmaOff.setBounds(61, 162, 103, 49);
        contentPane.add(btnAlarmaOff);
        
        JLabel lblHora = new JLabel("Hora");
        lblHora.setBounds(61, 98, 46, 14);
        contentPane.add(lblHora);
        
        JLabel lblMinutos = new JLabel("Minutos");
        lblMinutos.setBounds(118, 98, 46, 14);
        contentPane.add(lblMinutos);
        
        JComboBox selHoras = new JComboBox();
        String[] horas = new String[24];
        for(int i = 0; i<24; i++) {
            horas[i] = String.valueOf(i);
        }
        selHoras.setModel(new DefaultComboBoxModel(horas));
        selHoras.setBounds(61, 117, 46, 20);
        contentPane.add(selHoras);
        
        JComboBox selMinutos = new JComboBox();
        String[] minutos = new String[60];
        for(int i = 0; i<60; i++) {
            minutos[i] = String.valueOf(i);
        }
        selMinutos.setBounds(118, 117, 46, 20);
        contentPane.add(selMinutos);
        
        JButton btnSnooze = new JButton("Snooze");
        btnSnooze.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        selMinutos.setModel(new DefaultComboBoxModel(minutos));

        btnSnooze.setBounds(210, 38, 118, 49);
        contentPane.add(btnSnooze);
        
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnStop.setBounds(210, 103, 118, 49);
        contentPane.add(btnStop);
        
        JButton btnBuzz = new JButton("Buzz");
        btnBuzz.setBounds(210, 162, 118, 49);
        contentPane.add(btnBuzz);
        
        JLabel lblTiempoSnooze = new JLabel("Tiempo Snooze");
        lblTiempoSnooze.setBounds(343, 27, 81, 14);
        contentPane.add(lblTiempoSnooze);
        
        JComboBox selInterSnooze = new JComboBox();
        selInterSnooze.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15"}));
        selInterSnooze.setBounds(338, 45, 57, 35);
        contentPane.add(selInterSnooze);
        
        JPanel piloto = new JPanel();
        piloto.setBounds(343, 103, 34, 34);
        contentPane.add(piloto);
    }
}