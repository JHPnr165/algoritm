import java.util.StringTokenizer;

/**
 * Depth first branch and bound Class.
 * 
 * @author Marko Tandre
 *
 */
public class DepthFirst {
	String[] employeeNames;
	String[] jobNames;
	int[][] costsMatrix;
	int[] solution;
	int size;
	Node best;
	long time;

	/**
	 * Contructor. Will call getData() method to get needed data from file.
	 */
	public DepthFirst() {
		getData();
	}

	/**
	 * Depth first branch and bound method.
	 * 
	 * @return
	 */
	public Node depthFirst() {
		Stack stack = new Stack();
		stack.create();
		Node bestNode = getInitialNode();
		stack.push(bestNode);
		long startTime = System.currentTimeMillis();

		while(!stack.isEmpty()) {
			Node tmpNode = stack.pop();
			int costSoFar = tmpNode.costSoFar;
			int cost = tmpNode.cost;
			int position = tmpNode.position;
			int[] solution = tmpNode.solution;

			for(int j = position; j < size; j++) {
				Node nodeToAdd;
				int tmpCostSoFar = costSoFar;
				int[] tmpSolution = new int[size];
				System.arraycopy(solution, 0, tmpSolution, 0, size);
				tmpSolution = swap(tmpSolution, position, j);
				tmpCostSoFar += costsMatrix[position][tmpSolution[position]];
				cost = tmpCostSoFar + employeesMinimumSum(position + 1, tmpSolution);
				if(position == size - 2) {
					if(cost < bestNode.cost) {
						bestNode = new Node(cost, tmpCostSoFar, tmpSolution, position, size);
					}
				} else {
					if(cost < bestNode.cost) {
						nodeToAdd = new Node(cost, tmpCostSoFar, tmpSolution, position + 1, size);
						stack.push(nodeToAdd);
					}
				}
			}
			
		}
		System.out.print("DepthFirst time: ");
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		best = bestNode;
		return bestNode;
	}

	/**
	 * Method to get minimum sum of work costs that are not yet given away.
	 * 
	 * @param employeeIndex Index of employee to start calculating.
	 * @param solution Partly complete solution.
	 * @return Sum of minimum costs.
	 */
	private int employeesMinimumSum(int employeeIndex, int[] solution) {
		int minimum = 0;
		for(int k = employeeIndex; k < size; k++) {
			int column = solution[k];
			int columnMinimum = costsMatrix[employeeIndex][column];
			for(int row = employeeIndex + 1; row < size; row++) {
				if(columnMinimum > costsMatrix[row][column]) {
					columnMinimum = costsMatrix[row][column];
				}
			}
			minimum += columnMinimum;
		}
		return minimum;
	}

	/**
	 * Method to set given job "taken". Will change values in solutions array.
	 * 
	 * @param solution Partly complete solution.
	 * @param position Index 1 to change.
	 * @param position2 Index 2 to change.
	 * @return Updated solution.
	 */
	private int[] swap(int[] solution, int position, int position2) {
		int tmpInt = solution[position];
		solution[position] = solution[position2];
		solution[position2] = tmpInt;
		return solution;
	}

	/**
	 * Method to get initial Node. It'll make and return 
	 * initial solution to have something to compare with.
	 * Initial solution is diagonal solution.
	 * 
	 * @return
	 */
	public Node getInitialNode() {
		Node initialNode = new Node(size);
		int cost = 0;
		for(int i = 0; i < size; i++) {
			cost += costsMatrix[i][i];
		}
		initialNode.cost = cost;
		return initialNode;
	}

	/**
	 * Method to get employee names.
	 * 
	 * @return String array of employee names.
	 */
	public String[] getEmployees() {
		return employeeNames;
	}

	/**
	 * Method to get job costs matrix.
	 * 
	 * @return int[][] job costs matrix.
	 */
	public int[][] getCostsMatrix() {
		return costsMatrix;
	}

	/**
	 * Method to get job names.
	 * 
	 * @return String array of job names.
	 */
	public String[] getJobNames() {
		return jobNames;
	}

	/**
	 * Method to read and set needed data from file. Uses own Reader Class.
	 */
	private void getData() {
		Reader reader = new Reader();
		String[] tmpString = reader.getData("data3.txt");
		size = tmpString.length - 1;
		StringTokenizer tokenized = new StringTokenizer(tmpString[0]);
		jobNames = new String[size];
		employeeNames = new String[size];
		costsMatrix = new int[size][size];

		for(int i = 0; i < size; i++) {
			jobNames[i] = tokenized.nextToken();
		}

		for(int i = 1; i < tmpString.length; i++) {
			tokenized = new StringTokenizer(tmpString[i]);
			employeeNames[i - 1] = tokenized.nextToken();
			for(int j = 1; j < size + 1; j++) {
				costsMatrix[i - 1][j - 1] = Integer.parseInt(tokenized.nextToken());
			}

		}
	}

	public void saveData() {
		Writer writer = new Writer("DepthFirst.out");
		String toWrite = "";
		toWrite += best.cost;
		for(int i = 0; i < size; i++) {
			toWrite += "\n" + employeeNames[i] + " " + jobNames[best.solution[i]]
					+ " " + costsMatrix[i][best.solution[i]];
		}
		writer.writeData(toWrite);
	}
}
