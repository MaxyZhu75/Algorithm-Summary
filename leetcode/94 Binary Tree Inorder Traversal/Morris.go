/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int { // Morris����������ʱ������ҿռ临�Ӷ�ΪO(1)������
    result := []int{}
    if root == nil {
        return result // �������������ң�����
    }

    var subtreeRoot, predecessor *TreeNode = root, nil // ����˼�뼴��ÿ���ڵ��������������ǣ�����Ӧ��ǰ���ڵ�predecessorָ���subtreeRoot�������Ϸ�Ϊ��Ǳ���ϸ��������̣�����Ҫ��Ϊ����;ֲ������ӽǣ�������

    for subtreeRoot != nil {
        if subtreeRoot.Left != nil { // case1����߲�Ϊ��ʱ˵����δ����������Ҫ�ȶԵ�ǰ�ڵ����߰���������������Ǳ������
           
		    predecessor = subtreeRoot.Left // Ҫ�㣺ʹ��whileѭ����predecessor������������У�ǰ�����Ϊ�������������ӽڵ㣡����
            for predecessor.Right != nil && predecessor.Right != subtreeRoot {
                predecessor = predecessor.Right;
            }

            if predecessor.Right == nil { // δ���ӣ���predecessorָ��ǰsubtreeRoot��subtreeRoot���������������Ǳ������
                predecessor.Right = subtreeRoot
                subtreeRoot = subtreeRoot.Left
            } else if predecessor.Right == subtreeRoot { // �����ӣ�����������Ǳ���������������ʱ�Ž���ǰsubtreeRoot���������������������ϸ����̣���Ҫ�Ͽ����ӣ����ϸ�ǰ��Ҫ�ȴ���ǰsubtreeRoot���ұߣ�����Ҫ�ֲ�����Ǳ�ϸ���������
                result = append(result, subtreeRoot.Val)
                predecessor.Right = nil
                subtreeRoot = subtreeRoot.Right
            }

        } else { // case2�����Ϊ�գ��򽫵�ǰsubtreeRoot�����������ұ���Ǳ������
            result = append(result, subtreeRoot.Val)
            subtreeRoot = subtreeRoot.Right
        }
    }
    return result
}