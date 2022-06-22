class Solution { // DFS有向图拓扑排序；与LeetCode第210题完全相同！！！！！！
    List<List<Integer>> adjacent;
    int[] status;
    int[] result;
    boolean loop = false;
    int index;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.status = new int[numCourses]; // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成！！！
        this.result = new int[numCourses];
		this.index = numCourses-1; // 逆序添加答案！！！
		this.adjacent = new ArrayList<List<Integer>>(); // 存储有向图，存储所有节点的出边（即邻接表）！！！
        for (int i=0; i<numCourses; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            adjacent.get(edge[1]).add(edge[0]); // 本题[u, v]表示v为先修课，则图中v指向u！！！
        }

        for (int i=0; i<numCourses && !loop; i++) { // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索！！！
            if (status[i] == 0) {
                dfs(i);
            }
        }

        return loop ? false : true;
    }

    public void dfs(int v) {
		if (loop) return;
		status[v] = 1; // 将当前节点v标记为「搜索中」！！！
        for (int u : adjacent.get(v)) { // 遍历当前节点所有出边！！！
            if (status[u] == 0) { // case1：若邻居「未搜索」，则DFS递归访问该路径！！！
                dfs(u);
            } else if (status[u] == 1) { // case2：若邻居「搜索中」，则图中存在环，不存在拓扑排序！！！
                loop = true;
                return;
            } // case3：若邻居「已完成」，则无需再访问该节点！！！
        }
        status[v] = 2; // 标记「已完成」！！！
        result[index--] = v; // 逆序添加！！！
    }
}