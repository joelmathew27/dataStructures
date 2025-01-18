package BinaryMaze;

import java.util.*;

class BinaryMaze {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int shortestPath(int[][] maze, int[] src, int[] dst) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(src);
        visited[src[0]][src[1]] = true;
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 1 && !visited[x][y]) {
                        if (x == dst[0] && y == dst[1]) {
                            return dist;
                        }
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt(), c = scanner.nextInt(), t = scanner.nextInt();
        while (t-- > 0) {
            int[][] maze = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            int[] src = {scanner.nextInt(), scanner.nextInt()};
            int[] dst = {scanner.nextInt(), scanner.nextInt()};
            int dist = shortestPath(maze, src, dst);
            System.out.println(dist);
        }
    }
}
