
public class TestPriorityQueue {

	public static void main(String[] args) 
	{
		PriorityQueue theQ = new PriorityQueue();
		
		theQ.enqueue("James", 1);
		theQ.enqueue("Tom", 2);
		theQ.enqueue("Bill", 3);
		theQ.enqueue("Zeth", 6);
		theQ.enqueue("Cat", 5);
		theQ.enqueue("Cat", 4);
		
		theQ.printByLevels();
		System.out.println("");

		//theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue();
		theQ.printByLevels();
		

	}

}