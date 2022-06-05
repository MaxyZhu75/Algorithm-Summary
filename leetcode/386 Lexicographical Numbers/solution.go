func lexicalOrder(n int) []int { // 迭代解法；见LeetCode第440题；该题为字典树遍历！！！
    result := make([]int, n)
    root := 1
    for i:=0; i<n; i++ {
        result[i] = root // 每次循环先往result添加节点！！！
        if root*10 <= n { // case1：以root为起点，通过乘10纵向向下移动！！！
            root *= 10
        } else { // case2：root在同层节点中，由1到9向右横向移动！！！
            for root%10 == 9 || root+1 > n { // 若同层末尾节点遍历结束，则除10退回上一层！！！
                root /= 10
            }
            root++
        }
    }
    return result
}