/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func longestUnivaluePath(root *TreeNode) int { // 与LeetCode543题递归结构类似！！！
    if root == nil {
        return 0
    }

	// 思路：符合要求的必经当前root节点的最长路径必由root左右两边最长路径合起来组成！！！
    passRoot := longestOnesideFromRoot(root.Left, root.Val) + longestOnesideFromRoot(root.Right, root.Val)
	
	// 最长路径不一定过树原本的跟节点，还需要继续往下递归！！！
    result := triMax(passRoot, longestUnivaluePath(root.Left), longestUnivaluePath(root.Right))
    
    return result
}

func longestOnesideFromRoot(current *TreeNode, fatherVal int) int { // 注意路径不能分叉，计算单边最长路径类似于dfs取最深！！！
    if current == nil || current.Val != fatherVal { // 要点一：把父节点的值传入该辅助方法，则主方法会减少冗余！！！
        return 0
    }

    leftSide, rightSide := 0, 0

    if current.Left != nil {
        leftSide = longestOnesideFromRoot(current.Left, current.Val)
    }

    if current.Right != nil {
        rightSide = longestOnesideFromRoot(current.Right, current.Val)
    }

    path := twoMax(leftSide, rightSide) + 1 // 要点二：当前节点与父节点值相等长度加1；由于路径不能分叉，此处必须从左右两边分开递归计算后取单边的最大与当前节点连接！！！

    return path
} 

func twoMax(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}

func triMax(a int, b int, c int) int {
    if a>=b && a>=c {
        return a
    } else if b>=a && b>=c {
        return b
    } else {
        return c
    }
}
