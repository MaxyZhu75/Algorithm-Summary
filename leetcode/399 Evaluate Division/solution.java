class Solution { // Floyd算法！！！
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nodeNum = 0;
        int n = equations.size();
        Map<String, Integer> nodes = new HashMap<>();
        for (int i=0; i<n; i++) { // 将每个节点标号！！！
            if (!nodes.containsKey(equations.get(i).get(0))) {
                nodes.put(equations.get(i).get(0), nodeNum++);
            }
            if (!nodes.containsKey(equations.get(i).get(1))) {
                nodes.put(equations.get(i).get(1), nodeNum++);
            }
        }
        double[][] graph = new double[nodeNum][nodeNum]; // 数组建图！！！
        for (int i=0; i<nodeNum; i++) {
            Arrays.fill(graph[i], -1.0);
        }
        for (int i=0; i<n; i++) { // 连接边！！！
            int n1 = nodes.get(equations.get(i).get(0));
			int n2 = nodes.get(equations.get(i).get(1));
            graph[n1][n2] = values[i];
            graph[n2][n1] = 1.0 / values[i];
        }

        for (int k=0; k<nodeNum; k++) { // 计算节点由i经过k到j的距离！！！
            for (int i=0; i<nodeNum; i++) {
                for (int j=0; j<nodeNum; j++) {
                    if (graph[i][k] > 0 && graph[k][j] > 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }

        int m = queries.size();
        double[] result = new double[m];
        for (int i=0; i<m; i++) {
            List<String> query = queries.get(i);
            double current = -1.0;
            if (nodes.containsKey(query.get(0)) && nodes.containsKey(query.get(1))) {
                int x = nodes.get(query.get(0));
				int y = nodes.get(query.get(1));
                if (graph[x][y] > 0) {
                    current = graph[x][y];
                }
            }
            result[i] = current;
        }
        return result;
    }
}