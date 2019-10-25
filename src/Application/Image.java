package Application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image extends JFrame{
	public void setPicture(JLabel label, String filename)
	{
		try {
			BufferedImage image = ImageIO.read(new File(filename));
			
			
			ImageIcon icon = new ImageIcon(image.getScaledInstance(label.getSize().width, label.getSize().height, image.SCALE_SMOOTH));
			label.setIcon(icon);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
