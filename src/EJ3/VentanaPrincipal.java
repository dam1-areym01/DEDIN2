package EJ3;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal {

	JFrame ventana;
	JButton COMPONENTE;
	JLabel imagen;
	
	
	public VentanaPrincipal() {

		ventana = new JFrame();
		ventana.setBounds(100, 100, 600, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {

		ventana.setLayout(null);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("imagenes/bb.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(img.getScaledInstance(img.getWidth()/2, img.getHeight()/2, Image.SCALE_SMOOTH));
		imagen = new JLabel(icon);
		imagen.setBounds(-30, 0, icon.getIconHeight(), icon.getIconWidth());
		ventana.add(imagen);
		
		
		
	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
	}

}
