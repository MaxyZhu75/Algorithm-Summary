/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    if root == nil { // ���ұ߽磡����
        return true
    }
    if abs(treeHeight(root.Left) - treeHeight(root.Right)) > 1 { // ��balance�Ķ���д��������
        return false
    }
    balance := isBalanced(root.Left) && isBalanced(root.Right) // �Զ�����recursion��������ڸ��Ž�Ϊ�Ե����ϣ�����
    return balance
}

func treeHeight(root *TreeNode) int { // �������ĸ߶ȣ�����
    if root == nil {
        return 0
    }
    height := max(treeHeight(root.Left), treeHeight(root.Right)) + 1
    return height
}

func max(a int, b int) int { // Go�������ֶ�дint�����ֵ����������math.Max��Ҫ����float64������
    if (a > b) {
        return a
    } else {
        return b
    }
}

func abs (a int) int { // Go�������ֶ�дint�;���ֵ����������math.Abs��Ҫ����float64������
    if a < 0 {
        return -1 * a
    } else {
        return a
    }
}