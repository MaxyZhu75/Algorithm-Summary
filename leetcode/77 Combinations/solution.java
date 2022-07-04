class Solution {
    List<List<Integer>> result = new ArrayList<>();    
	List<Integer> current = new ArrayList<>();
    int[] visited;
	int n;
	int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
		this.visited = new int[n+1];
        dfsBackTracking(1);
        return result;
    }

    public void dfsBackTracking(int start) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=start; i<=n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1; // ÿ��Ԫ��ֻ��һ�Σ�����
            current.add(i);
            dfsBackTracking(i+1); // ���ڷ�����ϣ��ݹ�ʱ��Ҫ������㣡����
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}