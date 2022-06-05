public class Solution { // 只对靠墙处进行DFS！！！
    int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    int[][] maze;
	int[] destination;
	boolean[][] visited;
    boolean result;
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
		this.destination = destination;
		this.visited = new boolean[maze.length][maze[0].length];
        dfs(start);
        return result;
    }
	
    public void dfs(int[] start) {
        if (start[0] == destination[0] && start[1] == destination[1]) { // 到达终点！！！
            result = true;
            return;
        }
        if (visited[start[0]][start[1]] == true) return; // 已访问过的靠墙点不需要再去一趟！！！

        visited[start[0]][start[1]] = true; // 标记已访问！！！

        for (int[] direction: directions) { // 往四个方向的靠墙点遍历！！！
            int nextRow = start[0] + direction[0];
            int nextColum = start[1] + direction[1];
            while (nextRow >= 0 && nextColum >= 0 && nextRow < maze.length && nextColum < maze[0].length && maze[nextRow][nextColum] == 0) {
                nextRow += direction[0];
                nextColum += direction[1];
            }
			nextRow -= direction[0];
			nextColum -= direction[1];
            dfs(new int[]{nextRow, nextColum});
        }
    }
}