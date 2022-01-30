import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
public class Viz extends Canvas{
	public Cell[][] grid;
	public Viz(int rows, int col, int size){
		grid = new Cell[rows][col];

		for(int i = 0; i < rows; i++){
			int x = i * size;
			for(int j = 0; j < col; j++){
				int y = j * size;

				grid[i][j] = new Cell(x,y,size);
			}
		}
		setSize(rows*size,col*size);
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Viz d = new Viz(4,3,20);
		//d.setBackground(Color.WHITE);
		frame.add(d);
		frame.pack();
		frame.setVisible(true);
	}

	public void draw(Graphics g){
		for(Cell[] row : grid){
			for(Cell c : row){
				c.draw(g);
			}
		}
	}

	public void paint(Graphics g){
		draw(g);
	}
}