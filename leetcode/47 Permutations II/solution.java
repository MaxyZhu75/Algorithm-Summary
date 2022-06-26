class Solution { // ����ͳ��������ϣ�����
    List<List<Integer>> result = new ArrayList<>();
	List<Integer> current = new ArrayList<Integer>();
    int[] visited;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.visited = new int[nums.length];
        Arrays.sort(nums); // ��Ҫ�����򣡣���
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
                continue; // �ɴ��жϹ�����Ա�֤ÿ���������һ��������������ظ��������С��������ҵ�һ��δ����������֡�������
            }
            visited[i] = 1;
            current.add(nums[i]);
            dfsBackTrack();
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}