func minPathSum(grid [][]int) int {
    m, n := len(grid), len(grid[0]) // ����������������
    
    d := make([][]int, m) // Go���Դ�����άdp��ķ�ʽ����Ҫ��ס������
    for i:=0; i<m; i++ {
        d[i] = make([]int, n)
    }

    d[0][0] = grid[0][0] // basecase������
    for i:=1; i<m; i++ { // ����������dp��Ĵ�С��ԭ������ͬʱ�߼�������������ı߽���Ҫ����basecase������������ѭ��Ϊ�߽縳ֵ������
        d[i][0] = d[i-1][0] + grid[i][0]
    }
    for j:=1; j<n; j++ {
        d[0][j] = d[0][j-1] + grid[0][j]
    }

    for i:=1; i<m; i++ { // dp��������ɣ�����
        for j:=1; j<n; j++ {
            d[i][j] = min(d[i-1][j], d[i][j-1]) + grid[i][j] 
        }
    }

    return d[m-1][n-1]
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}