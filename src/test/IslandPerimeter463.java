package test;

public class IslandPerimeter463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0)
        	return 0;
        int n = grid[0].length;
        int perimeter = 0;
        int i, j;
        for (i = 0; i < m; i++) {
        	for (j = 0; j < n; j++) {
        		if (grid[i][j] == 0) {
        			if (i - 1 >= 0)
        				perimeter += grid[i - 1][j];
        			if (i + 1 < m)
        				perimeter += grid[i + 1][j];
        			if (j - 1 >= 0)
        				perimeter += grid[i][j - 1];
        			if (j + 1 < n)
        				perimeter += grid[i][j + 1];
        		}
        	}
        }
        i = 0;
        for (j = 0; j < n; j++)
        	perimeter += grid[i][j];
        i = m - 1;
        for (j = 0; j < n; j++)
        	perimeter += grid[i][j];
        j = 0;
        for (i = 0; i < m; i++)
        	perimeter += grid[i][j];
        j = n - 1;
        for (i = 0; i < m; i++)
        	perimeter += grid[i][j];
        return perimeter;
    }
}
