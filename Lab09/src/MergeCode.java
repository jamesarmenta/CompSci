
public class MergeCode {

	public static void main(String[] args) {
		int list[] = {100, 90, 30, 40, 50, 6, 15, 45, 3, 9, 7 };
		
		merge(list, 2, 4, 7);

		for (int i=0; i<list.length; i++){
			System.out.print(list[i] + " ");
		}
	}

	public static int[] merge(int list[], int start, int mid, int end)
	{
		int curr1 = start;
		int curr2 = mid+1;
		int temp;

		while (curr1 <= mid && curr2 <= end)
		{
			if (list[curr1] > list[curr2])
			{
				temp = list[curr1];
				list[curr1] = list[curr2];
				curr2++;
				
				
			}
			else
			{
				curr1++;
			}
		}
		
		return list;
	}
}