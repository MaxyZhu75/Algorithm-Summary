/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func minCameraCover(root *TreeNode) int { // Ҫ�㣺dfs�ݹ� + ά������״̬������
    array := dfs(root) 					  // ״̬0����root�����������ͷʱ��������������Ҫ������ͷ��Ŀ������
    return array[1]      			      // ״̬1������root�Ƿ��������ͷ��������������Ҫ������ͷ��Ŀ������
}    			  	    	 	          // ״̬2������root�Ƿ񱻼�ص�����������������Ҫ������ͷ��Ŀ������

func dfs(root *TreeNode) []int {
    if root == nil {
        return []int{math.MaxInt32, 0, 0} // ��2����Ϊ��ֹ���������������������
    }
    leftArray := dfs(root.Left)
    rightArray := dfs(root.Right)
    array := []int{0, 0, 0}
    array[0] = leftArray[2] + rightArray[2] + 1 // ��root��������ͷ����left��rightһ��Ҳ�ᱻ��ص�����ʱֻ��Ҫ��֤left��right���Ե���������Ҳ�������Ǽ��ɣ�����
    array[1] = min(array[0], min(leftArray[0] + rightArray[1], leftArray[1] + rightArray[0])) // root��������ͷ����״̬0�Ľ������root����������ͷ����ʱ������Ҫ��֤����root������������Ϊ��ʹroot�ᱻ��ص���left��right����һ������Ҫ��װ����ͷ������
    array[2] = min(array[0], leftArray[1] + rightArray[1]) // ������֤�������������ǣ�Ҫôroot��������ͷ����״̬0�Ľ����Ҫôroot����������ͷ����ʱ���������ֱ�֤�Լ������Ǽ��ɣ��������ӽڵ�״̬1�Ľ����ӣ�����
    return array
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}