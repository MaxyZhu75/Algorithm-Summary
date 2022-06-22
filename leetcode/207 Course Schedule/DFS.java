class Solution { // DFS����ͼ����������LeetCode��210����ȫ��ͬ������������
    List<List<Integer>> adjacent;
    int[] status;
    int[] result;
    boolean loop = false;
    int index;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.status = new int[numCourses]; // ���ÿ���ڵ��״̬��0=δ������1=�����У�2=����ɣ�����
        this.result = new int[numCourses];
		this.index = numCourses-1; // ������Ӵ𰸣�����
		this.adjacent = new ArrayList<List<Integer>>(); // �洢����ͼ���洢���нڵ�ĳ��ߣ����ڽӱ�������
        for (int i=0; i<numCourses; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            adjacent.get(edge[1]).add(edge[0]); // ����[u, v]��ʾvΪ���޿Σ���ͼ��vָ��u������
        }

        for (int i=0; i<numCourses && !loop; i++) { // ÿ����ѡһ����δ�������Ľڵ㣬��ʼ���������������������
            if (status[i] == 0) {
                dfs(i);
            }
        }

        return loop ? false : true;
    }

    public void dfs(int v) {
		if (loop) return;
		status[v] = 1; // ����ǰ�ڵ�v���Ϊ�������С�������
        for (int u : adjacent.get(v)) { // ������ǰ�ڵ����г��ߣ�����
            if (status[u] == 0) { // case1�����ھӡ�δ����������DFS�ݹ���ʸ�·��������
                dfs(u);
            } else if (status[u] == 1) { // case2�����ھӡ������С�����ͼ�д��ڻ����������������򣡣���
                loop = true;
                return;
            } // case3�����ھӡ�����ɡ����������ٷ��ʸýڵ㣡����
        }
        status[v] = 2; // ��ǡ�����ɡ�������
        result[index--] = v; // ������ӣ�����
    }
}