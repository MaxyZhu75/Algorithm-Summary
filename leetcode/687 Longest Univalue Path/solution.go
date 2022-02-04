/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func longestUnivaluePath(root *TreeNode) int { // ��LeetCode543��ݹ�ṹ���ƣ�����
    if root == nil {
        return 0
    }

	// ˼·������Ҫ��ıؾ���ǰroot�ڵ���·������root���������·����������ɣ�����
    passRoot := longestOnesideFromRoot(root.Left, root.Val) + longestOnesideFromRoot(root.Right, root.Val)
	
	// �·����һ������ԭ���ĸ��ڵ㣬����Ҫ�������µݹ飡����
    result := triMax(passRoot, longestUnivaluePath(root.Left), longestUnivaluePath(root.Right))
    
    return result
}

func longestOnesideFromRoot(current *TreeNode, fatherVal int) int { // ע��·�����ֲܷ棬���㵥���·��������dfsȡ�������
    if current == nil || current.Val != fatherVal { // Ҫ��һ���Ѹ��ڵ��ֵ����ø�������������������������࣡����
        return 0
    }

    leftSide, rightSide := 0, 0

    if current.Left != nil {
        leftSide = longestOnesideFromRoot(current.Left, current.Val)
    }

    if current.Right != nil {
        rightSide = longestOnesideFromRoot(current.Right, current.Val)
    }

    path := twoMax(leftSide, rightSide) + 1 // Ҫ�������ǰ�ڵ��븸�ڵ�ֵ��ȳ��ȼ�1������·�����ֲܷ棬�˴�������������߷ֿ��ݹ�����ȡ���ߵ�����뵱ǰ�ڵ����ӣ�����

    return path
} 

func twoMax(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}

func triMax(a int, b int, c int) int {
    if a>=b && a>=c {
        return a
    } else if b>=a && b>=c {
        return b
    } else {
        return c
    }
}
