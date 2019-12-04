package com.stg.bcp.display;

import java.awt.*;
import javax.swing.*;

public class Display {
	private JFrame frame;

	//HealthBar
	public static JPanel healthBarPanel;
	public static JProgressBar healthBar;
	public static int hp;

	private Canvas canvas;
	private JTextField textfield;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		textfield = new JTextField("Score", 10);
		createDisplay();
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		healthBarPanel = new JPanel();
		healthBarPanel.setBounds(520, 30, 200, 30);
		healthBarPanel.setBackground(Color.GREEN);
		frame.add(healthBarPanel);

		hp = 100;
		healthBar = new JProgressBar(0, 100);
		healthBar.setPreferredSize(new Dimension(200, 30));
		healthBar.setValue(100);
		healthBarPanel.add(healthBar);

		frame.add(canvas);
		frame.pack();
	}


	public static void damageReceived()
	{
		hp -= 10;
		healthBar.setValue(hp);
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
