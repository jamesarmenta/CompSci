
public class TestHeap {

	public static void main(String[] args)
	{
		Heap theHeap = new Heap();
		
		theHeap.add("First", 100);
		theHeap.add("Second", 50);
		theHeap.add("Third", 90);
		theHeap.add("Fourth", 49);
		theHeap.add("Fifth", 10);
		theHeap.add("Sixth", 80);
		theHeap.add("Seventh", 85);
		theHeap.add("Eighth", 6);
		
		theHeap.print();
		
	}
}