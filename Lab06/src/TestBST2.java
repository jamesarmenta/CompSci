
public class TestBST2 {

	public static void main(String[] args) {
		BSTree2 myBST2 = new BSTree2();
		myBST2.insert(13);
		myBST2.insert(45);
		myBST2.insert(10);
		myBST2.insert(9);
		myBST2.insert(54);
		myBST2.insert(11);
		myBST2.insert(42);
		
		//myBST2.insert(99);
		//myBST2.insert(1);
		
		myBST2.inOrderPrint();
		System.out.println();
		myBST2.findMinimum();
		myBST2.findMaximum();
		
	}

}
