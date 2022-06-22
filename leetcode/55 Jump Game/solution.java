public class Solution {
    public boolean canJump(int[] nums) { // ̰�ĵ��ҵ���ǰ�ܵ������Զλ�ã�����
        int n = nums.length;
        int farest = 0;
        for (int i=0; i<n; i++) {
            if (i <= farest) { // ���������ķ�Χ�ڱ��������ܷ������Զλ�ã�����
                farest = Math.max(farest, i+nums[i]);
                if (farest >= n-1) {
                    return true;
                }
            }
        }
        return false;
    }
}