class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int low = nums[0]; // ÿһ����̰�ĸ���ֵ��С��low��ֵ�ڶ�Сmid������
        int mid = Integer.MAX_VALUE; // java.lang.Integer�˴���ʼ����������ʹ�ã�����
        for (int i=1; i<n; i++){
            if(nums[i] > mid){ // case1���������г��֣�ֱ��return������
                return true;
            } else if (nums[i] > low) { // case2������mid������
                mid = nums[i];
            } else {
                low = nums[i]; // case3������low������
            }
        }
        return false;
    }
}