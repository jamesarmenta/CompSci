public class UseList {

	public static void main(String[] args) 
	{
		LinkedList myLL = new LinkedList(new Node("Skidmore"));
		
		
		//myLL.searchForNode("First Union College");
		//myLL.replace("First Union College","Replaced College");
		//myLL.clear();
		//myLL.addToBeginning(new Node("Adbegin U"));
		myLL.addBefore("Skidmore","Addbefore University");
		myLL.addToEnd(new Node("Add to end U"));
		myLL.printList();
		
		System.out.println("- - - - - - ");
		System.out.println("Head:");
		System.out.println(myLL.head.data);
		System.out.println("Tail:");
		System.out.println(myLL.tail.data);


	}

}