class Solution {
    public int majorityElement(int[] nums) { // Boyer-MooreͶƱ��������
        int candidate = nums[0];
        int vote = 0;
        for (int num : nums) {
            candidate = (vote == 0) ? num : candidate; // case1������ѡ�˲���majority����majority��������Ǻ�ѡ��һ�𷴶Ժ�ѡ�ˣ�����ѡ��һ������̨����vote==0ʱ��������ѡ�٣�����
            vote = (candidate == num) ? vote+1 : vote-1; // case2������ѡ����majority , ��majority��֧���Լ����������Ǻ�ѡ�˻ᷴ�ԣ�������֪majorityƱ������һ�룬������һ����ɹ���ѡ������
        }
        return candidate;
    }
}