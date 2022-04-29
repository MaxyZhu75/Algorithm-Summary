class Solution {
    public int maxSubArray(int[] nums) { // ��̬�滮�ռ��Ż��棻����ٷ�����з��νⷨ������
        int current = 0;
        int max = nums[0];
        for (int num : nums) { // �˴��߼�Ϊ����current+numС��num��˵����ǰ����Ӵ�֮��currentΪ��������ֱ������num֮ǰ����ʹcurrent����num������
            current = Math.max(current+num, num); // d[i] = max(d[i?1]+nums[i], nums[i])������
            max = Math.max(max, current);
        }
        return max;
    }
}