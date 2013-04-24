package langton;

import simulation.Ant;
import simulation.Grid;
import simulation.Simulation;
import core.Direction;

public class LangtonAnt {
	/**
	 * Main method.
	 * 
	 * You do not need to modify this method. It will not be part of the
	 * automated or hand marking
	 * @throws InterruptedException 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//初始化网格及蚂蚁
		Grid grid=new Grid(10,10);
		Ant ant=new Ant(5, 5, Direction.NORTH);
		
		Simulation simulation=new Simulation(grid, ant);
		simulation.executeStep();
	}
}
