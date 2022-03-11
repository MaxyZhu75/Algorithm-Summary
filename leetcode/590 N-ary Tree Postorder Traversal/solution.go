/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

var result []int

func postorder(root *Node) []int { // 方法二：递归（迭代方法见Java答案）！！！
    result = []int{}
    postorderTraversal(root)
    return result
}

func postorderTraversal(root *Node) { // 要点：递归方法需要写辅助函数，在辅助函数中递归！！！
    if root == nil {
        return // 左右出口！！！
    }
    for _, child := range root.Children {
        postorderTraversal(child)
    }
    result = append(result, root.Val)
}