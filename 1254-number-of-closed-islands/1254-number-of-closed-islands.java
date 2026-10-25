public class Solution {

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int closedIslandsCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Start DFS whenever unvisited land (0) is found
                if (grid[r][c] == 0) {
                    if (dfs(grid, r, c, rows, cols)) {
                        closedIslandsCount++;
                    }
                }
            }
        }

        return closedIslandsCount;
    }

    private boolean dfs(int[][] grid, int r, int c, int rows, int cols) {
        // Out of bounds check
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }

        // If it's water (1), it contributes to closing the island
        if (grid[r][c] == 1) {
            return true;
        }

        // Mark the land cell as visited by setting it to water (1)
        grid[r][c] = 1;

        // Check boundary condition: if current cell is on the grid edge, island cannot be closed
        boolean isClosed = true;
        if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
            isClosed = false;
        }

        // Explore all 4 adjacent directions
        boolean left  = dfs(grid, r, c - 1, rows, cols);
        boolean right = dfs(grid, r, c + 1, rows, cols);
        boolean up    = dfs(grid, r - 1, c, rows, cols);
        boolean down  = dfs(grid, r + 1, c, rows, cols);

        // Island must be closed in ALL four directions and not touch boundary
        return isClosed && left && right && up && down;
    }
}