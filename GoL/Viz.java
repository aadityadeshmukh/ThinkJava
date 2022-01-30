import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
public class Viz extends Canvas{
	public static void main(String[] args){
		JFrame frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Viz d = new Viz();
		d.setSize(400,400);
		d.setBackground(Color.WHITE);
		frame.add(d);
		frame.pack();
		frame.setVisible(true);
	}

	public void paint(Graphics g){
		Cell c = new Cell(200,200,10);
		while(true){
			if(c.isOff())
				c.turnOn();
			else
				c.turnOff();
			c.draw(g);
		}
	}
}