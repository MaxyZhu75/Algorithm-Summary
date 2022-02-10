/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rob(root *TreeNode) int { // 注意该题并不是简单的层序遍历求和！！
    result := maxValue(root)
    return max(result[0], result[1])
}

func maxValue(root *TreeNode) []int {
    if root == nil {
        return []int{0, 0}
    }

    leftNode := make([]int, 2) // 小偷对每个节点有两种选择，打劫或不打劫，两种情况的最大值我们都要算出，再去比较！！！
    rightNode := make([]int, 2) // 创建数组，array[0]存储以该节点为根且该节点不被打劫所能得到的最大价值，用array[1]存储以该节点为根且该节点被打劫所能得到的最大价值！！！
    containsRoot := make([]int, 2)

    leftNode, rightNode = maxValue(root.Left), maxValue(root.Right) // 左右子节点先递归定义，再使用！！！
    containsRoot[0] = max(leftNode[0], leftNode[1]) + max(rightNode[0], rightNode[1]) // case1：root不被打劫，则取左右子节点各自递归结果的最大值相加即可！！！
    containsRoot[1] = root.Val + leftNode[0] + rightNode[0] // case2：root被打劫，则取root的值以及左右子节点不被打劫时所能得到的最大价值相加！！！
    
    return containsRoot
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}