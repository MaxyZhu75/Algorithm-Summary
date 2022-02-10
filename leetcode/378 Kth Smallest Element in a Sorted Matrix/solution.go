func kthSmallest(matrix [][]int, k int) int { // 该题与LeetCode240题同属于Z字型查找；本题同时利用二分查找思想！！！
    n := len(matrix)
    low, high := matrix[0][0], matrix[n-1][n-1]
    notLargerThan := 0
    for (low < high) {
        mid := low + (high-low)/2
        notLargerThan = zigZagSearch(matrix, mid);
        if notLargerThan < k { // case1：因为notLargerThan记录的是所有元素值小于等于mid的元素个数（包括所有值为mid的元素），故当该记录小于k个时，第k小的值必然大于mid！！！
           low = mid + 1 
        } else {
            high = mid // case2：mid可能是第k小！！！
        }
    }
    return low
}

func zigZagSearch(matrix [][]int, mid int) int {
    row, colum := len(matrix)-1, 0 // Z字型查找时左下角为起点！！！
    count := 0
    for (row >=0 && colum <= len(matrix)-1) { // 越界才退出，矩阵中值为mid的元素可能有多个，要全盘扫描！！！
        if matrix[row][colum] <= mid { // 右移时，当前元素及其所在列上方元素必然小于等于mid！！！
            colum++
            count += row+1 // 注意：记录的是小于等于mid的个数，而不是严格小于mid！！！
        } else {
            row--
        }
    }
    return count;
}