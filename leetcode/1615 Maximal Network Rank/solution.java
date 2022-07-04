class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
		int[] degree = new int[n]; // �洢ÿ���ڵ�Ķȣ�����
        List<List<Integer>> adjacent = new ArrayList<>(); // �洢����ͼ���洢���нڵ���ڱߣ����ڽӱ�������
        for (int i=0; i<n; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        for (int[] edge : roads) {
			adjacent.get(edge[1]).add(edge[0]);
			adjacent.get(edge[0]).add(edge[1]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int result = 0;
        for (int i=0; i<n; i++) { // ab���ȵ��ڡ�a���ڽӱ�����+b���ڽӱ�����-(ab�Ƿ�����)��������
            for (int j=i+1; j<n; j++) {
                int current = degree[i] + degree[j];
                if (adjacent.get(i).contains(j) == true) {
                    current--;
                }
                result = Math.max(result, current);
            }
        }

        return result;
    }
}