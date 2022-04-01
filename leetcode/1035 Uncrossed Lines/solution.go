func maxUncrossedLines(nums1 []int, nums2 []int) int { // Ҫ�㣺����ȼ���LeetCode1143��������������⣡����
    n, m:= len(nums1), len(nums2)
    d := make([][]int, n+1)
    for i:=0; i<=n; i++ {
        d[i] = make([]int, m+1)
    }

    for i:=1; i<=n; i++ {
        for j:=1; j<=m; j++ {
            if nums1[i-1] == nums2[j-1] {
                d[i][j] = d[i-1][j-1] + 1 // case1����λ�������ַ�����ĸƥ�䣡����
            } else {
                d[i][j] = max(d[i][j-1], d[i-1][j]) // case2����λ�������ַ�����ƥ�䣡����
            }
        }
    }
    return d[n][m]
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}