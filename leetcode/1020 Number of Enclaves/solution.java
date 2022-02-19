class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean visited[][];
    int grid[][]; // ֻ��visited����ǣ�gridδ�޸ģ�������ɼ����ڴ�ռ�ã�����
    int m, n;

    public int numEnclaves(int[][] grid) { // ��Դ��DFS���������
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        visited = new boolean[m][n]; // �߽�ĵ����Ȼ����enclave�������ǿ��Դӱ߽��ϵĸ�������ΪԴ�㿪ʼ����ͨ����½���ʣ�Ȼ��Է��ʹ�����visited��ǣ�����
        for (int i=0; i<m; i++) {
            dfs(i, 0);
            dfs(i, n-1);
        }

        for (int j=0; j<n; j++) {
            dfs(0, j);
            dfs(m-1, j);
        }

        int enclaves = 0; // ��������û�б����ʹ���½�������ɣ�����
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        
        return enclaves;
    }

    public void dfs(int row, int colum) {
        if (row < 0 || row >= m || colum < 0 || colum >=n) {
            return;
        }

        if (grid[row][colum] == 0) {
            return;
        }

        if (visited[row][colum]) {
            return;
        }

        visited[row][colum] = true; // ����visited��ǣ�����

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextColum = colum + direction[1];
            dfs(nextRow, nextColum);
        }
    }
}