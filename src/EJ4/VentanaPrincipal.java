package EJ4;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal {

	JFrame ventana;
	
	JLabel labelImg0;
	JLabel labelImg1;
	JLabel labelImg2;
	JLabel labelImg3;
	
	ImageIcon arrayIcon0;
	ImageIcon arrayIcon1;
	ImageIcon arrayIcon2;
	ImageIcon arrayIcon3;
	
	public VentanaPrincipal() {

		ventana = new JFrame();
		ventana.setBounds(100, 100, 600, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {

		ventana.setLayout(new GridLayout(4, 1));
		
		BufferedImage arrayImg0 = null;
		BufferedImage arrayImg1 = null;
		BufferedImage arrayImg2 = null;
		BufferedImage arrayImg3 = null;		
		try {
			arrayImg0 = ImageIO.read(new File("imagenes/bb.png"));
			arrayImg1 = ImageIO.read(new File("imagenes/dexter.png"));
			arrayImg2 = ImageIO.read(new File("imagenes/house.png"));
			arrayImg3 = ImageIO.read(new File("imagenes/lost.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		arrayIcon0 = new ImageIcon(arrayImg0.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		arrayIcon1 = new ImageIcon(arrayImg1.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		arrayIcon2 = new ImageIcon(arrayImg2.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		arrayIcon3 = new ImageIcon(arrayImg3.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		
		labelImg0 = new JLabel(arrayIcon0);
		labelImg1 = new JLabel(arrayIcon1);
		labelImg2 = new JLabel(arrayIcon2);
		labelImg3 = new JLabel(arrayIcon3);
		
		labelImg0.setBounds(-30, 0, arrayIcon0.getIconHeight(), arrayIcon0.getIconWidth());
		labelImg1.setBounds(-30, 0, arrayIcon1.getIconHeight(), arrayIcon1.getIconWidth());
		labelImg2.setBounds(-30, 0, arrayIcon2.getIconHeight(), arrayIcon2.getIconWidth());
		labelImg3.setBounds(-30, 0, arrayIcon3.getIconHeight(), arrayIcon3.getIconWidth());
		
		ventana.add(labelImg0);
		ventana.add(labelImg1);
		ventana.add(labelImg2);
		ventana.add(labelImg3);
		
		
		
	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
	}

}
