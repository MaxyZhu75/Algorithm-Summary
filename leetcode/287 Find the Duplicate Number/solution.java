class Solution {
    public int findDuplicate(int[] nums) { // ��Ի�������Floyd��Ȧ����Ӧ�ã�����
        int slow = 0;
        int fast = 0; // Ҫ��һ������ָ�룡����
        
        while (true) { // ����дwhile(true)��������������������������
            slow = nums[slow];
            fast = nums[nums[fast]]; // ��ָ����n������ָ������2n������㵽Ȧ��ڳ���Ϊm��Ȧ�ĳ���Ϊc������
            if (slow == fast) { // ������ָ����Ȧ������n-m��ͣ�£�����ָ����Ȧ������n-m+n��ͣ�£�Ҳ���ǿ�ָ�����n-m��λ�ÿ�ʼ������n�������ٴ�ͣ��n-m������n������Ȧ�������� n%c = 0 ������
                break;
            }
        }

        int findEntry = 0; // Ҫ�����Ѱ��Ȧ��ڵ�ָ�룡����
        while (true) {
            findEntry = nums[findEntry]; // ��֪��ָ����Ȧ������n-m��ͣ�£�������m���ص�Ȧ����ڣ�m�Ķ��屾������㵽Ȧ��ڳ��ȣ�������ָ�������������
            slow = nums[slow];
            if (findEntry == slow) {
                break;
            }
        }

        return findEntry;
    }
}