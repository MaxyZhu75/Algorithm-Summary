func findContentChildren(g []int, s []int) int {
    var p1, p2, result int = 0, 0, 0 // 解题思路是排序后使用贪心思想；实现时借助双指针！！！
    sort.Ints(g) // Go语言排序；import "sort"！！！
    sort.Ints(s)
    for (p2 < len(s)) { // 贪心内容:先用最小的饼干满足胃口最小的孩子，从而使被满足的孩子数量最多，正确性可由反证法简单证明！！！
        if p1 > len(g)-1 {
            return len(g)
        }
        if s[p2] >= g[p1] {
            p1++
            p2++
            result++
        } else {
            p2++
        }
    }
    return result
}