/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rob(root *TreeNode) int { // ע����Ⲣ���Ǽ򵥵Ĳ��������ͣ���
    result := maxValue(root)
    return max(result[0], result[1])
}

func maxValue(root *TreeNode) []int {
    if root == nil {
        return []int{0, 0}
    }

    leftNode := make([]int, 2) // С͵��ÿ���ڵ�������ѡ�񣬴�ٻ򲻴�٣�������������ֵ���Ƕ�Ҫ�������ȥ�Ƚϣ�����
    rightNode := make([]int, 2) // �������飬array[0]�洢�Ըýڵ�Ϊ���Ҹýڵ㲻��������ܵõ�������ֵ����array[1]�洢�Ըýڵ�Ϊ���Ҹýڵ㱻������ܵõ�������ֵ������
    containsRoot := make([]int, 2)

    leftNode, rightNode = maxValue(root.Left), maxValue(root.Right) // �����ӽڵ��ȵݹ鶨�壬��ʹ�ã�����
    containsRoot[0] = max(leftNode[0], leftNode[1]) + max(rightNode[0], rightNode[1]) // case1��root������٣���ȡ�����ӽڵ���Եݹ��������ֵ��Ӽ��ɣ�����
    containsRoot[1] = root.Val + leftNode[0] + rightNode[0] // case2��root����٣���ȡroot��ֵ�Լ������ӽڵ㲻�����ʱ���ܵõ�������ֵ��ӣ�����
    
    return containsRoot
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}