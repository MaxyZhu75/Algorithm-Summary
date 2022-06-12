func nextGreaterElement(nums1 []int, nums2 []int) []int { //������ջ��������Ӽ���һ������Ԫ�����⡹������
    hashRecord := make(map[int]int) // ��¼��ʽ��<nums2[i], �ұ���һ�������Ԫ��ֵ>������
    stack := []int{}
    for i:=len(nums2)-1; i>=0; i-- { // �������nums2������
        for len(stack) > 0 && stack[len(stack)-1] <= nums2[i] { // ��ջ������ջ��Ԫ��С�ڵ��ڵ�ǰԪ�أ�ά������ջ��������
            stack = stack[:len(stack)-1]
        }
        if len(stack) > 0 { // ջΪ��˵���Ҳ�û�бȵ�ǰԪ�ظ���ģ�����
            hashRecord[nums2[i]] = stack[len(stack)-1]
        } else {
            hashRecord[nums2[i]] = -1;
        }
        stack = append(stack, nums2[i]) // ÿ����Ҫ��ջ��������
    }
    result := []int{}
    for _, num := range nums1 {
        result = append(result, hashRecord[num])
    }
    return result
}