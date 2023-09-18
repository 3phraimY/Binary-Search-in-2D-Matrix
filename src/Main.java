public class Main {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(MatrixSearch(arr, 12)[0] + "," + MatrixSearch(arr, 12)[1]);
    }

    // Binary search within ascending int[][]
    // Returns int[] with position in matrix
    
    public static int[] MatrixSearch(int[][] arr, int key)
    {
        // Calculate the total number of elements in the matrix
        int totalLength = (arr[1].length * arr.length) -1;
        // Initialize variables for binary search
        int currentMax = totalLength;
        int currentMin = 0;
        int[] index = new int[] {-1,-1};
        int currentPos = 0;
        // Get the number of rows and columns in the matrix
        int numRows = arr.length;
        int numCols = arr[0].length;

        // Check if the key is outside the bounds of the matrix
        if (key > arr[numRows-1][numCols-1] || key < arr[0][0]) 
        {
            return index;
        }

        // Run binary search
        while (currentMax >= currentMin) 
        {
        	//set center
            currentPos = currentMin + (currentMax - currentMin) / 2;
            
            // If match found, set index values and return
            if (arr[currentPos / numCols][currentPos % numCols] == key) 
            {
                index[0] = currentPos / numCols;
                index[1] = currentPos % numCols;
                return index;
            } 
            //if larger than center
            else if (arr[currentPos / numCols][currentPos % numCols] < key) 
            {
            	//move min up to center
                currentMin = currentPos + 1;
            } 
            //if smaller than center
            else 
            {
            	//move max down to center
                currentMax = currentPos - 1;
            }
        }

        // Return default index values if key is not found
        return index;
    }
}
