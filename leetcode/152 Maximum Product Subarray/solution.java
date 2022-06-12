class Solution {
	public int maxProduct(int[] nums) { //「正向逆向结合」！！！
		int n = nums.length;
		if (n == 1) return nums[0]; // 结论：假设所有正负号情况，若数组中没有0的话，那么拥有最大乘积的子数组一定以nums[0]开始（前缀数组）或者以nums[n-1]结尾（后缀数组）！！！
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = nums[0];
		right[n-1] = nums[n-1];
		for (int i=1; i<n; i++) { // 正向逆向统计各元素前后缀数组！！！
			left[i] = (left[i-1] == 0 ? 1 : left[i-1]) * nums[i]; // 若遇到元素为0，即前缀（后缀）数组乘积为0，则重新从当前元素开始计算前缀乘积即可！！！
			right[n-i-1] = (right[n-i] == 0 ? 1 : right[n-i]) * nums[n-1-i];
		}
		int result = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			result = Math.max(result, Math.max(left[i], right[n-1-i]));
		}
		return result;
	}
}