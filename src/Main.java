
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		System.out.println(MatrixSearch(arr,5)[0]);
		System.out.println(MatrixSearch(arr,5)[1]);
		
		
		
	}
	public static int[] MatrixSearch(int[][] arr, int key){
		int totalLength = arr[1].length * arr.length -1;
		int currentMax = totalLength;
		int currentMin = 0;
		int[] index = new int[] {-1,-1};
		int currentPos = (currentMax + currentMin)/2;
		
		
		if(key > arr[2][3] || key < arr[0][0])
		{
			return index;
		}
		//run until gap between max and min is 1
		while(true)
		{
			//if match found
			if(arr[currentPos/3][currentPos%4] == key)
			{
				//set index values
				index[0] = currentPos/3;
				index[1] = currentPos%4;
				return index;
			}
			//no match found
			else
			{
				//if current middle is bigger than searching for
				if(arr[currentPos/3][currentPos %4 ] > key)
				{
					currentMax = currentPos;
				}
				//if current middle is smaller than searching for
				else
				{
					currentMin = currentPos;
				}
			}
			//change middle new middle
			currentPos = (currentMax+currentMin)/2;
			if(currentMax - currentMin == 1)
			{
				break;
			}
		}
		return index;
	}
	

}
