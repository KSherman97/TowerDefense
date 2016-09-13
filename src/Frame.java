import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	public static String title = "Tower Defense " + Value.version + " By Watchan Games";
	public static Dimension size = new Dimension(700, 550);
	
	public Frame(){
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
	}

	public void init(){
		setLayout(new GridLayout(1, 1, 0, 0));
		Screen screen = new Screen(this);
		add(screen);
		setVisible(true);

	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		SplashScreen splash = new SplashScreen(1500);
		 //splash.showSplashAndExit();
		splash.showSplash();
		//Frame frame = new Frame();
		
	}
}
