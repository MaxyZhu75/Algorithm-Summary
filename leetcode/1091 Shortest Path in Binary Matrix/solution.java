class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) { // 经典BFS题目，常用来解最短路径等最优解问题！！！
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; // 要点一：方向集合！！！
        int n = grid.length;
        int minStep = 0;

        Queue<Pair<Integer, Integer>> bfsQueue = new LinkedList<>(); // 要点二：BFS需要队列实现！！！
        bfsQueue.add(new Pair<>(0, 0)); // Pair<>()在Java中能帮助表示键值对；此处表示横纵坐标！！！

        while (!bfsQueue.isEmpty()) { // 要点三：外层while每次循环处理的是同一深度的所有节点！！！
           
            int nodeNum = bfsQueue.size();
            minStep++;
            
            while (nodeNum-- > 0) { // 要点四：内层while每次循环是在对当前深度的对某一节点进行处理！！！
                Pair<Integer, Integer> currentNode = bfsQueue.poll(); // 处理一：从队列中获取该节点信息！！！
                int row = currentNode.getKey();
                int colum = currentNode.getValue();

                if (grid[row][colum] == 1) { // 处理二：先判断是否可行，该判断条件优先级最高；因为如果终点为1时不能通行，则不能返回所统计的step！！！
                    continue;
                }

                if (row == n-1 && colum == n-1) { // 处理三：再判断是否满足到达终点！！！
                    return minStep;
                }
               
                grid[row][colum] = 1; // 处理四：路过之处需要标记为1，防止下次再经过！！！
                
                for (int[] diretion: directions) { // 处理五：用一个for循环将该节点的neighbor全部入队，为下一深度的循环做准备！！！
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