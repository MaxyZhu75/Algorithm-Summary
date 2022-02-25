/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findBottomLeftValue(root *TreeNode) int { // BFS层序遍历；注意最底层最左边节点，不一定是左子节点，只要最左边即可！！！
    bfsQueue := []*TreeNode{root}
    currentNode := root
    for len(bfsQueue) != 0 {
        tempQueue := bfsQueue
        bfsQueue = nil
        for i:=0; i<len(tempQueue); i++ { // 每层入队时先右后左，则最后一个出队的节点必是在树的最底层最左边！！！
            currentNode = tempQueue[i]
            if currentNode.Right != nil {
                bfsQueue = append(bfsQueue, currentNode.Right)
            }
            if currentNode.Left != nil {
                bfsQueue = append(bfsQueue, currentNode.Left)
            }
        }
    }
    return currentNode.Val 
}