class Solution { // 见LeetCode第440题；该题为字典树遍历！！！
    int n;
    List<Integer> result = new ArrayList<>();
	
	public List<Integer> lexicalOrder(int n) { // DFS递归；迭代见Go语言版本答案！！！
        this.n = n;
		for (int i = 1; i <= 9; i++) { // root在同层节点中，由1到9向右横向移动！！！
			dfs(i);
		}
        return result;
    }

	public void dfs(int root) {
        if (root > n) return;
        result.add(root); // 每次递归先往result添加不大于n的节点！！！
        for (int i=0; i<=9; i++) {
			dfs(root*10 + i); // 以root为起点，通过乘10纵向向下移动，且dfs递归遍历所有不大于n的子节点！！！
		}
    }
}