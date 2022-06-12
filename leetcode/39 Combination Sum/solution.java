class Solution { // ͳ��������ϵĸ������ʱ���û��ݽ��������
    List<List<Integer>> result = new ArrayList<>();    
	List<Integer> current = new ArrayList<>();
	int[] candidates;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
		dfsBackTracking(0, target);
        return result;
    }

    public void dfsBackTracking(int start, int target) {
        if (start == candidates.length || target < 0) { // ������������ѳ��ԣ�����
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current)); // newһ���б������������
            return;
        }
		
        for (int i=start; i<candidates.length; i++) { // ѭ���ڻ��ݣ�����
            current.add(candidates[i]);
            dfsBackTracking(i, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}