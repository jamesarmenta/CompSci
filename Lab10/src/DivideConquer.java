public class DivideConquer 
{
	public static int INVALID = -1;
	
	public static void main(String args[])
	{
		int[] list = {1, 2, 3, 4, 5, 6, 7, 8};
		
		rearrange(list);
		
		for(int i = 0; i < list.length; i++)
		{
			System.out.print(list[i] + " ");
		}
	}
	
	public static int[] rearrange(int list[])
	{
		rearrange(list, 0, list.length);
		
		return list;
	}
	
	public static int[] rearrange(int list[], int startIdx, int endIdx)
	{
	
		// base case(s)
		if (startIdx == endIdx) // sublist is of size 1
		{
			if (list[startIdx] < 0)
				return list;
			else
				return list;
		}

		// recursive step(s)
		// divide
		int midIdx = (startIdx + endIdx) / 2;
		rearrange(list, startIdx, midIdx);
		rearrange(list, midIdx+1, endIdx);
		
		
		
		
		
		return list;
	}
	
	
	/////////////////////////////////////////////////////////
	public static int[] rearrange2(int[]list)
	{
		int[] evens = new int[list.length];
		
		for(int i = 0; i < evens.length; i++)
		{
			evens[i] = INVALID;
		}
		
		rearrange2(list, evens, 0, 0);
		return list;
	}
	
	public static int[] rearrange2(int[] list, int[] evens, int i, int t)
	{
		if (i == list.length)//base case
		{
			return list;
		}
		else 
		{
			if (list[i]%2 == 0)
			{
				evens[evens.length-t-1] = list[i];
				t++;
				i++;
				rearrange2(list, evens, i, t);
			}
			else
			{
				i++;
				rearrange2(list, evens, i, t);
			}
		}
		
		for(int idx = 0; idx < list.length; idx++)
		{
			if(evens[idx] == INVALID)
			{
				
			}
		}
		
		return list;
	}
}