/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

var result []int

func postorder(root *Node) []int { // ���������ݹ飨����������Java�𰸣�������
    result = []int{}
    postorderTraversal(root)
    return result
}

func postorderTraversal(root *Node) { // Ҫ�㣺�ݹ鷽����Ҫд�����������ڸ��������еݹ飡����
    if root == nil {
        return // ���ҳ��ڣ�����
    }
    for _, child := range root.Children {
        postorderTraversal(child)
    }
    result = append(result, root.Val)
}