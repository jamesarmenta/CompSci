
public class Graph2 
{
	private int[][] adjMatrix;
	private Vertex vertices[];
	private LinkedList edgeList[];
	private int vNumToAdd = 0;

	public Graph(int numOfVs)
	{
		adjMatrix = new int[numOfVs][numOfVs];
		vertices = new Vertex[numOfVs];

		for (int i=0; i<numOfVs; i++)
		{
			vertices[i] = new Vertex(i, "" + i);
		}		
		
	}
	
	public void addVertex(String s)
	{
		vertices[vNumToAdd] = new Vertex(vNumToAdd, s);
		vNumToAdd++;
	}

	//undirected edge
	public void addEdge(int vFrom, int vTo)
	{
		adjMatrix[vFrom][vTo] = 1;
		adjMatrix[vTo][vFrom] = 1;
	}
	//undirected edge with weight
	public void addEdgeWithWeight(int vFrom, int vTo, int weight)
	{
		adjMatrix[vFrom][vTo] = weight;
		adjMatrix[vTo][vFrom] = weight;
	}
	//directed edge
	public void addDirectedEdge(int vFrom, int vTo)
	{
		addDirectedEdgeWithWeight(vFrom, vTo, 1);
	}
	//directed edge with weight
	public void addDirectedEdgeWithWeight(int vFrom, int vTo, int weight)
	{
		adjMatrix[vFrom][vTo] = weight;
	}
	
	public int numberOfVs()
	{
		return vertices.length;
	}
	
	public String BFS(int startV)
	{
		final int UNVISITED = 0;
		final int WAITING = 1;
		final int VISITED = 2;
		
		QueueOfInts theQ = new QueueOfInts();
		String BFSoutput = "";
		int flags[] = new int[numberOfVs()];
		
		// set all v's to unvisited (done already b/c 0 is default for array of ints)
		
		theQ.enqueue(startV);
		flags[startV] = WAITING;

		/*
		 While the queue is not empty
  			Dequeue a vertex from the queue
  			Put it in the visited list, mark it as visited
  			Enqueue all the adjacent vertices that are marked as
    			unvisited to the vertex just dequeued.
  			Mark the vertices just enqueued as waiting
		 */
		while (!theQ.isEmpty())
		{
			int myV = theQ.dequeue();
			BFSoutput += myV + ", ";
			flags[myV] = VISITED;
			
			Node tempNode = edgeList[myV].head;
			while (tempNode != null)
			{
				if (flags[tempNode.data] == UNVISITED)
				{
					theQ.enqueue(tempNode.data);
					flags[tempNode.data] = WAITING;
				}
				tempNode = tempNode.next;
			}
		}
		
		
		return BFSoutput;
	}
/*
Graphs
• DFS
– set all vertices to UNVISITED
– push start vertex
– visit start vertex - set start vertex to visited
– while (stack is not empty)
• peek to get vertex at top of stack
• try to get an unvisited adjacent vertex to the
peeked one
• if there isn't one, pop
• else
– push it
– visit it - set it to visited
*/
	public String DFS(int startV)
	{
		Stack myStack = new Stack();
		String DFSoutput = "";
		
		// set all vertices to UNVISITED
		for (int i=0; i<vertices.length; i++)
		{
			vertices[i].setUnvisited();
		}		
		
		myStack.push(startV);
		DFSoutput += startV + ", ";
		vertices[startV].setVisited();
	
		while (!myStack.isEmpty())
		{
			int vertexNumAtTop = myStack.peek();
			
			// loop through the linked list at vertexNumAtTop in edgeList to find a vertex
			// that's adjacent to vertexNumAtTop (but is also, unvisited)

			Node temp = edgeList[vertexNumAtTop].head;
			while (temp != null && vertices[temp.data].isVisited())
			{
				temp = temp.next;
			}
			// get here I have temp which contains data whose value is a vertex that is adj to vertexNumAtTop
			// and is unvisited OR I have temp==null

			if (temp == null) // means I have no unvisited adj vertices to vertexNumAtTop
			{
				myStack.pop();
			}
			else
			{
				myStack.push(temp.data);
				DFSoutput += temp.data + ", ";
				vertices[temp.data].setVisited();
			}
		}

		return DFSoutput;
	}
}
