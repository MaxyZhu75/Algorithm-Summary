class Solution {
    public int arraySign(int[] nums) { // ��������ű仯���ɣ�����Ҫ���˻�������
        int sign = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) sign *= -1;
        }
        return sign;
    }
}