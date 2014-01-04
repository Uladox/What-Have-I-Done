package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import Engine.Game;
import Engine.GameInheritedClass;






public class GameWindow extends JFrame {
	
	

BufferedImage talk;

	public GameWindow() {
		talk = getImage("/textures/sheets/Start.png");
		
		boolean running = true;
        Game game = new Game("Cuckoo", 200, 300, 135, 193, 64, 20, 135, 195, 256, "/textures/sheets/spritesheet.png", true, "/levels/Forest.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(game.fullname);
       
        add(game);
        //game.setMaximumSize(new Dimension(100, 100));
        pack();
        //setSize(600, 800);
        
        this.setLocationRelativeTo( getRootPane());
        setVisible(true);
        setResizable(false);
        game.start();
       while(running){
        this.setTitle(GameInheritedClass.Title);
        }
       
      // imageloader();
      
    }
	
	public void imageloader(){
	    BufferStrategy bs= this.getBufferStrategy();
	   if(bs==null){
	       this.createBufferStrategy(4);
	       return;
	   }
	  
	   Graphics g= bs.getDrawGraphics();
	   g.drawImage(talk, 100, 100, 697, 327,  null);
	   g.dispose();
	   bs.show();
	   
	 
	}
	

	private BufferedImage getImage(String filename) {
		// This time, you can use an InputStream to load
		try {
			// Grab the InputStream for the image.
			InputStream in = getClass().getResourceAsStream(filename);
			
			// Then read it in.
			return ImageIO.read(in);
		} catch (IOException e) {
			System.out.println("The image was not loaded.");
			System.exit(1);
		}
		return null;
	}
	
	public void close() throws InterruptedException{
	
		this.dispose();
	}
	

	
}