package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import widget.MTSurface;

public class Main {
	
	static MTSurface mts;
	static JFrame fen;
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(
				new Runnable(){
					public void	run(){
						createGui();
					}
		});
	}	
	
	public static void createGui(){
		createFrame();
		createMTSurface();
	}
	
	public static void createFrame(){
		fen = new JFrame("IVI projet");
		fen.setLayout(new FlowLayout());
		fen.setPreferredSize(new Dimension(900,900));
		fen.pack();
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
	}
	
	public static void createMTSurface(){
		mts = new MTSurface();
		mts.setPreferredSize(new Dimension(700,700));
		mts.setBackground(Color.blue);
		mts.setBorder(BorderFactory.createLineBorder(Color.red));
		fen.add(mts);
	}

}
