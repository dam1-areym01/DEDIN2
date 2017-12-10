package EJ16;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.RepaintManager;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


public class VentanaPrincipal {

	JFrame ventana;
	
	JPanel panelIzq;
	JPanel panelDer;
	
	JButton buttonCuadrado;
	JButton buttonCirculo;
	
	JLabel labelSeparador;
	JLabel labelX;
	JLabel labelY;
	
	JTextField fieldX;
	JTextField fieldY;
	
	JLabel lienzo;
	BufferedImage canvas;
	
	//Constructor, marca el tamaÃ±o y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Inicializa todos los componentes del frame
	public void inicializarComponentes(){
	
		// DEFINO LA VENTANA
		ventana.setLayout(new GridBagLayout());
		
		// IZQUIERDA
		
		panelIzq = new JPanel();
		panelIzq.setLayout(new GridBagLayout());
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.ipadx = 80;
		settings.weighty = 0;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelIzq,settings); 

		buttonCuadrado = new JButton(cargarIcono("Imagenes/rectangulo.gif",0.25f));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.insets = new Insets(0, 0, 20, 0);
		panelIzq.add(buttonCuadrado, settings);
		
		buttonCirculo = new JButton(cargarIcono("Imagenes/circulo.gif",0.25f));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.insets = new Insets(0, 0, 20, 0);
		panelIzq.add(buttonCirculo, settings);
		
		labelSeparador = new JLabel();
		labelSeparador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.fill = GridBagConstraints.HORIZONTAL;
		settings.insets = new Insets(0, 0, 20, 0);
		panelIzq.add(labelSeparador, settings);
		
		labelX = new JLabel("Posición X");
		labelX.setHorizontalAlignment(SwingConstants.LEFT);
		settings.gridx = 0;
		settings.gridy = 3;
		settings.fill = GridBagConstraints.HORIZONTAL;
		settings.insets = new Insets(0, 0, 20, 0);
		panelIzq.add(labelX, settings);
		
		fieldX = new JTextField("0");
		settings.gridx = 0;
		settings.gridy = 4;
		settings.fill = GridBagConstraints.HORIZONTAL;
		settings.insets = new Insets(0, 0, 20, 0);
		panelIzq.add(fieldX, settings);

		labelY = new JLabel("Posición Y");
		labelY.setHorizontalAlignment(SwingConstants.LEFT);
		settings.gridx = 0;
		settings.gridy = 5;
		settings.fill = GridBagConstraints.HORIZONTAL;
		settings.insets = new Insets(0, 0, 20, 0);
		panelIzq.add(labelY, settings);

		fieldY = new JTextField("0");
		settings.gridx = 0;
		settings.gridy = 6;
		settings.fill = GridBagConstraints.HORIZONTAL;
		settings.insets = new Insets(0, 0, 20, 0);
		panelIzq.add(fieldY, settings);
		
		// DERECHA 
		
		panelDer = new JPanel();
		panelDer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelDer.setLayout(new GridLayout(1,1));
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		ventana.add(panelDer,settings);
		
		// DER - LIENZO
		
		lienzo = new JLabel();
		panelDer.add(lienzo);
		canvas = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB );
		lienzo.setIcon(new ImageIcon(canvas));
		
	}
	
	public ImageIcon cargarIcono(String ruta, float relacionTamanio){
		BufferedImage buffAux = null;
		try {
			buffAux = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ImageIcon(buffAux.getScaledInstance(
				(int)(buffAux.getWidth()*relacionTamanio),
				(int)(buffAux.getHeight()*relacionTamanio),
				Image.SCALE_SMOOTH));
	}
	
	public void inicializarListeners(){		

		buttonCuadrado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Graphics graficos = canvas.getGraphics();
				graficos.setColor(Color.BLACK);
				try {
				graficos.fillRect(Integer.parseInt(fieldX.getText()), Integer.parseInt(fieldY.getText()), 90, 90);
				} catch (NumberFormatException eCuadrado) {
					JOptionPane.showMessageDialog(null, "Formato no válido");
					eCuadrado.getMessage();
				}
				graficos.dispose();
				lienzo.repaint();				
			}
		});
		
		buttonCirculo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Graphics graficos = canvas.getGraphics();
				graficos.setColor(Color.MAGENTA);
				try {
					graficos.fillOval(Integer.parseInt(fieldX.getText()), Integer.parseInt(fieldY.getText()), 90, 90);
				} catch (NumberFormatException eCirculo) {
					JOptionPane.showMessageDialog(null, "Formato no válido");
					eCirculo.getMessage();
				}
				graficos.dispose();
				lienzo.repaint();
				
			}
		});
		
	}
	
	
	public void inicializar(){
		//IMPORTANTE, PRIMERO HACEMOS LA VENTANA VISIBLE Y LUEGO INICIALIZAMOS LOS COMPONENTES.
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}
}
