func findKthNumber(n int, k int) int {
    root := 1 // 由于题目返回的是[1, n]中字典序第k小的数字，则必先处理根节点为 1 的字典树！！！
    k--
    for k > 0 {
        count := countNodes(root, n) 
        if count <= k { // case1：该字典树下的节点需要全部跳过；此时字典树root在同层节点中，由1到9向右横向移动！！！
            k -= count
            root++
        } else { // case2：该字典树下包含所求的第k小节点；此时字典树root以[1, 9]中的某一个数为起点，通过乘10纵向向下移动！！！
            k--
            root *= 10
        }
    }
    return root
}

func countNodes(root int, n int) int { // 计算当前字典树下节点数量（注意所统计个数并不包括root）！！！
    count := 0
    firstChild, lastChild := root, root
    for firstChild <= n { // 按以下方式展开，则所有小于n的数都是当前字典树下的节点！！！
        count += (min(lastChild, n) - firstChild + 1) // 使用min()来防止统计超过n的节点！！！
        firstChild, lastChild = firstChild*10, lastChild*10 + 9 // 展开下一层子节点（共10个）！！！
    }
    return count
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}