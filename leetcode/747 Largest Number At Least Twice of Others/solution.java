class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        int maxNum1 = Integer.MIN_VALUE; // java.lang.Integer此处初始化作负无穷使用！！！
        int maxNum2 = Integer.MIN_VALUE;
        int indexMax = -1;
        for (int i=0; i<n; i++) { // 一次遍历更新nums中最大值与第二大的值以及最大值的下标！！！
            if (nums[i] > maxNum1) { // case1：新的最大值！！！
                maxNum2 = maxNum1;
                maxNum1 = nums[i];
                indexMax = i;
            } else if (nums[i] > maxNum2) { // case2：新的第二大的值！！！
                    maxNum2 = nums[i];
            }
        }

        if (maxNum1 >= (2*maxNum2)) {
            return indexMax;
        }
        return -1;
    }
}