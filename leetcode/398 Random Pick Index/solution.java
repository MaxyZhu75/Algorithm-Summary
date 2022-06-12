class Solution { // LeetCode��382��İ棻�洢��Ԫ�ص������������ռ�ΪO(n)������
    Map<Integer, List<Integer>> hashRecord = new HashMap<>();
    Random random;

    public Solution(int[] nums) { // ���췽��������
        this.random = new Random();
        for (int i=0; i<nums.length; i++) { // ��ϣ��������洢��Ԫ�ص���������������
            hashRecord.putIfAbsent(nums[i], new ArrayList<Integer>());
            hashRecord.get(nums[i]).add(i);
        }
    }

    public int pick(int target) { // ȡָ��Ԫ�ص������������������
        List<Integer> indices = hashRecord.get(target);
        return indices.get(random.nextInt(indices.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */