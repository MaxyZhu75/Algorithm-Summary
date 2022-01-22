/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func diameterOfBinaryTree(root *TreeNode) int {
    if root == nil {  // ���ұ߽磡����
        return 0
    }
    current := treeHeight(root.Left) + treeHeight(root.Right)  // ��recursion������diameter����ó�������
    diameter := triMax(current, diameterOfBinaryTree(root.Left), diameterOfBinaryTree(root.Right)) // ����diameter��·����һ����ԭ���ĸ��ڵ㣬�˴���Ҫʹ��recursion���Ƚϲ�ȡ�����ֵ������
    return diameter
}

func treeHeight(root *TreeNode) int { // ���������ĸ߶ȣ�����
    if root == nil {
        return 0
    }
    height := twoMax(treeHeight(root.Left), treeHeight(root.Right)) + 1
    return height
}

func twoMax(a, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}

func triMax(a int, b int, c int) int {  // ��д������ȡ���ֵ������
    if a>=b && a>=c {
        return a
    } else if b >=a && b>=c {
        return b
    } else {
        return c
    }
}