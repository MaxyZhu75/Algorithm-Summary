class Solution { // ����ͳ��������ϣ�����
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
            if (!hashRecord.contains(answer)) { // HashSetȥ�أ�����
                result.add(answer);
                hashRecord.add(answer);
            }
            return;
        }
        for (int i=0; i<nums.length; i++) { // visited�����ֹͬһ��Ԫ���ظ�ʹ�ù��������ϣ�����
            if (visited[i] == 1) continue;
            visited[i] = 1;
            current.add(nums[i]);
            dfsBackTrack();
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}