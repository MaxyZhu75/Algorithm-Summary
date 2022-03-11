/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func trimBST(root *TreeNode, low int, high int) *TreeNode { // �ݹ飬ע��BST���ʣ�����
    if root == nil { // ���ҳ��ڣ�����
        return nil
    }
    if root.Val < low { // case1��root��lowС������root����������С��root����root������������ȫ��������Ȼ������޼�������������
        return trimBST(root.Right, low, high)
    } else if root.Val > high { // case2��root��highС������root���������Դ���root����root������������ȫ��������Ȼ������޼�����������
        return trimBST(root.Left, low, high)
    } else {
        root.Left = trimBST(root.Left, low, high) // case3��root�ڷ�Χ�ڣ���root����BST�У�������������Ӧͬ������BST���ʣ���˼����������޼�������
        root.Right = trimBST(root.Right, low, high)
    }
    return root
}