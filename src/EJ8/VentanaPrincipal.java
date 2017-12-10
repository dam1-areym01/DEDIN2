package EJ8;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class VentanaPrincipal {

	//La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	
	//Paneles:
	JPanel panelIzq;
	JPanel panelDer;
	JPanel panelRBotones;
	
	
	//Botón de cargar y nuevo
	JButton cargarB = new JButton("Cargar");
	JButton nuevoB = new JButton("Nuevo");
	
	//Radio Buttons:
	JRadioButton rbNegro;
	JRadioButton rbAzul;
	JRadioButton rbBlanco;
	JRadioButton rbVerde;	
	
	//Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 900, 700);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Inicializa todos los componentes del frame
	public void inicializarComponentes(){
		
		//Definimos el layout:
		ventana.setLayout(new GridBagLayout());
		
		//PANELES
		panelIzq = new JPanel();
		panelIzq.setBackground(Color.YELLOW);
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelIzq,settings);
		
		panelDer = new JPanel();
		panelDer.setLayout(new GridBagLayout());
		panelDer.setBackground(Color.RED);
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.ipadx = 200;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelDer,settings);
		
		
		panelRBotones = new JPanel();
		panelRBotones.setLayout(new GridLayout(4,1,0,30));
		panelRBotones.setBackground(Color.CYAN);
		panelRBotones.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		//Los botones de Cargar y nuevo:
		cargarB = new JButton("Cargar");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.insets = new Insets(0, 0, 0, 10);
		settings.fill = GridBagConstraints.BOTH;
		panelDer.add(cargarB,settings);
		
		nuevoB = new JButton("Nuevo");
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.insets = new Insets(0, 10, 0, 0);
		settings.fill = GridBagConstraints.BOTH;
		panelDer.add(nuevoB,settings);
		
		
		//Radio Buttons:
		ButtonGroup grupo = new ButtonGroup();
		rbNegro = new JRadioButton("Negro");
		rbAzul = new JRadioButton("Azul");
		rbBlanco = new JRadioButton("Blanco");
		rbVerde = new JRadioButton("Verde");
		grupo.add(rbNegro);
		grupo.add(rbAzul);
		grupo.add(rbBlanco);
		grupo.add(rbVerde);
		panelRBotones.add(rbNegro);
		panelRBotones.add(rbAzul);
		panelRBotones.add(rbBlanco);
		panelRBotones.add(rbVerde);
		
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.gridwidth = 2;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.HORIZONTAL;
		settings. insets = new Insets(70, 10, 0, 10);
		panelDer.add(panelRBotones,settings);
		
	}
	
	public void inicializarListeners(){
	}
	
	public void inicializar(){
		//IMPORTANTE, PRIMERO HACEMOS LA VENTANA VISIBLE Y LUEGO INICIALIZAMOS LOS COMPONENTES.
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}
}
