/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func averageOfLevels(root *TreeNode) []float64 { // ����ÿ��ƽ��ֵ��Ȼ���뵽��������������ʹ�ó���BFS������
    var result []float64 = []float64{}
    bfsQueue := []*TreeNode{root} // BFS��Ҫ����ʵ�֣�ע��Go����������дBFS���еķ���������

    for len(bfsQueue) != 0 {
        tempQueue := bfsQueue // ����һ����ʱ����洢��ǰ���BFS������Ϣ������
        bfsQueue = nil // ��������ԭBFS�����ÿգ�ȫ�����ӣ�����
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