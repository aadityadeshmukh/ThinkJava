import javax.swing.JFrame;
import java.awt.Color;
public class Convay{
	private Viz v;
	public Convay(){
		v = new Viz(5,10,20);
		v.turnOn(2,1);
		v.turnOn(2,2);
		v.turnOn(2,3);
		v.turnOn(1,7);
		v.turnOn(2,7);
		v.turnOn(3,7);
	}

	public static void main(String[] args){
		JFrame frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Convay game = new Convay();
		game.v.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.add(game.v);
		frame.pack();
		frame.setVisible(true);
		//game.mainloop();
	}

// 	private void mainloop() {
// 		while (true) {
// 		this.update();
// 		v.repaint();
// 		Thread.sleep(500); // compiler error
// }
// }
}