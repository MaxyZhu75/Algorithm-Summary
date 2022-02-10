func findDuplicate(nums []int) int { // ��Ի�������Floyd��Ȧ����Ӧ�ã�����
    slow, fast := 0, 0 // Ҫ��һ������ָ�룡����
    for (true) { // ����дwhile(true)��������������������������
        slow = nums[slow]
        fast = nums[nums[fast]]
        if slow == fast { // ������ָ����Ȧ������n-m��ͣ�£�����ָ����Ȧ������n-m+n��ͣ�£�Ҳ���ǿ�ָ�����n-m��λ�ÿ�ʼ������n�������ٴ�ͣ��n-m������n������Ȧ�������� n%c = 0 ������
            break
        }
    }

    findEntry := 0 // Ҫ�����Ѱ��Ȧ��ڵ�ָ�룡��
    for (true) {
        findEntry = nums[findEntry] // ��֪��ָ����Ȧ������n-m��ͣ�£�������m���ص�Ȧ����ڣ�m�Ķ��屾������㵽Ȧ��ڳ��ȣ�������ָ�������������
        slow = nums[slow]
        if findEntry == slow {
            break
        }
     }

    return findEntry
}