package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mygeom.Tuple2;
import widget.MTPicture;
import widget.MTSurface;
import TUIO.TuioCursor;

public class Main {
	
	static TuioCursor tcur;
	static JLabel statusLabel = new JLabel();
	static boolean show;
	
	public static void main(String args[]) {
		show = true;
		// question 2 : MTedt m = new MTedt();
		//tcur = new TuioCursor(7, 13, 43, 23);
		
		SwingUtilities.invokeLater(
				new Runnable(){
					public void	run(){
						createGui();
					}
				});
	}
	
	
	public static void createGui() {
		//cr�ation de la fen�tre
		JFrame fen = new JFrame("First Window"); 
		fen.setLayout(new FlowLayout());
		fen.setPreferredSize(new Dimension(900,900));
		fen.pack();
		fen.setVisible(true);
		
		//cr�ation du MTSurfaceMTSurface mts = new MTSurface();
		MTSurface mts = new MTSurface();
		JButton jb = new JButton("Hide Cursor");
		
		jb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            if(show){
	            	statusLabel.setText("Show Cursor");
	            	show = false;
	            }else{
	            	statusLabel.setText("Hide Cursor");
	            	show = true;
	            }
	            
	         }          
	      });
		
		MTPicture mtp = new MTPicture("licorne.jpg", new Tuple2(500,500), new Tuple2(0,0));
		mts.add(mtp);
		mtp = new MTPicture("Bird.jpg", new Tuple2(500,500), new Tuple2(50,50));
		mts.add(mtp);
		mts.add(jb);
		
		//mts.getMTedt().addTuioCursor(tcur);
		mts.setPreferredSize(new Dimension(800,800));
		mts.setBackground(new Color(0,25,250));
		
		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createLineBorder(Color.red));
		pane.add(mts);
		fen.getContentPane().add(pane);
		pane.repaint();
		
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
}
