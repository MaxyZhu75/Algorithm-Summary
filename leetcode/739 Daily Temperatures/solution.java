class Solution {
    public int[] dailyTemperatures(int[] temperatures) { // 经典单调栈！！！
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new LinkedList<>(); //「栈顶到栈底温度依次递增」！！！
        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) { // 原先栈内可能有多个温度小于新来的，都需要标记后出栈！！！
                int index = stack.removeFirst();
                result[index] = i-index;
            }
            stack.addFirst(i);
        }
        return result;
    }
}