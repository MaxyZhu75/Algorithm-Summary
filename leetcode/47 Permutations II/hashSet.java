class Solution { // 回溯统计排列组合！！！
    List<List<Integer>> result = new ArrayList<>();
	List<Integer> current = new ArrayList<Integer>();
    Set<List<Integer>> hashRecord = new HashSet<>();
    int[] visited;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.visited = new int[nums.length];
        dfsBackTrack();
        return result;
    }

    public void dfsBackTrack() {
        if (current.size() == nums.length) {
            List<Integer> answer = new ArrayList<Integer>(current);
            if (!hashRecord.contains(answer)) { // HashSet去重！！！
                result.add(answer);
                hashRecord.add(answer);
            }
            return;
        }
        for (int i=0; i<nums.length; i++) { // visited数组防止同一个元素重复使用构成输出组合！！！
            if (visited[i] == 1) continue;
            visited[i] = 1;
            current.add(nums[i]);
            dfsBackTrack();
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}