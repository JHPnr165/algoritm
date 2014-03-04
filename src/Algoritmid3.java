/**
 * Main Class.
 * 
 * @author Marko Tandre
 *
 */
public class Algoritmid3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BestFirst bestFirst = new BestFirst();
		DepthFirst depthFirst = new DepthFirst();
		DepthNoBranch noBranch = new DepthNoBranch();
		depthFirst.depthFirst();
		bestFirst.bestFirst();
		noBranch.depthFirst();
		bestFirst.saveData();
		depthFirst.saveData();
		noBranch.saveData();
	}

}
