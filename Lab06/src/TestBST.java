
public class TestBST {

	public static void main(String[] args) {
		
		BSTree myBST = new BSTree();
		myBST.insert(100);
		myBST.insert(50);
		myBST.insert(250);
		myBST.insert(20);
		myBST.insert(30);
		myBST.insert(1);
		
		myBST.findMaximum();
		myBST.findMinimum();
		System.out.println("- - - - ");
		myBST.inOrderPrint();

	}

}
