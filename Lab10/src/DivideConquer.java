public class DivideConquer {
	public static void main(String[] args) 
	{
		int myNums[] = {1, 2, 3, 4, 5, 6, 7, 7 ,7};

		printList(myNums);
	}

	// sIdx is the index of the first element of the sublist
	// eIdx is the index of the last element of the sublist
	public static void divide(int list[], int sIdx, int eIdx)
	{
		// base case
		if (eIdx - sIdx == 0) // sublist is length 1
		{
			return;
		}

		// recursive step(s)
		// which include dividing and conquering

		// we know sublist length is >= 2
		int midIdx = (sIdx + eIdx) / 2; // we know that it is integer div.
		mergeSort(list, sIdx, midIdx);
		mergeSort(list, midIdx+1, eIdx);

		// when we get here, what do we know2 sublists that are sorted
		// amongst themselves
		// Left sublist goes from sIdx to midIdx 
		// Right sublist goes from midIdx+1 to eIdx		
		conquer(list, sIdx, midIdx, eIdx);
	}

	// We can assume that list has a sublist from sIdx to midIdx that is sorted
	// and another sublist from midIdx+1 to eIdx that is also sorted
	//
	// result the sublist from sIdx to eIdx will be sorted
	public static void conquer(int list[], int sIdx, int midIdx, int eIdx)
	{
		int tempList[] = new int[eIdx - sIdx + 1];

		int leftIdx = sIdx;
		int rightIdx = midIdx + 1;
		// i represents the index of where we're putting a value into tempList
		int i=0;
		while (leftIdx <= midIdx && rightIdx <= eIdx)
		{
			if (list[leftIdx] >= list[rightIdx])
			{
				tempList[i] = list[rightIdx];
				rightIdx++;
			}
			else
			{
				tempList[i] = list[leftIdx];
				leftIdx++;
			}
			i++;
		}

		// only one of these two while loop will iterate >0 times
		// copy all the elements still on the left into the temp
		while (leftIdx <= midIdx)
		{
			tempList[i] = list[leftIdx]; 
			i++;
			leftIdx++;
		}

		// copy all the elements still on the right into the temp
		while (rightIdx <= eIdx)
		{
			tempList[i] = list[rightIdx]; 
			i++;
			rightIdx++;
		}

		int listIdx = sIdx;
		// i is good as an index to tempList, but we need something
		// else as the index to list
		for (int j=0; j < tempList.length; j++, listIdx++)
		{
			list[listIdx] = tempList[j];
		}
	}

	public static void printList(int list[])
	{
		for (int i=0; i< list.length; i++)
		{
			System.out.println(list[i]);
		}
	}
}