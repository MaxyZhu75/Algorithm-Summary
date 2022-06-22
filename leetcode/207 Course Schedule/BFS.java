class Solution { // BFS����ͼ����������LeetCode��210����ȫ��ͬ������
    public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses]; // �洢ÿ���ڵ����ȣ�����
		List<List<Integer>> adjacent = new ArrayList<>(); // �洢����ͼ���洢���нڵ�ĳ��ߣ����ڽӱ�������
        for (int i=0; i<numCourses; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
			adjacent.get(edge[1]).add(edge[0]); // ����[u, v]��ʾvΪ���޿Σ���ͼ��vָ��u������
            indegree[edge[0]]++;
        }

        Deque<Integer> bfsQueue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) { // ���������Ϊ0�Ľڵ��������У���������Ϊ����ͼ�д��ڻ����������������򣡣���
            if (indegree[i] == 0) {
                bfsQueue.addLast(i);
            }
        }
		
		int[] result = new int[numCourses];
		int index = 0;
        while (!bfsQueue.isEmpty()) {
			int size = bfsQueue.size();
			while (size-- > 0) {
				int v = bfsQueue.poll();
				result[index] = v;
				index++;
				for (int u : adjacent.get(v)) { // ������ǰ�ڵ����г��ߣ�����
					indegree[u]--;
					if (indegree[u] == 0) { // �ھӽڵ�������Ϊ0ʱ��ӣ���ֹ�ظ���ӣ�������
						bfsQueue.addLast(u);
					}
				}
			}
        }

        return (index == numCourses) ? true : false;
    }
}