import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.io.*;
import java.net.URL;

import javax.sound.sampled.*;
import javax.swing.*;

public class Main extends JFrame {

	private JButton myFirstButton;
	private JButton mySecondButton;
	private JButton myThirdButton;
	private JTextField myFirstText; // This will be implemented later to change username
	
	

	// Constructor for a new frame

	@SuppressWarnings("deprecation")
	public Main() {
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle(Value.version);
		//setDefaultLookAndFeelDecorated(true);
		//setUndecorated(true);
		//getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		myFirstButton = new JButton("Launch Game");
		myFirstButton.setBounds(205, 152, 267, 31);
		myFirstButton.setFont(new Font( "Arial", Font.BOLD, 18));
		myFirstButton.setBackground(Color.red);
		
		mySecondButton = new JButton("Exit");
		mySecondButton.setBounds(205, 251, 267, 31);
		mySecondButton.setFont(new Font( "Arial", Font.BOLD, 18));
		mySecondButton.setBackground(Color.red);
		
		myThirdButton = new JButton("Options");
		myThirdButton.setBounds(205, 201, 267, 31);
		myThirdButton.setFont(new Font( "Arial", Font.BOLD, 18));
		myThirdButton.setBackground(Color.red);
		

		
	    //myFirstText = new JTextField(30);
		//myFirstText.setBounds(205, 243, 267, 31);
		
		Container c = getContentPane();
		getContentPane().setLayout(null);

		c.add (myFirstButton);
		c.add (mySecondButton);
		c.add (myThirdButton);
		//c.add(myFirstText);
		
		JLabel lblNewLabel = new JLabel(Value.version);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblNewLabel.setBounds(205, 100, 267, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCreatedByWatchan = new JLabel(Value.copyrightNotice);
		lblCreatedByWatchan.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedByWatchan.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 10));
		lblCreatedByWatchan.setBounds(205, 473, 267, 38);
		getContentPane().add(lblCreatedByWatchan);

		ButtonHandler handler = new ButtonHandler();	//creation of a new Object
		myFirstButton.addActionListener(handler);	   // Attach/register handler to myFirstButton
		mySecondButton.addActionListener(handler);	  //Attach/register handler to mySecondButton
		myThirdButton.addActionListener(handler);

		setSize(700, 550);
		setLocationRelativeTo(null);
		show();
		//new audio();
		
	}
	

	
	public static void main(String [] args) {

		// Make frame
		Main f = new Main();
		f.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {

					// This closes the window and terminates the
					// Java Virtual Machine in the event that the
					// Frame is closed by clicking on X.
					// System.out.println("Exit via windowClosing.");
					//audio.activeClip.stop();
					System.exit(0);
				}
			}
		);
	} // end of main

	// inner class for button event handling
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == myFirstButton) {
				Frame frame = new Frame();
				setVisible(false);
				//audio.activeClip.stop();
				
			}
			if (e.getSource() == myThirdButton) {
				new Options();
				setVisible(false);
			}
			if (e.getSource() == mySecondButton) {
				//audio.activeClip.stop();
				System.exit(0);
			}
		}
	} // end of inner class
} // end of outer class



