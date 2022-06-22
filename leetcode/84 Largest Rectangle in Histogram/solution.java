class Solution {
    public int largestRectangleArea(int[] heights) { //「单调栈」+「正向逆向结合」！！！
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>(); //「栈顶到栈底高度依次递减」！！！

        for (int i=0; i<n; i++) { //「正向」：为右边新来的元素找到左侧第一个更小的元素！！！
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekFirst()]) {
                stack.removeFirst();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekFirst(); // 注意默认为-1！！！
            stack.addFirst(i);
        }

        stack.clear();
        for (int i=n-1; i>=0; i--) { //「反向」：为左边新来的元素找到右侧第一个更小的元素！！！
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekFirst()]) {
                stack.removeFirst();
            }
            right[i] = stack.isEmpty() ? n : stack.peekFirst(); // 注意默认为n！！！
            stack.addFirst(i);
        }
        
        int result = 0; // 经过两趟遍历之后，以第i个柱子为中心向两边延展，heights[i]为高，right[i]-left[i]-1为底的矩形即可以确定！！！
        for (int i=0; i<n; i++) {
            result = Math.max(result, (right[i]-left[i]-1) * heights[i]);
        }
        return result;
    }
}