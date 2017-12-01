import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Screen extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;

	public Thread thread = new Thread(this);
	
	public int mob;

	
	public static Image[] tileset_ground = new Image[100];
	public static Image[] tileset_air = new Image[100]; 
	public static Image[] tileset_res = new Image[100];
	public static Image[] tileset_mob = new Image[100];
	public static Image[] tileset_menu = new Image[100];
	
	public static int myWidth, myHeight;
	public static int coinage = 0, health = 100;
	public static int killed = 0, killsToWin = 0, level = 1, maxLevel = 12;
	public static int winTime = 4000, winFrame = 0;
	
	public static boolean isFirst = true;
	public static boolean isDebug = false;
	public static boolean isWin = false;
	public static boolean isPause = false;
	
	public static Point mse = new Point(0,0);
	
	public static Room room;
	public static Save save;
	public static Store store;
	
	public static Mob[] mobs = new Mob[100];
	
	public Screen(Frame frame) {
		frame.addMouseListener(new KeyHandel());
		frame.addMouseMotionListener(new KeyHandel());
		frame.addKeyListener(new KeyHandel());
		
		
		
		thread.start();
	}
	
	public static void hasWon() {
		if(killed == killsToWin) {
			isWin = true;
			killed = 0;
		}
	}
	
	public void define() {
		room = new Room();
		save = new Save();
		store = new Store();

		if(level == 1){
		coinage += 40;
		}
		
		if(level == 2){
		coinage += 20;
		}
		
		if(level > 2){
			coinage += 10;
		}
		
		for(int i=0;i<tileset_ground.length;i++){
			tileset_ground[i] = new ImageIcon("res/tileset_ground.png").getImage();
			tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
		}
		
		for(int i=0;i<tileset_air.length;i++){
			tileset_air[i] = new ImageIcon("res/tileset_air.png").getImage();
			tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
		}
		
		tileset_res[0] = new ImageIcon("res/cell.png").getImage();
		tileset_res[1] = new ImageIcon("res/coin.png").getImage();
		tileset_res[2] = new ImageIcon("res/heart.png").getImage();
		
		tileset_mob[0] = new ImageIcon("res/mob.png").getImage();
		tileset_mob[1] = new ImageIcon("res/mob2.png").getImage();
		tileset_mob[2] = new ImageIcon("res/mob3.png").getImage();
		
		tileset_menu[0] = new ImageIcon("res/lost.jpg").getImage();
		tileset_menu[1] = new ImageIcon("res/won.jpg").getImage();
		tileset_menu[2] = new ImageIcon("res/loading.jpg").getImage();
		tileset_menu[3] = new ImageIcon("res/1.jpg").getImage();
		tileset_menu[4] = new ImageIcon("res/watchan.png").getImage();
		
		save.LoadSave(new File("save/level" + level + ".kyle"));
		
		for(int i=0;i<mobs.length;i++) {
			mobs[i] = new Mob();

		}
		
	}
	
	public void paintComponent(Graphics g){
		if(isFirst) {
			myWidth = getWidth();
			myHeight = getHeight();
			define();
			isFirst = false;
		}
		g.setColor(new Color(70, 70, 70));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(0, 0, 0));
		g.drawLine(room.block[0][0].x-1, 0, room.block[0][0].x-1, room.block[room.worldHeight-1][0].y + room.blockSize + 1); //drawing the left line
		g.drawLine(room.block[0][room.worldWidth-1].x + room.blockSize, 0, room.block[0][room.worldWidth-1].x + room.blockSize, room.block[room.worldHeight-1][0].y + room.blockSize); //drawing the right line
		g.drawLine(room.block[0][0].x, room.block[room.worldHeight-1][0].y + room.blockSize, room.block[0][room.worldWidth-1].x + room.blockSize, room.block[room.worldHeight-1][0].y + room.blockSize); //drawing the bottom
		
		room.draw(g);
		
		for(int i=0;i<mobs.length;i++) {
			if(mobs[i].inGame) {
				mobs[i].draw(g);
			}
		}
		
		
		store.draw(g);
		
		if(health < 1){
			g.setColor(new Color(240, 20, 20));	
			g.fillRect(0, 0, myWidth, myHeight);
			g.setColor(new Color(255, 255, 255));
			g.setFont(new Font("courier new", Font.BOLD, 14));
			
			g.drawString("Game Over", 10, 20);
			g.drawImage(Screen.tileset_menu[0], 0, 0, 700, 550, null);
		}
		
		if(isWin) {
			g.setColor(new Color(0, 0, 0));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(new Color(255, 255, 255));
			g.setFont(new Font("courier new", Font.BOLD, 14));
			
			if(level >= maxLevel) {
				g.drawImage(Screen.tileset_menu[1], 0, 0, 700, 550, null);
			} else {
				g.drawImage(Screen.tileset_menu[2], 0, 0, 700, 550, null);
			}
		}
	}
	
	public int spawnTime = 2500, spawnFrame = 0;
	public int spawnTime2 = 2000, spawnFrame2 = 0;
	public int spawnTime3 = 1500, spawnFrame3 = 0;
	
	public void mobSpawner() {
    if (!isPause){
		if(level > 0) {
		if(spawnFrame >= spawnTime) {
			for(int i=0;i<mobs.length;i++) {
				if(!mobs[i].inGame) {
					mobs[i].spawnMob(Value.mobGreeny);
					break;
				}
			}
			spawnFrame = 0;
		} else {
			spawnFrame += 1;
		}
		}
		if(level > 1) {
		if(spawnFrame2 >= spawnTime2) {
			for(int i=0;i<mobs.length;i++) {
				if(!mobs[i].inGame) {
					mobs[i].spawnMob(Value.mob2);
					break;
				}
			}
			spawnFrame2 = 0;
			} else {
				spawnFrame2 += 1;
			}
		}
		if(level > 2){
		if(spawnFrame3 >= spawnTime3) {
			for(int i=0;i<mobs.length;i++) {
				if(!mobs[i].inGame) {
					mobs[i].spawnMob(Value.mob3);
					break;
				}
			}
			spawnFrame3 = 0;
			} else {
				spawnFrame3 += 1;
			}
		}
    }
		}
		
	public void run() {
		try {
			properties.load();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true) {
			if(!isFirst && health > 0 && !isWin) {
				room.physic(); 
				mobSpawner();
				for(int i=0;i<mobs.length;i++) {
					if(mobs[i].inGame) {
						mobs[i].physic();
					}
				}
				
			} else {
				if(isWin) {
					if(winFrame >= winTime) {
						if(level > maxLevel) {
							System.exit(0);
						} else {
							level += 1;
							define();
							isWin = false;
						}
						
						winFrame = 0;
					} else {
						winFrame += 1;
					}
				}
			}
			
			
			repaint();
			
			try {
				Thread.sleep(1);
			} catch(Exception e) { }
		}
	}
}
