import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
public class Drawing extends Canvas{
	public static void main(String[] args){
		JFrame frame = new JFrame("My Drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawing d = new Drawing();
		d.setSize(400,400);
		d.setBackground(Color.WHITE);
		frame.add(d);
		frame.pack();
		frame.setVisible(true);
	}
	public void boxOval(Graphics g, Rectangle bb){
		g.fillOval(bb.x,bb.y,bb.width,bb.height);
	}
	public void Mickey(Graphics g, Rectangle bb){
		if(bb == null)
			bb = new Rectangle(100,100,200,200);
		if(bb.width < 3 || bb.height < 3) return;
		boxOval(g, bb);
		int hw = bb.width/2;
		int hb = bb.height/2;
		Rectangle r1 = new Rectangle(bb.x, bb.y, hw, hb);
		r1.translate(-hw/2, -hb/2);
		Mickey(g, r1);
		r1.translate(hw*2, 0);
		Mickey(g, r1);
	}
	public void paint(Graphics g){
		
		Mickey(g,null);
	}
}