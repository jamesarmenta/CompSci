
public class PriorityQueue 
{
	private Queue pQ[];
	private int size; // number of elements in the priority q
	private int priorityOfHighestItem;
	
	public PriorityQueue(int numberOfPriorities)
	{
		pQ = new Queue[numberOfPriorities+1];
		for (int i=0; i< pQ.length; i++)
		{
			pQ[i] = new Queue();
		}
		size = 0;
		priorityOfHighestItem = -1;
	}
	
	public void enqueue(String strToAdd, int priority)
	{
		if (priority > pQ.length - 1)
		{
			priority = pQ.length - 1;
		}
		size++;

		// we definitely want to add strToAdd to the appropriate place in pq
		pQ[priority].enqueue(strToAdd);

		// we do want to possibly update priorityOfHighestItem
		if (priority > priorityOfHighestItem)
		{
			priorityOfHighestItem = priority;
		}
		
	}
	
	public String dequeue()
	{
		if (isEmpty())
		{
			System.out.println("Queue is empty.");
			return null;
		}
		
		// should return the String with the highest priority in pq
		// and if there are multiple of this highest priority, we want
		// to return the one that came in earliest
		String strToReturn;

		strToReturn = pQ[priorityOfHighestItem].dequeue();
		size--;
		
		if (pQ[priorityOfHighestItem].isEmpty())//if we just emptied the current Queue
		{
			updatePriority(); //update highest priority
		}
		
		System.out.println(strToReturn);
		return strToReturn;
	}
	
	public boolean isEmpty()
	{
		return size == 0; // if empty, we also expect priorityOfHighestItem == -1
	}
	
	private void updatePriority()
	{
		for (int i=priorityOfHighestItem-1; i >= 0; i--)
		{
			if (!pQ[i].isEmpty())//if Queue is not empty
			{
				priorityOfHighestItem = i;
				break;
			}
		}
		
	}
}