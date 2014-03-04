/**
 * Stack - last in first out.
 *
 * @author Marko Tandre
 *
 */
public class Stack {
	//Dynamic array for stack.
	private DynamicArray array;

	/**
	 * Method that creates DynamicArray.
	 */
	public void create() {
		array = new DynamicArray();
		array.create(2);
	}

	/**
	 * Method that adds new node to stack.
	 * 
	 * @param nodeToAdd Node to add to stack.
	 */
	public void push(Node nodeToAdd) {
		array.add(nodeToAdd);
	}

	/**
	 * Method to delete first Node from array and return that Node.
	 * 
	 * @return returns first Node from array.
	 */
	public Node pop() {
		return array.rem();
	}

	/**
	 * Method for checking if array consists Nodes or not.
	 * 
	 * @return returns true if array is empty.
	 */
	public boolean isEmpty() {
		return array.len() == 0;
	}

	/**
	 * Method to get String value of the object.
	 */
	public String toString() {
		return array.toString();
	}
}
