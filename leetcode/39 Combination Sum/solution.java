class Solution { // 统计排列组合的各种情况时可用回溯解决！！！
    List<List<Integer>> result = new ArrayList<>();    
	List<Integer> current = new ArrayList<>();
	int[] candidates;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
		dfsBackTracking(0, target);
        return result;
    }

    public void dfsBackTracking(int start, int target) {
        if (start == candidates.length || target < 0) { // 所有数字组合已尝试！！！
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current)); // new一个列表加入结果！！！
            return;
        }
		
        for (int i=start; i<candidates.length; i++) { // 循环内回溯！！！
            current.add(candidates[i]);
            dfsBackTracking(i, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}