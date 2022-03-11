/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

var result []int

func preorder(root *Node) []int { // 方法二：递归（迭代方法见Java答案）！！！
    result = []int{} // 前序遍历：根左右！！！
    preorderTraversal(root)
    return result
}

func preorderTraversal(root *Node) { // 要点：递归方法需要写辅助函数，在辅助函数中递归！！！
    if root == nil {
        return
    }
    result = append(result, root.Val)
    for _, child := range root.Children {
        preorderTraversal(child)
    }
}