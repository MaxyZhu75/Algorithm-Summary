/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
    if root == nil { // 题目所给子树不为空！！！
        return false
    }
    
    result := false
    startFromRoot := isSubtreeFromRoot(root, subRoot)
    result = startFromRoot || isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot) // recursion！！！
    return result
}

func isSubtreeFromRoot(root *TreeNode, subRoot *TreeNode) bool { // 必须从当前根节点出发，检测是否是子树！！！
    if root == nil && subRoot == nil{ // case1：都为空！！！
        return true
    }

    if root == nil || subRoot == nil { // case2：其中一个为空！！！
        return false
    }

    result := false
    if root.Val != subRoot.Val { // case3：都不为空，比较值的大小！！！
        return false
    } else {
        result = isSubtreeFromRoot(root.Left, subRoot.Left) && isSubtreeFromRoot(root.Right, subRoot.Right)
    }
    return result
}