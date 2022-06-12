class Solution { // DFS查找图中的环；如果一个边是关键路径，当且仅当该边不在环中！！！
    List<Integer>[] adjacency;
	HashSet<List<Integer>> edges;
	int[] depth;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.adjacency = new ArrayList[n]; // Step1：将图表示为邻接表；注意表的类型为数组，存储的元素类型为List<Integer>！！！
        for (int i=0; i<n; i++) {
            adjacency[i] = new ArrayList<>();
        }
        for(List<Integer> connection : connections) {
            adjacency[connection.get(0)].add(connection.get(1));
            adjacency[connection.get(1)].add(connection.get(0));
        }

		this.edges = new HashSet<>(connections); // Step2：将connections放入Set中去重，且DFS时方便删除！！！
        this.depth = new int[n]; // Step3：记录节点在DFS中的深度且负数表示未访问；注意初始化不能为-1！！！
        Arrays.fill(depth, -2);

		dfs(0, 0);
        return new ArrayList<>(edges);
    }
    
    public int dfs(int node, int currentDepth){
        if (depth[node] >= 0){
            return depth[node]; // 若已访问则直接返回该节点最小深度！！！
        }
		
        depth[node] = currentDepth; // 未访问则记录节点在当前DFS中的深度！！！

        int currentMin = currentDepth; // 记录当前节点在路径中（可能是环）的最小深度！！！
        for(int neighbor: adjacency[node]){
            if (depth[neighbor] == currentDepth-1){ // 跳过对父节点的检查！！！
                continue;
            }
            int neighborMin = dfs(neighbor, currentDepth+1); // 递归DFS获取邻接节点在路径中（可能是环）的最小深度！！！
            if (neighborMin <= currentDepth){ // 要点：此时该节点在环中，连接这两个节点的边不是关键路径，需要从答案中移除（正向+反向）！！！
                edges.remove(Arrays.asList(node, neighbor));
                edges.remove(Arrays.asList(neighbor, node)); 
            }
            currentMin = Math.min(currentMin, neighborMin); // 更新并返回当前节点在路径中（可能是环）的最小深度，以便去掉整个环！！！
        }
        return currentMin;
    }
}