package widget;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import mygeom.Tuple2;

public class MTPicture extends MTComponent {
	BufferedImage img;
	
	public MTPicture(String name){
		super();
		try{	
			img = ImageIO.read(new File("data/" + name));
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public MTPicture(String name, Tuple2 taille, Tuple2 pos){
		this(name);
		this.getTaille().set(taille);
		this.getPos().set(pos);
	}
	
	@Override
	public void draw(Graphics2D g) {
		//paintComponent(g);
		Graphics2D  g2 = ( Graphics2D ) g ;
		//this.drawImage(Math.random()*(500+1), Math.random()*(500+1), Math.random()*(50+1), Math.random()*(50+1));
		g2.drawImage(img,(int) this.getPos().getX() ,(int) this.getPos().getY(),(int) this.getTaille().getX(),(int) this.getTaille().getY(),null);
		//g2.drawImage(img,0,0,(int)obb.getWidth(),(int)obb.getHeight(),null);
	}
	
	public void drawImage(double tx, double ty, double px, double py){
		this.getTaille().setX(tx);
		this.getTaille().setY(ty);
		this.getPos().setX(px);
		this.getPos().setY(py);
	}
	

	public void paintComponent (Graphics g )  {
		//super.paintComponent(g);
		
	}
}
