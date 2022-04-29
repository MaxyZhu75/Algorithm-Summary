class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> current = new ArrayList<Integer>();
	int[] nums;
	
	public List<List<Integer>> subsets(int[] nums) { // 回溯解决；由于数组元素互不相同，此时问题转化为求组合大小！！！
		this.nums = nums;
		for (int size=0; size <= nums.length; size++) { // 传入不同的子集大小！！！
			dfsBackTrack(0, size);
		}
		return result;
	}

	private void dfsBackTrack(int start, int size) { // 与LeetCode17题写法类似！！！
		if (current.size() == size) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i=start; i<nums.length; i++) { // 遍历不同的子集起点！！！
			current.add(nums[i]);
			dfsBackTrack(i+1, size);
			current.remove(current.size() - 1);
		}
	}
}