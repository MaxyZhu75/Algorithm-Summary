var directions = []struct{ x, y int }{{-1, 0}, {1, 0}, {0, -1}, {0, 1}} // Golang中方向集合的写法！！！
var m int
var n int

func numEnclaves(grid [][]int) int { // 多源点DFS解决！！
    m, n = len(grid), len(grid[0])
    visited := make([][]bool, m) // 边界的岛屿必然不是enclave，故我们可以从边界上的各个岛屿为源点开始向连通的内陆访问，然后对访问过的做visited标记！！！
    for i, _ := range visited { // Golang创建二维数组写法！！！
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

    var enclaves int = 0 // 遍历，对没有被访问过内陆计数即可！！！
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

    visited[row][colum] = true // 仅对visited标记！！！

    for _, direction := range directions {
        nextRow := row + direction.x
        nextColum := colum + direction.y
        dfs(grid, nextRow, nextColum, visited)
    }
}