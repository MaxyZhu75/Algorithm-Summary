class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) { // ����BFS��Ŀ�������������·�������Ž����⣡����
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; // Ҫ��һ�����򼯺ϣ�����
        int n = grid.length;
        int minStep = 0;

        Queue<Pair<Integer, Integer>> bfsQueue = new LinkedList<>(); // Ҫ�����BFS��Ҫ����ʵ�֣�����
        bfsQueue.add(new Pair<>(0, 0)); // Pair<>()��Java���ܰ�����ʾ��ֵ�ԣ��˴���ʾ�������꣡����

        while (!bfsQueue.isEmpty()) { // Ҫ���������whileÿ��ѭ���������ͬһ��ȵ����нڵ㣡����
           
            int nodeNum = bfsQueue.size();
            minStep++;
            
            while (nodeNum-- > 0) { // Ҫ���ģ��ڲ�whileÿ��ѭ�����ڶԵ�ǰ��ȵĶ�ĳһ�ڵ���д�������
                Pair<Integer, Integer> currentNode = bfsQueue.poll(); // ����һ���Ӷ����л�ȡ�ýڵ���Ϣ������
                int row = currentNode.getKey();
                int colum = currentNode.getValue();

                if (grid[row][colum] == 1) { // ����������ж��Ƿ���У����ж��������ȼ���ߣ���Ϊ����յ�Ϊ1ʱ����ͨ�У����ܷ�����ͳ�Ƶ�step������
                    continue;
                }

                if (row == n-1 && colum == n-1) { // �����������ж��Ƿ����㵽���յ㣡����
                    return minStep;
                }
               
                grid[row][colum] = 1; // �����ģ�·��֮����Ҫ���Ϊ1����ֹ�´��پ���������
                
                for (int[] diretion: directions) { // �����壺��һ��forѭ�����ýڵ��neighborȫ����ӣ�Ϊ��һ��ȵ�ѭ����׼��������
                    int nextRow = row + diretion[0];
                    int nextColum = colum + diretion[1];
                    if (nextRow < 0 || nextColum < 0 || nextRow > n-1 || nextColum > n-1) {
                        continue;
                    } else {
                        bfsQueue.add(new Pair<>(nextRow, nextColum));
                    }
                }
            }
        }
        return -1;
    }
}