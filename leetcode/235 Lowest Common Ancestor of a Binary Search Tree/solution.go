/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val   int
 *     Left  *TreeNode
 *     Right *TreeNode
 * }
 */

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode { // һ�α����ҳ����ֲ�㡹������
    var ancestor *TreeNode = root
    for true {
        if p.Val < ancestor.Val && q.Val < ancestor.Val { // case1: p��q���ڵ�ǰ�ڵ��������������
            ancestor = ancestor.Left
        } else if p.Val > ancestor.Val && q.Val > ancestor.Val { // case2��p��q���ڵ�ǰ�ڵ��������������
            ancestor = ancestor.Right
        } else {
            break // case3��p��qҪô�ڵ�ǰ�ڵ�Ĳ�ͬ�������У�Ҫô����һ�����ǵ�ǰ�ڵ㣡����
        }
    }
    return ancestor
}