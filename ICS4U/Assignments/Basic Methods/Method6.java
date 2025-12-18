// Method6.java
// James
// A recursive method that will navigate a given 8x8 2D grid, and find the path from
// [0][0] to [7][7] with the minimum sum of numbers on the squares it passed through

class Method6 {

    public static void main(String[] owo) {
        int [][]grid = {
            { 0,21,20, 5,25,25,35,15},
            {12,26,43,29,15,26,15,12},
            { 7,18,23,28,36,32,12,18},
            {43,34,35,18,25,18,21,25},
            {32,41,23, 9,21,17,24,14},
            {12, 9,20,42, 9,19,26,22},
            {30,17,17,35,14,25,14,21},
            {15,21,37,24,19,15,35,15}
        };

        dfs(0, 0, grid[0][0], "", grid);
        System.out.println(min_dist);
        System.out.println(best_path);
    }

    public static int min_dist = Integer.MAX_VALUE;
    public static String best_path = "";

    static void dfs( int x, int y, int dist, String cur_path, int[][] grid ) {
        // we went out of bounds, go back
        if (x >= grid.length || y >= grid[0].length) return;
        // add the current square's value to the dist count
        dist += grid[x][y];
        // reached the end, this is the base case
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            // comparing with the current best path to see if it's better
            if (dist < min_dist) {
                Method6.min_dist = dist;
                Method6.best_path = cur_path;
            }
        }

        // recursively search the next down and right squares
        dfs(x + 1, y, dist, cur_path + "R", grid);
        dfs(x, y + 1, dist, cur_path + "D", grid);
    }
}
