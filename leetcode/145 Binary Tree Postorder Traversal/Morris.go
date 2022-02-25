/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func postorderTraversal(root *TreeNode) []int { // Morris����������ʱ������ҿռ临�Ӷ�ΪO(1)������
    result := []int{} // ������������Ҹ�������
    if root == nil {
        return result // ����ǰ�����Ϊ�������ҡ������ǻ���ǰ�����Morris�Ĵ��룬�ԳƵ������ҵı���˳��Ϊ�������󡱣�����ٷ�ת����������ɵõ������Ҹ���������
    }

    var subtreeRoot, predecessor *TreeNode = root, nil // ����˼�뼴��ÿ���ڵ��������������ǣ�����Ӧ��ǰ���ڵ�predecessorָ���subtreeRoot�������Ϸ�Ϊ��Ǳ���ϸ��������̣�����Ҫ��Ϊ����;ֲ������ӽǣ�������

    for subtreeRoot != nil {
        if subtreeRoot.Right != nil { // case1���ұ߲�Ϊ��ʱ˵����δ����������Ҫ�ȶԵ�ǰ�ڵ���ұ߰���������������Ǳ������

            predecessor = subtreeRoot.Right // Ҫ�㣺ʹ��whileѭ����predecessor���ں��������ԳƷ�תʱ��ǰ�����Ϊ�������������ӽڵ㣡����
            for predecessor.Left != nil && predecessor.Left != subtreeRoot {
                predecessor = predecessor.Left
            }

            if predecessor.Left == nil { // δ���ӣ�ע��ǰ�������Ҫ�Ƚ���ǰsubtreeRoot����result���ٽ�predecessorָ��ǰsubtreeRoot��subtreeRoot�ż������ұ���Ǳ������
                result = append(result, subtreeRoot.Val)
                predecessor.Left = subtreeRoot
                subtreeRoot = subtreeRoot.Right
            } else if predecessor.Left == subtreeRoot { // �����ӣ�����������Ǳ�������������������ϸ����̣���Ҫ�Ͽ����ӣ����ϸ�ǰ��Ҫ�ȴ���ǰsubtreeRoot����ߣ�����Ҫ�ֲ�����Ǳ�ϸ���������
                predecessor.Left = nil
                subtreeRoot = subtreeRoot.Left
            }

        } else { // case2���ұ�Ϊ�գ��򽫵�ǰsubtreeRoot���������������Ǳ������
            result = append(result, subtreeRoot.Val)
            subtreeRoot = subtreeRoot.Left
        }
    }

    reverse(result)
    return result
}

func reverse(array []int) {
    n := len(array)
    p1, p2 := 0, n-1
    for p1 < p2 {
        array[p1], array[p2] = array[p2], array[p1]
        p1++
        p2--
    }
}