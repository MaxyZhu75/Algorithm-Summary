/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rightSideView(root *TreeNode) []int { // BFS�������ұ�������ÿ�����ҽڵ���뼴�ɣ�����
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
            bfsQueue = bfsQueue[1:] // Go���Զ��г��Ӳ���������
            if size == 0 {
                result = append(result, currentNode.Val) // �������ȵ����ҽڵ㣡����
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