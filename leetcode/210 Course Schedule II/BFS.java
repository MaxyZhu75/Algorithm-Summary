class Solution { // BFS有向图拓扑排序！！！
    List<List<Integer>> adjacent;
    int[] indegree;
    int[] result;
    int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) { 
		this.indegree = new int[numCourses]; // 存储每个节点的入度！！！
        this.result = new int[numCourses];
		this.adjacent = new ArrayList<>(); // 存储有向图，存储所有节点的出边（即邻接表）！！！
        for (int i=0; i<numCourses; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
			adjacent.get(edge[1]).add(edge[0]); // 本题[u, v]表示v为先修课，则图中v指向u！！！
            indegree[edge[0]]++;
        }

        Deque<Integer> bfsQueue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) { // 将所有入度为0的节点放入队列中；若队列仍为空则图中存在环，不存在拓扑排序！！！
            if (indegree[i] == 0) {
                bfsQueue.addLast(i);
            }
        }

        while (!bfsQueue.isEmpty()) {
			int size = bfsQueue.size();
			while (size-- > 0) {
				int v = bfsQueue.poll();
				result[index] = v;
				index++;
				for (int u : adjacent.get(v)) { // 遍历当前节点所有出边！！！
					indegree[u]--;
					if (indegree[u] == 0) { // 邻居节点仅当入度为0时添加（防止重复添加）！！！
						bfsQueue.addLast(u);
					}
				}
			}
        }

        return (index == numCourses) ? result : new int[0];
    }
}