class Solution {
    int[][] directions = new int[][]{{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}}; // ����������ʿ�����߷�������
    
    public double knightProbability(int n, int k, int row, int column) { // ������άDP�������ɿռ��Ż���������
        double[][][] d = new double[n][n][k+1]; // d[step][i][j]��ʾ��ʿ�������ϵ�(i, j)����������step��ʱ��Ȼ���������ϵĸ��ʣ�����
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j][0] = 1; // basecase����ʼλ�������������Ҳ��ƶ�������ʱ�Ϊ1������
            }
        }

        for (int step=1; step<=k; step++) { // ����ѭ����dp������
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    for (int[] direction : directions) { // Ҫ�㣺��8��������ʽ���ͳ�ƣ�����
                        int nextRow = i + direction[0];
                        int nextColum = j + direction[1];
                        if (nextRow < 0 || nextRow >= n || nextColum < 0 || nextColum >= n) { // case1����һ���߳��磬��ͣ���������ϸ���Ϊ0��������ͳ�ƣ�����
                            continue;
                        }

                        d[i][j][step] += d[nextRow][nextColum][step-1]/8; // case2����һ��ͣ���������ϣ����÷����ߵĸ���Ϊ1/8����������һ���������������໥��������ͳ�Ƶĸ���ӦΪ���߳˻�������
                    }
                }
            }
        }
    
    return d[row][column][k];
    }
}