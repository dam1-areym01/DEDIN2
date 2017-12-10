package EJ5;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal {
	JFrame ventana;
	BufferedImage img;
	JLabel label1, label2, label3, label4;
	ImageIcon icon;
	JPanel panelIzq, panelDer;
	
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
			settings.gridheight=1;
			settings.gridwidth=1;
			settings.gridx=0;
			settings.gridy=0;
			settings.weightx=1;
			settings.weighty=1;
			settings.fill = GridBagConstraints.BOTH;
			
			String [] path = {"imagenes/bb.png", "imagenes/lost.png", "imagenes/house.png", "imagenes/dexter.png"};
			
			JLabel [] images = new JLabel[4];
			
			BufferedImage image = null;
			
			for (int i = 0; i < images.length; i++) {
				try{
					image = ImageIO.read(new File(path[i]));

					ImageIcon icon = new ImageIcon(image.getScaledInstance(100, 100, image.SCALE_SMOOTH));
					
					images[i] = new JLabel(icon);
					
					panelIzq.add(images[i]);
				}catch (IOException ex){
					System.out.println("Error: " +ex.getMessage());
				}
				
			}
			
			panelDer = new JPanel();
			panelDer.setBackground(Color.BLUE);
			GridBagConstraints settings2 = new GridBagConstraints();
			settings2.gridheight=1;
			settings2.gridwidth=1;
			settings2.gridx=1;
			settings2.gridy=0;
			settings2.weightx=4;
			settings2.weighty=1;
			settings2.fill = GridBagConstraints.BOTH;
			
			
			ventana.add(panelIzq, settings);
			ventana.add(panelDer, settings2);
	}
	
	

	public void inicializar(){
		inicializarComponentes();
		ventana.setVisible(true);
	}
}