package EJ6;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal {
	JFrame ventana;
	BufferedImage img;
	ImageIcon icon;
	JPanel panelIzq, panelDer;

	String[] path = { "imagenes/bb.png", "imagenes/lost.png", "imagenes/house.png", "imagenes/dexter.png" };

	BufferedImage image = null;

	JLabel[] images = new JLabel[4];

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 400, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {

		ventana.setLayout(new GridBagLayout());

		panelIzq = new JPanel();
		panelIzq.setLayout(new GridLayout(4, 1));
		panelIzq.setBackground(Color.GREEN);
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridheight = 1;
		settings.gridwidth = 1;
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;

		for (int i = 0; i < images.length; i++) {
			try {
				image = ImageIO.read(new File(path[i]));

				ImageIcon icon = new ImageIcon(image.getScaledInstance(100, 100, image.SCALE_SMOOTH));

				images[i] = new JLabel(icon);

				panelIzq.add(images[i]);
			} catch (IOException ex) {
				System.out.println("Error: " + ex.getMessage());
			}

		}

		panelDer = new JPanel();
		panelDer.setBackground(Color.BLUE);
		GridBagConstraints settings2 = new GridBagConstraints();
		settings2.gridheight = 1;
		settings2.gridwidth = 1;
		settings2.gridx = 1;
		settings2.gridy = 0;
		settings2.weightx = 4;
		settings2.weighty = 1;
		settings2.fill = GridBagConstraints.BOTH;

		ventana.add(panelIzq, settings);
		ventana.add(panelDer, settings2);
	}

	public void inicializarListeners() {

		for (int i = 0; i < images.length; i++) {
			int auxI = i;
			images[i].addMouseListener(new MouseListener() {
				

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					try {
						image = ImageIO.read(new File(path[auxI]));

						ImageIcon icon = new ImageIcon(image.getScaledInstance(100, 100, image.SCALE_SMOOTH));

						images[auxI] = new JLabel(icon);

						panelIzq.add(images[auxI]);
					} catch (IOException ex) {
						System.out.println("Error: " + ex.getMessage());
					}

				}
			});

		}

	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();

	}
}