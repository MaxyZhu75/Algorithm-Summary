/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
    if root == nil { // ��Ŀ����������Ϊ�գ�����
        return false
    }
    
    result := false
    startFromRoot := isSubtreeFromRoot(root, subRoot)
    result = startFromRoot || isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot) // recursion������
    return result
}

func isSubtreeFromRoot(root *TreeNode, subRoot *TreeNode) bool { // ����ӵ�ǰ���ڵ����������Ƿ�������������
    if root == nil && subRoot == nil{ // case1����Ϊ�գ�����
        return true
    }

    if root == nil || subRoot == nil { // case2������һ��Ϊ�գ�����
        return false
    }

    result := false
    if root.Val != subRoot.Val { // case3������Ϊ�գ��Ƚ�ֵ�Ĵ�С������
        return false
    } else {
        result = isSubtreeFromRoot(root.Left, subRoot.Left) && isSubtreeFromRoot(root.Right, subRoot.Right)
    }
    return result
}