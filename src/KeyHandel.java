import java.awt.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class KeyHandel implements MouseMotionListener, MouseListener, KeyListener{
	
	boolean playing = false;
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Screen.store.click(e.getButton());
	}
	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Screen.mse = new Point((e.getX()) + ((Frame.size.width - Screen.myWidth)/2), (e.getY()) + ((Frame.size.height - Screen.myHeight)) -(Frame.size.width - Screen.myWidth)/2);

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Screen.mse = new Point((e.getX()) - ((Frame.size.width - Screen.myWidth)/2), (e.getY()) - ((Frame.size.height - Screen.myHeight)) - (Frame.size.width - Screen.myWidth)/2);
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// Screen.store.press(e.getKeyCode());
			Screen.isDebug = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_QUOTE) {
			// Screen.store.press(e.getKeyCode());
			Screen.isDebug = false;
		}
		if(Screen.isDebug == true) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// Screen.store.press(e.getKeyCode());
			Screen.coinage += 10000;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// Screen.store.press(e.getKeyCode());
			Screen.coinage -= 10000;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// Screen.store.press(e.getKeyCode());
			Screen.health += 10000;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// Screen.store.press(e.getKeyCode());
			Screen.health -= 10000;
		}
		}
		if (!Screen.isPause) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				// Screen.store.press(e.getKeyCode());
				Screen.isPause = true;
				new PauseMenu();
				//System.out.println("paused");
			 }
	  	} else {
	  		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				// Screen.store.press(e.getKeyCode());
				Screen.isPause = false;
				//System.out.println("unpaused");
			 }
	  	}
		
		// If 1 - 4 is pressed, place that turret
		if(e.getKeyCode() == KeyEvent.VK_1) {
			Store.heldID = Store.buttonID[0];
			Store.realID = 0;
			Store.holdsItem = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			Store.heldID = Store.buttonID[1];
			Store.realID = 1;
			Store.holdsItem = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			Store.heldID = Store.buttonID[2];
			Store.realID = 2;
			Store.holdsItem = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			Store.heldID = Store.buttonID[3];
			Store.realID = 3;
			Store.holdsItem = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
