class Solution { // DFS����ͼ�еĻ������һ�����ǹؼ�·�������ҽ����ñ߲��ڻ��У�����
    List<Integer>[] adjacency;
	HashSet<List<Integer>> edges;
	int[] depth;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.adjacency = new ArrayList[n]; // Step1����ͼ��ʾΪ�ڽӱ�ע��������Ϊ���飬�洢��Ԫ������ΪList<Integer>������
        for (int i=0; i<n; i++) {
            adjacency[i] = new ArrayList<>();
        }
        for(List<Integer> connection : connections) {
            adjacency[connection.get(0)].add(connection.get(1));
            adjacency[connection.get(1)].add(connection.get(0));
        }

		this.edges = new HashSet<>(connections); // Step2����connections����Set��ȥ�أ���DFSʱ����ɾ��������
        this.depth = new int[n]; // Step3����¼�ڵ���DFS�е�����Ҹ�����ʾδ���ʣ�ע���ʼ������Ϊ-1������
        Arrays.fill(depth, -2);

		dfs(0, 0);
        return new ArrayList<>(edges);
    }
    
    public int dfs(int node, int currentDepth){
        if (depth[node] >= 0){
            return depth[node]; // ���ѷ�����ֱ�ӷ��ظýڵ���С��ȣ�����
        }
		
        depth[node] = currentDepth; // δ�������¼�ڵ��ڵ�ǰDFS�е���ȣ�����

        int currentMin = currentDepth; // ��¼��ǰ�ڵ���·���У������ǻ�������С��ȣ�����
        for(int neighbor: adjacency[node]){
            if (depth[neighbor] == currentDepth-1){ // �����Ը��ڵ�ļ�飡����
                continue;
            }
            int neighborMin = dfs(neighbor, currentDepth+1); // �ݹ�DFS��ȡ�ڽӽڵ���·���У������ǻ�������С��ȣ�����
            if (neighborMin <= currentDepth){ // Ҫ�㣺��ʱ�ýڵ��ڻ��У������������ڵ�ı߲��ǹؼ�·������Ҫ�Ӵ����Ƴ�������+���򣩣�����
                edges.remove(Arrays.asList(node, neighbor));
                edges.remove(Arrays.asList(neighbor, node)); 
            }
            currentMin = Math.min(currentMin, neighborMin); // ���²����ص�ǰ�ڵ���·���У������ǻ�������С��ȣ��Ա�ȥ��������������
        }
        return currentMin;
    }
}