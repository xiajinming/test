package simulation;

/**
 * 
 * Grid class
 * 
 * @author _________
 *
 */
public class Grid {

	//false:白色格子，true：黑色格子
	boolean[][] grid;

	/**
	 * Constructor for the grid.
	 * 
	 * Initial state is that the every cell in the grid is white
	 * 
	 * @param height - height of the grid
	 * @param width - width of the grid
	 */
	public Grid(int height, int width) {
		grid=new boolean[width][height];
	}

	public int getHeight() {
		return grid[0].length;
	}

	public int getWidth() {
		return grid.length;
	}

	/**
	 * 获取第i行第j列的格子是否为白色
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isWhite(int i, int j) {
		if(checkValideXY(i, j)){
			return !grid[i-1][j-1];
		}
		return false;
	}
	
	/**
	 * 获取第i行第j列的格子是否为黑色
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isBlack(int i, int j) {
		if(checkValideXY(i, j)){
			return grid[i-1][j-1];
		}
		return false;
	}

	/**
	 * 设置第i行，第j列为白色
	 * @param i
	 * @param j
	 */
	public void setWhite(int i, int j) {
		if(checkValideXY(i, j)){
			grid[i-1][j-1]=false;
		}
	}

	/**
	 * 设置第i行，第j列为黑色
	 * @param i
	 * @param j
	 */
	public void setBlack(int i, int j) {
		if(checkValideXY(i, j)){
			grid[i-1][j-1]=true;
		}
	}
	
	/**
	 * 将格子的颜色改成相反的颜色
	 */
	public void changeGridColor(int i,int j){
		if(checkValideXY(i, j)){
			grid[i-1][j-1]=!grid[i-1][j-1];
		}
	}
	
	/**
	 * 判断蚂蚁是否超出Grid
	 * @param ant
	 * @return
	 */
	public boolean isAntOver(Ant ant){
		return !checkValideXY(ant.getiPos(), ant.getjPos());
	}
	
	/**
	 * 打印网格
	 */
	public void print(Ant ant){
		for(int j=0;j<getHeight();j++){
			for(int i=0;i<getWidth();i++){
				if(i==0){
					System.out.print("|");
				}
				if(ant!=null && i==ant.getiPos()-1 && j==ant.getjPos()-1){
					System.out.print((grid[i][j]?1:0)+ant.getCurrentPos()+ant.getDirection().getDirection()+"|");
				}else{
					if(i==ant.getiPos()-1){
						System.out.print(""+(grid[i][j]?1:0)+"       |");
					}else{
						System.out.print(""+(grid[i][j]?1:0)+"|");
					}
				}
			}
			System.out.println("");
		}
		System.out.println("======================");
		System.out.println("");
	}
	
	/**
	 * 验证x，y是否超出边界
	 * @param x
	 * @param y
	 * @return
	 */
	protected boolean checkValideXY(int x,int y){
		if(x>grid.length || x<1 || y>grid.length || y<1){
			return false;
		}
		return true;
	}
}
