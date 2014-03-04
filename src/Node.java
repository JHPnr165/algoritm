
/**
 * Node Class. Class for storing search results in BestFirst.java, DepthFirst.java
 * and DepthNoBranch.java.
 * 
 * @author Marko Tandre
 *
 */
public class Node {
	int cost = 0;
	int costSoFar = 0;
	int[] solution;
	int position = 0;

	/**
	 * Constructor #1.
	 */
	public Node() {solution = new int[5];}

	/**
	 * Constructor #2.
	 * 
	 * @param length length of the solution.
	 */
	public Node(int length) {
		solution = new int[length];
		for(int j = 0; j < length; j++) {
			solution[j] = j;
		}
	}

	/**
	 * Constructor #3.
	 * 
	 * @param cost Calculated potential minimum.
	 * @param costSoFar Cost so far.
	 * @param solution Solution array.
	 * @param position Current position.
	 * @param size Length of solution.
	 */
	public Node(int cost, int costSoFar, int[] solution, int position, int size) {
		this.cost = cost;
		this.costSoFar = costSoFar;
		this.solution = new int[size];
		this.position = position;
		System.arraycopy(solution, 0, this.solution, 0, size);
	}

	/**
	 * Method to copy Node.
	 * 
	 * @param node Node to copy.
	 * @return New copied Node.
	 */
	public Node copyNode(Node node) {
		Node nodeToReturn = new Node();
		nodeToReturn.cost = node.cost;
		nodeToReturn.costSoFar = node.costSoFar;
		nodeToReturn.solution = new int[node.solution.length];
		System.arraycopy(node.solution, 0, nodeToReturn.solution, 0, node.solution.length);
		nodeToReturn.position = node.position;
		return nodeToReturn;
	}

}
