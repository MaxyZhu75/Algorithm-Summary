class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> current = new ArrayList<Integer>();
	int[] nums;
	
	public List<List<Integer>> subsets(int[] nums) { // ���ݽ������������Ԫ�ػ�����ͬ����ʱ����ת��Ϊ����ϴ�С������
		this.nums = nums;
		for (int size=0; size <= nums.length; size++) { // ���벻ͬ���Ӽ���С������
			dfsBackTrack(0, size);
		}
		return result;
	}

	private void dfsBackTrack(int start, int size) { // ��LeetCode17��д�����ƣ�����
		if (current.size() == size) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i=start; i<nums.length; i++) { // ������ͬ���Ӽ���㣡����
			current.add(nums[i]);
			dfsBackTrack(i+1, size);
			current.remove(current.size() - 1);
		}
	}
}