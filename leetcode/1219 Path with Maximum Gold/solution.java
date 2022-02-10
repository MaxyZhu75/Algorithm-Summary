class Solution { // ��ά�����е�DFS���ݣ�����
    int[][] grid;
    int m, n;
    int maxValue = 0;
    int[][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}}; // Ҫ��һ���ɽ������������ǰ����������

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length; // �������ֵ������
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] != 0) {
                    dfsBackTrack(i, j, 0);
                }
            }
        }

        return maxValue;
    }

    public void dfsBackTrack(int row, int colum, int currentValue) { // �޷���ֵ��ֱ�ӶԶ���Ľ����������������
        if (row < 0 || row >= m || colum < 0 || colum >= n) {
            return;
        }
        
        if (grid[row][colum] == 0) {
            return;
        }

        currentValue += grid[row][colum]; // ��ǰdfs�ݹ���������
        maxValue = Math.max(maxValue, currentValue); // �ж��Ƿ�������ս��������

        int valueRecord = grid[row][colum]; // Ҫ�����DFS�ƶ������а���������Ҫ�����裬�ұ��밴˳��ִ�У�����
        grid[row][colum] = 0; // ����һ������ѷ��ʣ�����

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextColum = colum + direction[1];
            dfsBackTrack(nextRow, nextColum, currentValue); // �������dfs���µݹ飡����
        }

        grid[row][colum] = valueRecord; // �����������δ���ʣ�����
    }
}