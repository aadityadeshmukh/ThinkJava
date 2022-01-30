import java.awt.Canvas;

import java.awt.Graphics;
public class Viz extends Canvas{
	public Cell[][] grid;
	public Viz(int rows, int col, int size){
		grid = new Cell[rows][col];

		for(int i = 0; i < rows; i++){
			int y = i * size;
			for(int j = 0; j < col; j++){
				int x = j * size;

				grid[i][j] = new Cell(x,y,size);
			}
		}
		setSize(col*size,rows*size);
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

	public int numRows(){
		return grid.length;
	}

	public int numCols(){
		return grid[0].length;
	}

	public Cell getCell(int r, int c){
		return grid[r][c];
	}
	public void turnOn(int r, int c){
		grid[r][c].turnOn();
	}

	public int test(int r, int c){
		try{
			if(grid[r][c].isOn())
				return 1;
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return 0;
	}

	public int countOn(){
		int population = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j].isOn())
					population++;
			}
		}
		return population;
	}
}