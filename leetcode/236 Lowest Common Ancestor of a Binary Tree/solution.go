/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var parentRecord map[int]*TreeNode

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode { // ��LeetCode1650�����ƣ�����ʹ��dfs�ݹ����ֶ���¼ÿ���ڵ�ĸ��ڵ㣡����
    parentRecord = map[int]*TreeNode{}
    parents := map[int]bool{}
    dfs(root)

    for p != nil {
        parents[p.Val] = true
        p = parentRecord[p.Val]
    }

    for q != nil {
        if parents[q.Val] == true {
            return q
        }
        q = parentRecord[q.Val]
    }

    return nil
}

func dfs(root *TreeNode) { // ��������֮������ÿ���ڵ��ֵ������ͬ����˿���ֱ��ͨ��value������ڵ㣡����
    if root == nil {
        return
    }
    if root.Left != nil {
        parentRecord[root.Left.Val] = root
        dfs(root.Left)
    }
    if root.Right != nil {
        parentRecord[root.Right.Val] = root
        dfs(root.Right)
    }
}