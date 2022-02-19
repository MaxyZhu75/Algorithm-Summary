var directions = []struct{ x, y int }{{-1, 0}, {1, 0}, {0, -1}, {0, 1}} // Golang�з��򼯺ϵ�д��������
var m int
var n int

func numEnclaves(grid [][]int) int { // ��Դ��DFS�������
    m, n = len(grid), len(grid[0])
    visited := make([][]bool, m) // �߽�ĵ����Ȼ����enclave�������ǿ��Դӱ߽��ϵĸ�������ΪԴ�㿪ʼ����ͨ����½���ʣ�Ȼ��Է��ʹ�����visited��ǣ�����
    for i, _ := range visited { // Golang������ά����д��������
        visited[i] = make([]bool, n)
    }

    for i:=0; i<m; i++ {
        dfs(grid, i, 0, visited)
        dfs(grid, i, n-1, visited)
    }

    for j:=0; j<n; j++ {
        dfs(grid, 0, j, visited)
        dfs(grid, m-1, j, visited)
    }

    var enclaves int = 0 // ��������û�б����ʹ���½�������ɣ�����
    for i:=0; i<m; i++ {
        for j :=0; j<n; j++ {
            if grid[i][j] == 1 && !visited[i][j] {
                enclaves++
            }
        }
    }

    return enclaves
}

func dfs(grid [][]int, row int, colum int, visited [][]bool) {
    if row >= m || row < 0 || colum >= n || colum < 0 {
        return
    }

    if grid[row][colum] == 0 {
        return
    }

    if visited[row][colum] {
        return
    }

    visited[row][colum] = true // ����visited��ǣ�����

    for _, direction := range directions {
        nextRow := row + direction.x
        nextColum := colum + direction.y
        dfs(grid, nextRow, nextColum, visited)
    }
}