class Solution { // 回溯统计排列组合！！！
    List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> current = new ArrayList<Integer>();
    int[] visited;
    int[] nums;
	
	public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.visited = new int[nums.length];
        dfsBackTrack();
        return result;
    }

    public void dfsBackTrack() {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current)); // 递归出口！！！
            return;
        }
        for (int i=0; i<nums.length; i++) { // 回溯使用标记数组visited可保证字典序输出！！！
            if (visited[i] == 1) continue;
            visited[i] = 1;
            current.add(nums[i]);
            dfsBackTrack();
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}