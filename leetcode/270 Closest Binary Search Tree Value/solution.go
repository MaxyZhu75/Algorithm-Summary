/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func closestValue(root *TreeNode, target float64) int { // 由BST性质二分查找即可！！！
    closest := root.Val
    for root != nil {
        if distance(root.Val, target) < distance(closest, target) {
            closest = root.Val
        }
        if float64(root.Val) < target {
            root = root.Right
        } else {
            root = root.Left
        }
    }
    return closest
}

func distance(a int, b float64) float64 {
    if (float64(a) - b) < 0 {
        return -1 * (float64(a)-b)
    }
    return float64(a) - b
}