/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func flatten(root *TreeNode)  { // 方法二：寻找前驱节点（常数空间复杂度）！！！
    current := root
    for current != nil {
        if current.Left != nil { // 如果左子树不为空，则找左子树中最右边的节点最为前驱节点！！！
            next := current.Left // 存储原始左子树的根！！！
            predecessor := next
            for predecessor.Right != nil {
                predecessor = predecessor.Right
            }
            predecessor.Right = current.Right // 将前驱节点右指针连接到原始右子树的根！！！
            current.Left, current.Right = nil, next // 将整个左子树移到当前节点右边，左子树设为空！！！
        }
        current = current.Right // 下移处理右子树！！！
    }
}