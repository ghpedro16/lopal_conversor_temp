package br.sp.senai.jandira.conversor_temperatura.gui;

import java.awt.Color;
import java.awt.Font;
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
		tela.setSize(400, 400);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor de Temperatura");
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);
		
		// Criando os label para o JFrame
		// Celsius
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius: ");
		labelCelsius.setBounds(40, 8, 200, 25);
		
		textCelsius = new JTextField();
		textCelsius.setBounds(40, 40, 304, 32);
		
		// Resultado
		labelResultado = new JLabel();
		labelResultado.setBounds(132, 120, 288, 80);
		labelResultado.setFont(new Font("Arial", Font.BOLD, 20));
		
		// Mensagem de Erro
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(120, 144, 288, 80);
		labelMensagemErro.setForeground(Color.RED);
		labelMensagemErro.setFont(new Font("Arial", Font.BOLD, 16));
		
		
		// Criando botão Kelvin
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(40, 95, 144, 32);
		
		// Criando botão Fahreinheit
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(200, 95, 144, 32);
		
		
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String celsius = textCelsius.getText();
				
				try {
					
					double celsiusDouble = Double.parseDouble(celsius);
					Temperatura kelvin = new Temperatura();
					
					kelvin.setCelsius(celsiusDouble);
					Double kelvinDouble = kelvin.converterParaKelvin();
					
					String numeroFormatado = String.format("%.1f", kelvinDouble);
					labelResultado.setText(String.valueOf(numeroFormatado + " KELVIN"));
			
				} catch (Exception e2) {
					
					labelMensagemErro.setText("Insira um valor válido!");
				}
				
			}
		});
		
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String celsius = textCelsius.getText();
				
				try {
					
					double celsiusDouble = Double.parseDouble(celsius);
					Temperatura fahreinheint = new Temperatura();
					fahreinheint.setCelsius(celsiusDouble);
					
					Double fahreinheintDouble = fahreinheint.converterParaFahrenheit();
					
					String numeroFormatado = String.format("%.1f", fahreinheintDouble);
					labelResultado.setText(String.valueOf(numeroFormatado + " FAHREINHEIT"));
					
				} catch (Exception e2) {
					
					labelMensagemErro.setText("Insira um valor válido!");
				}
				
				
			}
		});
		
		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(buttonFahreinheit);
		
		tela.setVisible(true);
	}
}
