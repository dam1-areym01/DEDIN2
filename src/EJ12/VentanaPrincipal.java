package EJ12;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class VentanaPrincipal {

	// La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;

	// Paneles:
	JPanel panelIzq;
	JPanel panelDer;
	JPanel panelRBotones;

	// Label
	JLabel imagenGrande;

	// Botón de cargar y nuevo
	JButton cargarB = new JButton("Cargar");
	JButton nuevoB = new JButton("Nuevo");

	// Titulo
	TitledBorder titulo;

	// Radio Buttons:
	JRadioButton rbNegro;
	JRadioButton rbAzul;
	JRadioButton rbBlanco;
	JRadioButton rbVerde;

	// Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 900, 700);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Inicializa todos los componentes del frame
	public void inicializarComponentes() {

		// Definimos el layout:
		ventana.setLayout(new GridBagLayout());

		// PANELES
		panelIzq = new JPanel();
		panelIzq.setLayout(new GridLayout(1, 1));
		panelIzq.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30),
				BorderFactory.createLineBorder(Color.BLACK)));
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelIzq, settings);
		
		imagenGrande = new JLabel();
		imagenGrande.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzq.add(imagenGrande);
		
		panelDer = new JPanel();
		panelDer.setLayout(new GridBagLayout());
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.ipadx = 200;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelDer, settings);

		panelRBotones = new JPanel();
		panelRBotones.setLayout(new GridLayout(4, 1, 15, 30));
		panelRBotones.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		titulo = BorderFactory.createTitledBorder("Colores");
		titulo.setTitleJustification(TitledBorder.TOP);
		panelRBotones.setBorder(titulo);

		// Los botones de Cargar y nuevo:
		cargarB = new JButton("Cargar");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		// settings.insets = new Insets(0, 0, 0, 0);
		settings.fill = GridBagConstraints.HORIZONTAL;
		panelDer.add(cargarB, settings);

		nuevoB = new JButton("Nuevo");
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 1;
		// settings.insets = new Insets(0, 0, 0, 0);
		settings.fill = GridBagConstraints.HORIZONTAL;
		panelDer.add(nuevoB, settings);

		// Radio Buttons:
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
		settings.insets = new Insets(70, 10, 0, 10);
		panelDer.add(panelRBotones, settings);

	}

	public void inicializarListeners() {
		
		cargarB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("imagenes/bb.png"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				ImageIcon icon = new ImageIcon(img.getScaledInstance(imagenGrande.getBounds().width, imagenGrande.getBounds().height, 0));
				imagenGrande.setIcon(icon);
				imagenGrande.setBounds(0, 0, icon.getIconHeight(), icon.getIconWidth());

				panelIzq.add(imagenGrande);
				
			}
		});
		
	}

	public void inicializar() {
		// IMPORTANTE, PRIMERO HACEMOS LA VENTANA VISIBLE Y LUEGO INICIALIZAMOS LOS
		// COMPONENTES.
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}
