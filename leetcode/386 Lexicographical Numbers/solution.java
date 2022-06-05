class Solution { // ��LeetCode��440�⣻����Ϊ�ֵ�������������
    int n;
    List<Integer> result = new ArrayList<>();
	
	public List<Integer> lexicalOrder(int n) { // DFS�ݹ飻������Go���԰汾�𰸣�����
        this.n = n;
		for (int i = 1; i <= 9; i++) { // root��ͬ��ڵ��У���1��9���Һ����ƶ�������
			dfs(i);
		}
        return result;
    }

	public void dfs(int root) {
        if (root > n) return;
        result.add(root); // ÿ�εݹ�����result��Ӳ�����n�Ľڵ㣡����
        for (int i=0; i<=9; i++) {
			dfs(root*10 + i); // ��rootΪ��㣬ͨ����10���������ƶ�����dfs�ݹ�������в�����n���ӽڵ㣡����
		}
    }
}