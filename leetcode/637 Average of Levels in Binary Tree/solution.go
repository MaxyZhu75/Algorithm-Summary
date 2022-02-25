/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func averageOfLevels(root *TreeNode) []float64 { // 计算每层平均值自然联想到层序遍历，则可以使用常规BFS！！！
    var result []float64 = []float64{}
    bfsQueue := []*TreeNode{root} // BFS需要队列实现，注意Go语言用数组写BFS队列的方法！！！

    for len(bfsQueue) != 0 {
        tempQueue := bfsQueue // 操作一：临时数组存储当前深度BFS队列信息！！！
        bfsQueue = nil // 操作二：原BFS队列置空，全部出队！！！
        sum := 0
        for _, currentNode := range tempQueue {
            sum += currentNode.Val
            if currentNode.Left != nil {
                bfsQueue = append(bfsQueue, currentNode.Left)
            }
            if currentNode.Right != nil {
                bfsQueue = append(bfsQueue, currentNode.Right)
            }
        }
        
        result = append(result, float64(sum)/float64(len(tempQueue)))
    }
    return result
}