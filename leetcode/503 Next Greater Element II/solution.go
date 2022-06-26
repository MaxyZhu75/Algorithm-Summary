func nextGreaterElements(nums []int) []int { // ��ѭ�����顸��ֱ�������±�ȡģ���൱�ڽ����鸴��ƴ����β��������
    n := len(nums)
    stack := []int{}
    result := make([]int, n)
    for i:=2*n-1; i>=0; i-- { //�����򡹣�Ϊ���������Ԫ���ҵ��Ҳ��һ����С��Ԫ�أ�����
        for len(stack) > 0 && nums[i%n] >= stack[len(stack)-1] {
            stack = stack[:len(stack)-1]
        }
        if len(stack) > 0 {
            result[i%n] = stack[len(stack)-1]
        } else {
            result[i%n] = -1; // ע��Ĭ��Ϊ-1������
        }
        stack = append(stack, nums[i%n])
    }

    return result
}