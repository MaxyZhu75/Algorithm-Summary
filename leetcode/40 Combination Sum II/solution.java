class Solution {
    List<List<Integer>> result = new ArrayList<>();    
	List<Integer> current = new ArrayList<>();
	int[] candidates;
    int[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
		this.visited = new int[candidates.length];
        Arrays.sort(candidates); // ���ȥ�������򣡣���
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
            if (visited[i]==1 || (i>0 && candidates[i]==candidates[i-1] && visited[i-1]==0)) { // ���ȥ���ж�����������
                continue;
            }
            visited[i] = 1; // ÿ��Ԫ��ֻ��һ�Σ�����
            current.add(candidates[i]);
            dfsBackTracking(i+1, target-candidates[i]); // ���ڷ�����ϣ��ݹ�ʱ��Ҫ������㣡����
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}