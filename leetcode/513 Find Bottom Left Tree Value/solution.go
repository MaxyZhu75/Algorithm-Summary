/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findBottomLeftValue(root *TreeNode) int { // BFS���������ע����ײ�����߽ڵ㣬��һ�������ӽڵ㣬ֻҪ����߼��ɣ�����
    bfsQueue := []*TreeNode{root}
    currentNode := root
    for len(bfsQueue) != 0 {
        tempQueue := bfsQueue
        bfsQueue = nil
        for i:=0; i<len(tempQueue); i++ { // ÿ�����ʱ���Һ��������һ�����ӵĽڵ������������ײ�����ߣ�����
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