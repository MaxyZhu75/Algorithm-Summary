var directions = []struct{ x, y int }{{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}}; // ����������ʿ�����߷�������

func knightProbability(n int, k int, row int, column int) float64 { // ������άDP�������ɿռ��Ż���������
    d := make([][][]float64, n) // d[step][i][j]��ʾ��ʿ�������ϵ�(i, j)����������step��ʱ��Ȼ���������ϵĸ��ʣ�����
    for i, _ := range d {
        d[i] = make([][]float64, n) 
        for j:=0; j<n; j++ {
            d[i][j] = make([]float64, k+1) // Go���Դ�����ά���飡����
        }
    }

    for i:=0; i<n; i++ {
        for j:=0; j<n; j++ {
            d[i][j][0] = 1 // basecase����ʼλ�������������Ҳ��ƶ�������ʱ�Ϊ1������
        }
    }

    for step:=1; step<=k; step++ { // ����ѭ����dp����
        for i:=0; i<n; i++ {
            for j:=0; j<n; j++ {
                for _, direction := range directions { // Ҫ�㣺��8��������ʽ���ͳ�ƣ�����
                    nextRow, nextColum := i+direction.x, j+direction.y    
                    if nextRow < 0 || nextRow >= n || nextColum < 0 || nextColum >= n { // case1����һ���߳��磬��ͣ���������ϸ���Ϊ0��������ͳ�ƣ�����
                        continue
                    }
                    
                    d[i][j][step] += d[nextRow][nextColum][step-1]/8 // case2����һ��ͣ���������ϣ����÷����ߵĸ���Ϊ1/8����������һ���������������໥��������ͳ�Ƶĸ���ӦΪ���߳˻�������
                }
            }
        }
    }

    return d[row][column][k];
}