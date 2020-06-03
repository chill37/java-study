package pattern;

public class SpiralIndexing {
	static int R = 3; 
	static int C = 6; 

	public static void main(String[] args) {
		
        int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 } }; 
        spiralPrint(R, C, a); 
        System.out.println();
        
        recursiveSpiralPrint(a, 0, 0, R, C);

	}
	
	// Function print matrix in spiral form 
	//  1  2  3  4  5  6
	//  7  8  9 10 11 12
	// 13 14 15 16 17 18
	// --> 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11 
    static void spiralPrint(int m, int n, int a[][]) 
    { 
        int i, k = 0, l = 0; 
        /*  k - starting row index 
        m - ending row index 
        l - starting column index 
        n - ending column index 
        i - iterator 
        */
  
        while (k < m && l < n) { 
            // Print the first row from the remaining rows 
            for (i = l; i < n; ++i) { 
                System.out.print(a[k][i] + " "); 
            } 
            k++; 
  
            // Print the last column from the remaining columns 
            for (i = k; i < m; ++i) { 
                System.out.print(a[i][n - 1] + " "); 
            } 
            n--; 
  
            // Print the last row from the remaining rows */ 
            if (k < m) { 
                for (i = n - 1; i >= l; --i) { 
                    System.out.print(a[m - 1][i] + " "); 
                } 
                m--; 
            } 
  
            // Print the first column from the remaining columns */ 
            if (l < n) { 
                for (i = m - 1; i >= k; --i) { 
                    System.out.print(a[i][l] + " "); 
                } 
                l++; 
            } 
        } 
    }
    
    // Function for printing matrix in spiral 
    // form i, j: Start index of matrix, row  
    // and column respectively m, n: End index 
    // of matrix row and column respectively 
    static void recursiveSpiralPrint(int arr[][], int i, 
                      int j, int m, int n) 
    { 
        // If i or j lies outside the matrix 
        if (i >= m || j >= n) 
        { 
            return; 
        } 
  
        // Print First Row 
        for (int p = i; p < n; p++) 
        { 
            System.out.print(arr[i][p] + " "); 
        } 
  
        // Print Last Column 
        for (int p = i + 1; p < m; p++)  
        { 
            System.out.print(arr[p][n - 1] + " "); 
        } 
  
        // Print Last Row, if Last and 
        // First Row are not same 
        if ((m - 1) != i)  
        { 
            for (int p = n - 2; p >= j; p--)  
            { 
                System.out.print(arr[m - 1][p] + " "); 
            } 
        } 
  
        // Print First Column, if Last and 
        // First Column are not same 
        if ((n - 1) != j)  
        { 
            for (int p = m - 2; p > i; p--)  
            { 
                System.out.print(arr[p][j] + " "); 
            } 
        } 
        recursiveSpiralPrint(arr, i + 1, j + 1, m - 1, n - 1); 
    } 

}
