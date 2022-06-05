public class Solution { // ֻ�Կ�ǽ������DFS���Σ���LeetCode��490�⣡����
    int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    int[][] maze;
	int[] destination;
	int[][] distances;

	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
		this.destination = destination;
		this.distances = new int[maze.length][maze[0].length];
        for (int[] row: distances) {
            Arrays.fill(row, Integer.MAX_VALUE); // ��¼����ʼλ�õ��ô�����С����������
        }
		distances[start[0]][start[1]] = 0;
        dfs(start);
		int result = -1;
		if (distances[destination[0]][destination[1]] != Integer.MAX_VALUE) {
			result = distances[destination[0]][destination[1]];
		}
        return result;
    }

    public void dfs(int[] start) { // �볣��DFS��ͬ�����ⲻ����visited��¼������������Ǹ���distances�ж��Ƿ���Ҫ�����ݹ飡����
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
            if (distances[start[0]][start[1]] + steps < distances[nextRow][nextColum]) { // ���µ�(nextRow, nextColum)����̾��룬���Ӹõ����DFS������
                distances[nextRow][nextColum] = distances[start[0]][start[1]] + steps;
                dfs(new int[]{nextRow, nextColum});
            }
        }
    }
}