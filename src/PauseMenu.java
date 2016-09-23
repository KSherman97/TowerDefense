

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

public class PauseMenu extends JFrame {

	private JButton myFirstButton;
	private JButton mySecondButton;
	private JButton myThirdButton;
	private JTextField myFirstText; // This will be implemented later to change username
	
	

	// Constructor for a new frame

	@SuppressWarnings("deprecation")
	public PauseMenu() {
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Value.version + " Options");
		
		// Buttons
		mySecondButton = new JButton("Resume");
		mySecondButton.setBounds(205, 450, 267, 31);
		mySecondButton.setFont(new Font( "Arial", Font.BOLD, 18));
		mySecondButton.setBackground(Color.red);
		
		Container c = getContentPane();
		getContentPane().setLayout(null);
		c.add (mySecondButton);
		
		
		// Labels
		JLabel lblNewLabel = new JLabel("Options");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblNewLabel.setBounds(205, 100, 267, 38);
		getContentPane().add(lblNewLabel);
		
		
		JLabel options = new JLabel("<html>ESC ... pause<BR>left mouse ... place / sell tower.<BR>right mouse ... clear selected item.</html>");
		options.setHorizontalAlignment(SwingConstants.CENTER);
		options.setBounds(205,110,267,110);
		getContentPane().add(options);
		
		JLabel lblCreatedByWatchan = new JLabel("Created by Watchan games");
		lblCreatedByWatchan.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedByWatchan.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 10));
		lblCreatedByWatchan.setBounds(205, 473, 267, 38);
		getContentPane().add(lblCreatedByWatchan);

		ButtonHandler handler = new ButtonHandler();	//creation of a new Object
		mySecondButton.addActionListener(handler);	  //Attach/register handler to mySecondButton

		setSize(700, 550);
		setLocationRelativeTo(null);
		show();
		new audio();
		
	}
	

	
	public static void main(String [] args) {

		// Make frame
		PauseMenu f = new PauseMenu();
		f.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {

					// This closes the window and terminates the
					// Java Virtual Machine in the event that the
					// Frame is closed by clicking on X.
					// System.out.println("Exit via windowClosing.");
					audio.activeClip.stop();
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
				audio.activeClip.stop();
				
			}
			if (e.getSource() == myThirdButton) {
				Frame frame = new Frame();
				setVisible(false);
				audio.activeClip.stop();
			}
			if (e.getSource() == mySecondButton) {
				Screen.isPause = false;
				setVisible(false);
			}
		}
	} // end of inner class
} // end of outer class



