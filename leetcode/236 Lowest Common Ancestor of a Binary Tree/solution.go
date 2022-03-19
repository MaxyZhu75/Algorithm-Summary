/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var parentRecord map[int]*TreeNode

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode { // 与LeetCode1650题类似，但需使用dfs递归来手动记录每个节点的父节点！！！
    parentRecord = map[int]*TreeNode{}
    parents := map[int]bool{}
    dfs(root)

    for p != nil {
        parents[p.Val] = true
        p = parentRecord[p.Val]
    }

    for q != nil {
        if parents[q.Val] == true {
            return q
        }
        q = parentRecord[q.Val]
    }

    return nil
}

func dfs(root *TreeNode) { // 本题特殊之处在于每个节点的值各不相同，因此可以直接通过value来区别节点！！！
    if root == nil {
        return
    }
    if root.Left != nil {
        parentRecord[root.Left.Val] = root
        dfs(root.Left)
    }
    if root.Right != nil {
        parentRecord[root.Right.Val] = root
        dfs(root.Right)
    }
}