class Solution {
    public int maximalRectangle(char[][] matrix) { //「单调栈」+「竖直方向正向逆向结合」！！！
        int m = matrix.length;
        int n = matrix[0].length;
		if (m == 0) return 0;

        int[][] left = new int[m][n]; // left[i][j]表示(i, j)左边连续1的数量！！！
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0) ? 1 : left[i][j-1]+1;
                }
            }
        }

        int result = 0;
        for (int j=0; j<n; j++) { // 以第j列为「X轴」基底，使用基于柱状图的方法！！！
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<>();
            
			for (int i=0; i<m; i++) { //「由上到下」：为下方新来的元素找到上方第一个更小的元素！！！
                while (!stack.isEmpty() && left[i][j] <= left[stack.peekFirst()][j]) {
                    stack.removeFirst();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peekFirst(); // 上边界；注意默认为-1！！！
                stack.addFirst(i);
            }

            stack.clear();
            for (int i = m - 1; i >= 0; i--) { //「由下到上」：为上方新来的元素找到下方第一个更小的元素！！！
                while (!stack.isEmpty() && left[stack.peekFirst()][j] >= left[i][j]) {
                    stack.removeFirst();
                }
                down[i] = stack.isEmpty() ? m : stack.peekFirst(); // 下边界；注意默认为m！！！
                stack.addFirst(i);
            }

            for (int i=0; i<m; i++) { // 经过两趟遍历之后，以第j列为轴，横向第i个柱子为中心向上下延展，down[i]-up[i]-1为高，left[i][j]为长的矩形即可以确定！！！
                int height = down[i]-up[i]-1;
                result = Math.max(result, height*left[i][j]);
            }
        }

        return result;
    }
}