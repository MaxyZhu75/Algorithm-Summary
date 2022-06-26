class Solution {
    List<List<Integer>> result = new ArrayList<>();    
	List<Integer> current = new ArrayList<>();
	int[] candidates;
    int[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
		this.visited = new int[candidates.length];
        Arrays.sort(candidates); // 结果去重先排序！！！
        dfsBackTracking(0, target);
        return result;
    }

    public void dfsBackTracking(int start, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (start == candidates.length || target < 0) {
            return;
        }
        for (int i=start; i<candidates.length; i++) {
            if (visited[i]==1 || (i>0 && candidates[i]==candidates[i-1] && visited[i-1]==0)) { // 结果去重判断条件！！！
                continue;
            }
            visited[i] = 1; // 每个元素只用一次！！！
            current.add(candidates[i]);
            dfsBackTracking(i+1, target-candidates[i]); // 由于返回组合，递归时需要传入起点！！！
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}