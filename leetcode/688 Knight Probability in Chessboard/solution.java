class Solution {
    int[][] directions = new int[][]{{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}}; // 国际象棋骑士八种走法！！！
    
    public double knightProbability(int n, int k, int row, int column) { // 创建三维DP表解决（可空间优化）！！！
        double[][][] d = new double[n][n][k+1]; // d[step][i][j]表示骑士从棋盘上的(i, j)出发，走了step步时仍然留在棋盘上的概率！！！
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j][0] = 1; // basecase：初始位置在在棋盘上且不移动，则概率必为1！！！
            }
        }

        for (int step=1; step<=k; step++) { // 三重循环填dp表！！！
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    for (int[] direction : directions) { // 要点：对8个方向概率进行统计！！！
                        int nextRow = i + direction[0];
                        int nextColum = j + direction[1];
                        if (nextRow < 0 || nextRow >= n || nextColum < 0 || nextColum >= n) { // case1：下一步走出界，则停留在棋盘上概率为0，不进行统计！！！
                            continue;
                        }

                        d[i][j][step] += d[nextRow][nextColum][step-1]/8; // case2：下一步停留在棋盘上，往该方向走的概率为1/8，且与再下一步仍留在棋盘上相互独立，所统计的概率应为二者乘积！！！
                    }
                }
            }
        }
    
    return d[row][column][k];
    }
}