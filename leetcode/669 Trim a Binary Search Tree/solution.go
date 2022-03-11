/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func trimBST(root *TreeNode, low int, high int) *TreeNode { // 递归，注意BST性质！！！
    if root == nil { // 左右出口！！！
        return nil
    }
    if root.Val < low { // case1：root比low小；由于root的左子树皆小于root，则root及其左子树需全部剪掉，然后继续修剪右子树！！！
        return trimBST(root.Right, low, high)
    } else if root.Val > high { // case2：root比high小；由于root的右子树皆大于root，则root及其右子树需全部剪掉，然后继续修剪左子树！！
        return trimBST(root.Left, low, high)
    } else {
        root.Left = trimBST(root.Left, low, high) // case3：root在范围内；则root仍在BST中，且其左右子树应同样满足BST性质，因此继续对两边修剪！！！
        root.Right = trimBST(root.Right, low, high)
    }
    return root
}