class Solution { // ����ͳ��������ϣ�����
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
            result.add(new ArrayList<Integer>(current)); // �ݹ���ڣ�����
            return;
        }
        for (int i=0; i<nums.length; i++) { // ����ʹ�ñ������visited�ɱ�֤�ֵ������������
            if (visited[i] == 1) continue;
            visited[i] = 1;
            current.add(nums[i]);
            dfsBackTrack();
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}