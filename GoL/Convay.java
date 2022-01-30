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
		game.mainloop();
	}

	private void mainloop() {
		while (true) {
		this.update();
		v.repaint();
		try{
			Thread.sleep(500); 
		}
		catch(InterruptedException e){
			// compiler error
		}
		
	}
	}

	private int countAlive(int r, int c){
		int count = 0;
		count+= v.test(r-1, c-1);
		count+= v.test(r-1, c);
		count+= v.test(r-1, c+1);
		count+= v.test(r, c-1);
		count+= v.test(r, c+1);
		count+= v.test(r+1, c-1);
		count+= v.test(r+1, c);
		count+= v.test(r+1, c+1);
		return count;
	}

	public void update(){
		int[][] counts =  countNeighbors();
		updateGrid(counts);
	}

	private int[][] countNeighbors(){
		int rows = v.numRows();
		int cols = v.numCols();
		int[][] counts = new int[rows][cols];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				counts[i][j] = countAlive(i,j);
			}
		}
		return counts;
	}

	private void updateGrid(int[][] counts){
		int rows = v.numRows();
		int cols = v.numCols();

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				Cell c = v.getCell(i,j);
				updateCell(c, counts[i][j]);
			}
		}
	}

	private static void updateCell(Cell c, int count){
		if(c.isOn()){
			if(count < 2 || count > 3)
				c.turnOff();
		}
		else{
			if(count == 3)
				c.turnOn();
		}
	}
}