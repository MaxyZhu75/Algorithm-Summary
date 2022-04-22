/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rightSideView(root *TreeNode) []int { // BFS从左向右遍历，将每层最右节点加入即可！！！
    result := []int{}
    if root == nil {
        return result
    }

    bfsQueue := []*TreeNode{root}

    for len(bfsQueue) > 0 {
        size := len(bfsQueue)
        for size > 0 {
            size--
            currentNode := bfsQueue[0]
            bfsQueue = bfsQueue[1:] // Go语言队列出队操作！！！
            if size == 0 {
                result = append(result, currentNode.Val) // 加入该深度的最右节点！！！
            }
            if currentNode.Left != nil {
                bfsQueue = append(bfsQueue, currentNode.Left)
            }
            if currentNode.Right != nil {
                bfsQueue = append(bfsQueue, currentNode.Right)
            }
        }
    }
    return result
}