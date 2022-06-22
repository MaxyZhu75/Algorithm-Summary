class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) { //「前缀和」+「分类解决」！！！
        int L = firstLen, M = secondLen;
		int[] preSum = new int[nums.length+1]; // 存储前缀和！！！
        for(int i=1; i<=nums.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int max1 = findMax(nums, L, M, preSum); // case1：长度为 L 的连续子数组在左边, 长度为 M 的连续子数组在右边！！！
        int max2 = findMax(nums, M, L, preSum); // case2：长度为 M 的连续子数组在左边, 长度为 L 的连续子数组在右边！！！
        return Math.max(max1, max2);
    }
    
    private int findMax(int[] nums, int l, int r, int[] preSum){ //「l」和「r」分别代表左边和右边连续字数组的长度！！！
        int lMax = preSum[l], rSum = preSum[l+r] - preSum[l];
        int max = lMax + rSum;
        for (int i=l+1; i+r <= nums.length; i++){
            lMax = Math.max(lMax, preSum[i]-preSum[i-l]);
            rSum = preSum[i+r] - preSum[i]; // 细节：左边的数组最大和每次需要更新；右边的数组之和不能够重叠，每次作为滑动窗口右移即可！！！
            max = Math.max(max, lMax + rSum); // 两数组最大和每次检查更新即可！！！
        }
        return max;
    }
}