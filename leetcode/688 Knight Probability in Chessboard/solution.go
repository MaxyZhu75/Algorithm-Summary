var directions = []struct{ x, y int }{{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}}; // 国际象棋骑士八种走法！！！

func knightProbability(n int, k int, row int, column int) float64 { // 创建三维DP表解决（可空间优化）！！！
    d := make([][][]float64, n) // d[step][i][j]表示骑士从棋盘上的(i, j)出发，走了step步时仍然留在棋盘上的概率！！！
    for i, _ := range d {
        d[i] = make([][]float64, n) 
        for j:=0; j<n; j++ {
            d[i][j] = make([]float64, k+1) // Go语言创建三维数组！！！
        }
    }

    for i:=0; i<n; i++ {
        for j:=0; j<n; j++ {
            d[i][j][0] = 1 // basecase：初始位置在在棋盘上且不移动，则概率必为1！！！
        }
    }

    for step:=1; step<=k; step++ { // 三重循环填dp表！！
        for i:=0; i<n; i++ {
            for j:=0; j<n; j++ {
                for _, direction := range directions { // 要点：对8个方向概率进行统计！！！
                    nextRow, nextColum := i+direction.x, j+direction.y    
                    if nextRow < 0 || nextRow >= n || nextColum < 0 || nextColum >= n { // case1：下一步走出界，则停留在棋盘上概率为0，不进行统计！！！
                        continue
                    }
                    
                    d[i][j][step] += d[nextRow][nextColum][step-1]/8 // case2：下一步停留在棋盘上，往该方向走的概率为1/8，且与再下一步仍留在棋盘上相互独立，所统计的概率应为二者乘积！！！
                }
            }
        }
    }

    return d[row][column][k];
}