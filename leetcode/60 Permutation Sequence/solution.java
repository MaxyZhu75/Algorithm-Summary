class Solution {
	List<Integer> current = new ArrayList<>();
    int[] visited;
    StringBuilder sb = new StringBuilder();
    int count;
	int n;
	int k;

    public String getPermutation(int n, int k) { // 数学解才是最优解；回溯剪枝只是通用解！！！
        this.n = n;
        this.k = k;
        this.count = 0;
		this.visited = new int[n+1];
        dfsBackTracking();
        return sb.toString();
    }

    public void dfsBackTracking() {
        if (current.size() == n) {
            count++;
            if (count == k) { // 第k次添加结果！！！
                for (int i=0; i<n; i++) {
                    sb.append(current.get(i));
                }
            }
            return;
        }

        if (sb.length() != 0) return; // 得到结果就无需继续递归了！！！

        for (int i=1; i<=n; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            current.add(i);
            dfsBackTracking();
            visited[i] = 0;
            current.remove(current.size()-1);
        }
    }
}