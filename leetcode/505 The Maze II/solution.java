public class Solution { // 只对靠墙处进行DFS变形；见LeetCode第490题！！！
    int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    int[][] maze;
	int[] destination;
	int[][] distances;

	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
		this.destination = destination;
		this.distances = new int[maze.length][maze[0].length];
        for (int[] row: distances) {
            Arrays.fill(row, Integer.MAX_VALUE); // 记录从起始位置到该处的最小步数！！！
        }
		distances[start[0]][start[1]] = 0;
        dfs(start);
		int result = -1;
		if (distances[destination[0]][destination[1]] != Integer.MAX_VALUE) {
			result = distances[destination[0]][destination[1]];
		}
        return result;
    }

    public void dfs(int[] start) { // 与常规DFS不同，本题不是由visited记录访问情况，而是根据distances判断是否需要继续递归！！！
        for (int[] direction: directions) {
            int nextRow = start[0] + direction[0];
            int nextColum = start[1] + direction[1];
            int steps = 0;
            while (nextRow >= 0 && nextColum >= 0 && nextRow < maze.length && nextColum < maze[0].length && maze[nextRow][nextColum] == 0) {
                nextRow += direction[0];
                nextColum += direction[1];
                steps++;
            }
			nextRow -= direction[0];
			nextColum -= direction[1];
            if (distances[start[0]][start[1]] + steps < distances[nextRow][nextColum]) { // 更新到(nextRow, nextColum)的最短距离，并从该点继续DFS！！！
                distances[nextRow][nextColum] = distances[start[0]][start[1]] + steps;
                dfs(new int[]{nextRow, nextColum});
            }
        }
    }
}