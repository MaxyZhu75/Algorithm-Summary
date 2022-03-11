/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

var result []int

func preorder(root *Node) []int { // ���������ݹ飨����������Java�𰸣�������
    result = []int{} // ǰ������������ң�����
    preorderTraversal(root)
    return result
}

func preorderTraversal(root *Node) { // Ҫ�㣺�ݹ鷽����Ҫд�����������ڸ��������еݹ飡����
    if root == nil {
        return
    }
    result = append(result, root.Val)
    for _, child := range root.Children {
        preorderTraversal(child)
    }
}