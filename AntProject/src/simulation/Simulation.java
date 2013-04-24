package simulation;

import core.Direction;

/**
 * 
 * Simulation class
 * 
 * @author _________
 *
 */
public class Simulation {

	private Grid grid;
	private Ant ant;
	
	public Simulation(Grid grid,Ant ant){
		this.grid=grid;
		this.ant=ant;
	}

	/**
	 * Execute a time step for the simulation.
	 * 
	 * The ant must:
	 * 		* move forward 1 space
	 * 			- if this movement would cause it to move off the grid, 
	 * 				the simulation is completed.
	 * 		* rotate depending on the state of the cell the ant is occupying
	 * 			- if the cell is white, rotate left
	 * 			- otherwise, rotate right
	 * 		* change the state of the cell the ant is currently occupying
	 * 			- if the cell is white, it becomes black
	 * 			- otherwise, it becomes white
	 * 
	 * NOTE: this method should do nothing if the simulation is completed.
	 * @throws InterruptedException 
	 */
	public void executeStep() throws InterruptedException {
		while(!grid.isAntOver(ant)){
			int oldx=ant.getiPos();
			int oldy=ant.getjPos();
			if(grid.isWhite(oldx, oldy)){
				ant.moveLeft();
			}else{
				ant.moveRight();
			}
			grid.changeGridColor(oldx, oldy);
			grid.print(ant);
			Thread.currentThread().sleep(2000);
		}
	}
}
