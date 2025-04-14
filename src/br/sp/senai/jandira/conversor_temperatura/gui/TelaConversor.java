package br.sp.senai.jandira.conversor_temperatura.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.UnsupportedTemporalTypeException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.sp.senai.jandira.conversor_temperatura.model.Temperatura;

public class TelaConversor {

	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setSize(500, 450);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor de Temperatura");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);
		
		// Criando os label para o JFrame
		// Celsius
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus Celsius: ");
		labelCelsius.setBounds(50, 10, 300, 25);
		
		textCelsius = new JTextField();
		textCelsius.setBounds(50, 40, 400, 40);
		
		// Resultado
		labelResultado = new JLabel();
		labelResultado.setText("Resultado:");
		labelResultado.setBounds(50, 120, 190, 40);
		
		
		
		// Mensagem de Erro
		labelMensagemErro = new JLabel();
		
		
		
		// Criando botão Kelvin
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(50, 90, 190, 40);
		
		// Criando botão Fahreinheit
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(259, 90, 190, 40);
		
		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(labelResultado);
		
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(buttonFahreinheit);
		
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String celsius = textCelsius.getText();
				
				// Casting
				double celsiusDouble = Double.parseDouble(celsius);
				
				Temperatura kelvin = new Temperatura();
				kelvin.setCelsius(celsiusDouble);
				
				Double kelvinDouble = kelvin.converterParaKelvin();
				
				// Atribuir valor para o labelResultado
				labelResultado.setText(String.valueOf("Resultado: " + kelvinDouble));
				
			}
		});
		
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String celsius = textCelsius.getText();
				
				// Casting
				double celsiusDouble = Double.parseDouble(celsius);
				
				Temperatura fahreinheint = new Temperatura();
				fahreinheint.setCelsius(celsiusDouble);
				
				Double fahreinheintDouble = fahreinheint.converterParaFahrenheit();
				
				// Atribuir valor para labelResultado
				labelResultado.setText(String.valueOf("Resultado: " + fahreinheintDouble));
				
			}
		});
		
		tela.setVisible(true);
	}
}
