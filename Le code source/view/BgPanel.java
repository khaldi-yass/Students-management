package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 
 *<strong>Description</strong><br>
 * 
 * BgPanel est la classe qui génère la des JPanels avec des arrieres-plans<br>
 * 
 * @author yassir
 * 
 */
public class BgPanel extends JPanel{
	
	private static final long serialVersionUID = 4203651329581961594L;
	
	
	private BufferedImage image;

    public BgPanel() {
       try {                
          image = ImageIO.read(new File("images/background.jpg"));
       } catch (IOException e) {
            e.printStackTrace();
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);           
    }

}