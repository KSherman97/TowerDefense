import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SplashScreen extends JWindow implements Runnable {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  private int duration;
  public SplashScreen(int d) {
  	
  	JProgressBar progressBar = new JProgressBar();
  	getContentPane().add(progressBar, BorderLayout.SOUTH);
    duration = d;
  }

  // A simple little method to show a title screen in the center
  // of the screen for the amount of time given in the constructor
  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.white);

    // Set the window's bounds, centering the window
    int width = 550;
    int height =150;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);

    // Build the splash screen
    JLabel copyrt = new JLabel("Copyright " + Value.copyrightYear + ", " + Value.copyrightNotice, JLabel.CENTER);
    copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));

    BufferedImage myPicture = null;
    try {
      myPicture = ImageIO.read(new File("res/watchan.png"));
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    add(picLabel);

    content.add(copyrt, BorderLayout.SOUTH);
    Color oraRed = new Color(156, 20, 20,  255);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 10));


    // Display it
    setVisible(true);



    // Wait a little while, maybe while loading resources
    try { Thread.sleep(duration); } catch (Exception e) {}
    new Main();
    setVisible(false);
    
  }

  public void showSplashAndExit() {
    showSplash();
    System.exit(0);
  }

  public static void main(String[] args) {
    // Throw a nice little title page up on the screen first
    // Normally, we'd call splash.showSplash() and get on with the program.
    // But, since this is only a test...
  }

  public void paintComponent(Graphics g) {
    g.drawImage(Screen.tileset_menu[4], 0, 0, null);
  }

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}