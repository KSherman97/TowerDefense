import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Store {
	public static int shopWidth = 5;
	public static int buttonSize = 52;
	public static int cellSpace = 2;
	public static int AwayFromRoom = 29;
	public static int IconSize = 20;
	public static int IconSpace = 6;
	public static int IconTextY1 = 15;
	public static int IconTextY2 = 16;
	public static int itemIn = 4;
	public static int heldID = -1;
	public static int realID = -1;
	public static int damageID = -1;
	public static int[] buttonID = {2, 3, 4, 5, 1, 10, 10, 1};
	public static int [] buttonPrice = {10, 50, 500, 1000, 0, 0, 0, 0}; //{10, 50, 500, 1000, 0, 0, 0, 0};
	public static int returnPrice;
	
	public static Image[] tileset_store = new Image[100];
	
	
	
	public Rectangle[] button = new Rectangle[shopWidth];
	public Rectangle buttonHealth;
	public Rectangle buttonCoins;
	
	public static boolean holdsItem = false;
	public static boolean sold = false; // Not in use at the moment
	
	public Store() {
		define();
	}
	
	public void click(int mouseButton) {
		if(mouseButton == 1) {
			for(int i=0;i<button.length;i++) {
				if(button[i].contains(Screen.mse)) {
					if(buttonID[i] == Value.airTrashCan) { // delete Item
						holdsItem = false;
					} else {
						heldID = buttonID[i];
						realID = i;
						holdsItem = true;
					}
				}
			}
			
			if(holdsItem) {
				if(Screen.coinage >= buttonPrice[realID]) {
					for(int y=0;y<Screen.room.block.length;y++){
						for(int x=0;x<Screen.room.block[0].length;x++){
								if(Screen.room.block[y][x].contains(Screen.mse)) {
									if(Screen.room.block[y][x].groundID != Value.groundRoad && Screen.room.block[y][x].airID == Value.airAir) {
										Screen.room.block[y][x].airID = heldID;
										Screen.coinage -= buttonPrice[realID];
										sold = false;
									}
									//System.out.println("GroundID: " +Screen.room.block[y][x].groundID + " airID: " + Screen.room.block[y][x].airID);
								}
						}
					}
				}
				
			}
			if (!holdsItem){ // This sells back an item at 1/2 price
	             for(int y=0;y<Screen.room.block.length;y++){
	                 for(int x=0;x<Screen.room.block[0].length;x++){
	                         if(Screen.room.block[y][x].contains(Screen.mse)) {
	                             if(Screen.room.block[y][x].groundID != Value.groundRoad && Screen.room.block[y][x].airID != Value.airAir) {
	                            	 returnPrice = Screen.room.block[y][x].airID = buttonPrice[realID];
	                            	 Screen.coinage += returnPrice / 2 ;
	                            	 Screen.room.block[y][x].groundID = Value.groundGrass;
	                            	 Screen.room.block[y][x].airID = Value.airAir;
	                            	 Screen.room.block[y][x].shotMob = -1;
	                            	 Screen.room.block[y][x].shooting = false;
	                            	//sold = true; The sold function has no real use at the moment
	                             }
	                            // System.out.println("GroundID: " +Screen.room.block[y][x].groundID + " airID: " + Screen.room.block[y][x].airID);
	                         }	
	                 }
	             }    
			}
		}
			if(Screen.isDebug == true) {
			  
				if(mouseButton == 2) {
					
				}
			}
		if(mouseButton == 3) {
			holdsItem = false;
		}
	}
	public void press(int keyButton) {
		
	}
	
	public void define() {
		for(int i=0;i<button.length;i++) {
			button[i] = new Rectangle((Screen.myWidth/2) - ((shopWidth*buttonSize)/2) + ((buttonSize+cellSpace)*i), (Screen.room.block[Screen.room.worldHeight-1][0].y) + Screen.room.blockSize + AwayFromRoom, buttonSize, buttonSize);
		}
		
		tileset_store[0] = new ImageIcon("res/1.jpg").getImage();
		buttonHealth = new Rectangle(Screen.room.block[0][0].x - 1, button[0].y, IconSize, IconSize);
		buttonCoins = new Rectangle(Screen.room.block[0][0].x - 1, button[0].y + button[0].height - IconSize, IconSize, IconSize);
		
	}
	
	public void draw(Graphics g){
		for(int i=0;i<button.length;i++) {
			if(button[i].contains(Screen.mse)) {
				g.setColor(new Color(255, 255, 255, 250));
				if(buttonID[i] != Value.airAir) g.fillRect(button[i].x, button[i].y, button[i].width, button[i].height);
			}
			
		g.drawImage(Screen.tileset_res[0], button[i].x, button[i].y, button[i].width, button[i].height, null);
		g.drawImage(Screen.tileset_air[buttonID[i]], button[i].x + itemIn, button[i].y + itemIn, button[i].width - (itemIn * 2), button[i].height - (itemIn * 2), null);
		
		if(buttonPrice[i] > 0) {
			g.setColor(new Color(255, 255, 255));
			g.setFont(new Font("Courier new", Font.BOLD, 16));
			g.drawString("$" + buttonPrice[i], button[i].x + itemIn, button[i].y + itemIn - 5);
			g.setFont(new Font("Courier new", Font.BOLD, 14));
		}
		if(Screen.isPause) {
			g.setFont(new Font("Courier new", Font.BOLD, 34));
			g.drawString("Paused!",280 , 225);
		}
		
		}
		
		g.drawImage(Screen.tileset_res[2], buttonHealth.x, buttonHealth.y, buttonHealth.width, buttonHealth.height, null);
		g.drawImage(Screen.tileset_res[1], buttonCoins.x, buttonCoins.y, buttonCoins.width, buttonCoins.height, null);
		g.setFont(new Font("Courier New", Font.BOLD, 14));
		g.setColor(new Color(255, 255, 255));
		g.drawString("" + Screen.health, buttonHealth.x + buttonHealth.width + IconSpace, buttonHealth.y + IconTextY1);
		g.drawString("" + Screen.coinage, buttonCoins.x + buttonCoins.width + IconSpace, buttonCoins.y + IconTextY2);
		
		g.drawString("WE ARE IN BETA!",10 , 520);
		
		// Draw the item number
		g.setFont(new Font("Courier new", Font.BOLD, 16));
		g.drawString("(1)", 230, 510);
		g.drawString("(2)", 282, 510);
		g.drawString("(3)", 335, 510);
		g.drawString("(4)", 390, 510);
		
		if(holdsItem){
			g.drawImage(Screen.tileset_air[heldID], Screen.mse.x - (button[0].width - ((itemIn * 2) )/2) + itemIn, Screen.mse.y - (button[0].width - ((itemIn * 2) )/2) + itemIn, button[0].width - (itemIn * 2), button[0].height - (itemIn * 2), null);
		}
	}

	
}

