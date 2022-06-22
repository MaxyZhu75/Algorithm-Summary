/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val   int
 *     Left  *TreeNode
 *     Right *TreeNode
 * }
 */

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode { // 一次遍历找出「分岔点」！！！
    var ancestor *TreeNode = root
    for true {
        if p.Val < ancestor.Val && q.Val < ancestor.Val { // case1: p和q皆在当前节点的左子树！！！
            ancestor = ancestor.Left
        } else if p.Val > ancestor.Val && q.Val > ancestor.Val { // case2：p和q皆在当前节点的右子树！！！
            ancestor = ancestor.Right
        } else {
            break // case3：p和q要么在当前节点的不同的子树中，要么其中一个就是当前节点！！！
        }
    }
    return ancestor
}