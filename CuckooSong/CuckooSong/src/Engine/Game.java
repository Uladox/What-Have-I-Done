package Engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;






public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public  boolean follow = false;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static int Shiftedx = 0;
	public static int Shiftedy = 0;
	static BufferedImage img;
	private Thread thread;
	private Keyboard key;
	private Level level;
	private Player player;

	public  String fullname = "";
	private boolean running = false;
	
	

	private Screen screen;
	public int xOrientation = 0;
	//= player.x - screen.width / 2;
	public int yOrientation = 0;
	//= player.y - screen.height / 2;
	//public BufferedImage talk;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private String title;

	public Game(String Title, int Width, int Height, int Orientx, int Orienty, int Shiftx, int Shifty, 
			int Startx, int Starty, int SpriteSheetSize, String SpriteSheetPath,  boolean DoesFollow, String LevelPath) {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		GameInheritedClass.LevelPath(LevelPath);
		GameInheritedClass.PlayerPath(SpriteSheetPath);
		GameInheritedClass.PlayerSize(SpriteSheetSize);
		Shiftedx = Shiftx;
		Shiftedy = Shifty;
		follow = DoesFollow;
		title = Title;
		xOrientation = Orientx *16;
		yOrientation = Orienty *16;
		width = Width;
		height = Height;
		screen = new Screen(width, height);
		key = new Keyboard();
		level = Level.spawn;
		TileCoordinate playerSpawn = new TileCoordinate(Startx,Starty);
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		
		player.init(level);
		
		addKeyListener(key);
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		
		
		//talk = getImage("/textures/sheets/Start.png");
	}
	

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;

		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			// one second || 1000 ns = 1 sec
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println(updates + " ups, " + frames + " fps");
				GameInheritedClass.UpdatedTitle(title + "  | " + updates + " ups, " + frames + " fps") ;
				//nameUpdater(lostname);
				frames = 0;
				updates = 0;
			}
		}
		stop();
		
	}
	
//public String nameUpdater(String lostname){
	///fullname = lostname;
	//return fullname;
	
//}
	
	public void update() {
		key.update();
		
		player.update();
		
		
		

	}
	

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		

		screen.clear();

		int xScroll = xOrientation;
		int yScroll = yOrientation;
		if(follow == false){
		 xScroll = xOrientation;
		 yScroll = yOrientation;
		}else if(follow == true){
			 xScroll = player.x - width/2 + Shiftedx;
			 yScroll = player.y - height/2 + Shiftedy;
		}
		
			level.render(xScroll, yScroll, screen);
			player.render(screen);
			level.renderTree(xScroll, yScroll, screen);
			
			

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 50));
		
		//g.fillRect(Mouse.getX(), Mouse.getY(), 64, 64);
       // g.drawString("" + Mouse.getB(), 80, 80);
        //g.drawString("X:   Y: ", 450, 400);
		
       // g.drawImage(talk, 1, 100, 500, 100, null);
        
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
}
