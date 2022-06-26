class Solution { // 回溯统计排列组合！！！
    List<List<Integer>> result = new ArrayList<>();
	List<Integer> current = new ArrayList<Integer>();
    int[] visited;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.visited = new int[nums.length];
        Arrays.sort(nums); // 需要先排序！！！
        dfsBackTrack();
        return result;
    }

    public void dfsBackTrack() {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (visited[i]==1 || (i>0 && nums[i]==nums[i-1] && visited[i-1]==0)) {
                continue; // 由此判断规则可以保证每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」！！！
            }
            visited[i] = 1;
            current.add(nums[i]);
            dfsBackTrack();
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}