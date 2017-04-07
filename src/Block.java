import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Rectangle towerSquare;
	public int towerSquareSize = 200;
	public int groundID;
	public int airID;
	public int mobID;
	public int loseTime = 100, loseFrame = 0;
	
	float amo;
	
	public int shotMob = -1;
	public boolean shooting = false;
	
	public Block(int x, int y, int width, int height, int groundID, int airID) {
		setBounds(x, y, width, height);
		towerSquare = new Rectangle(x - (towerSquareSize/2), y - (towerSquareSize/2), width + (towerSquareSize), height + (towerSquareSize));
		this.groundID = groundID;
		this.airID = airID;
	}
	
	public void draw(Graphics g){
		g.drawImage(Screen.tileset_ground[groundID], x, y, width, height, null);

		if(airID != Value.airAir){
			g.drawImage(Screen.tileset_air[airID], x, y, width, height, null);
			
		}
	}
	
	public void physic() {
			if(shotMob != -1 && towerSquare.intersects(Screen.mobs[shotMob])) {
				shooting = true;
			} else {
				shooting = false;
			}
		
			if(!shooting) {
			if(airID == Value.airTowerLaser) {
				amo = Value.damage[0];
				for(int i=0;i<Screen.mobs.length;i++) {
						if(Screen.mobs[i].inGame) {
							if(towerSquare.intersects(Screen.mobs[i])) {
								shooting = true;
								shotMob = i;
							}
						}
					}
				}
			
			if(airID == Value.airTowerLaser2) {
				amo = Value.damage[1];
				for(int i=0;i<Screen.mobs.length;i++) {
						if(Screen.mobs[i].inGame) {
							if(towerSquare.intersects(Screen.mobs[i])) {
								shooting = true;
								shotMob = i;
							}
						}
					}
				}
			if(airID == Value.airTowerLaser3) {
				amo = Value.damage[2];
				for(int i=0;i<Screen.mobs.length;i++) {
						if(Screen.mobs[i].inGame) {
							if(towerSquare.intersects(Screen.mobs[i])) {
								shooting = true;
								shotMob = i;
							}
						}
					}
				}
			if(airID == Value.airTowerLaser4) {
				amo = Value.damage[3];
				for(int i=0;i<Screen.mobs.length;i++) {
						if(Screen.mobs[i].inGame) {
							if(towerSquare.intersects(Screen.mobs[i])) {
								shooting = true;
								shotMob = i;
							}
						}
					}
				}
			if(airID == Value.airTowerLaser5) {
				for(int i=0;i<Screen.mobs.length;i++) {
						if(Screen.mobs[i].inGame) {
							if(towerSquare.intersects(Screen.mobs[i])) {
								shooting = true;
								shotMob = i;
							}
						}
					}
				}
			}
			
			// Don't do damage after shooting.
			if(!Store.sold) {
			if(shooting) {
				if(loseFrame >= loseTime) {
					Screen.mobs[shotMob].loseHealth(amo);
					loseFrame = 0;
				}else {
					loseFrame += 1;
				}
				
				if(Screen.mobs[shotMob].isDead()) {
					//getMoney(Screen.mobs[shotMob].mobID);
					
					shooting = false;
					shotMob = -1;
					
					//Screen.killed += 1;
					
					Screen.hasWon();
				}
				
			}
	}
		}
	
	
	
	public void fight(Graphics g) {
		if(Screen.isDebug) {
			if(airID == Value.airTowerLaser) {
				g.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);
			}
		}
			if(shooting) {
				g.setColor(new Color(255, 255, 0));
				if(!Store.sold) {
				g.drawLine(x + (width/2), y + (height/2), Screen.mobs[shotMob].x + (Screen.mobs[shotMob].width/2), Screen.mobs[shotMob].y + (Screen.mobs[shotMob].height/2));
				} else {}	
				}
		}
}
