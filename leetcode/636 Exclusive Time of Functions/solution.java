class Solution {
    public int[] exclusiveTime(int n, List<String> logs) { // 单线程非抢占CPU：父函数调用子函数，子函数结束之后、父函数才有可能结束，不会出现父函数结束了子函数继续运行的情况！！！
        Deque<Integer> myStack = new ArrayDeque<>();
        int[] result = new int[n];
        String[] log = logs.get(0).split(":"); // 日志logs的格式仔细看题目描述！！！
        myStack.addFirst(Integer.parseInt(log[0]));
        int previous = Integer.parseInt(log[2]); // 记录前一个日志的时间点！！！
        for (int i=1; i<logs.size(); i++) {
            log = logs.get(i).split(":");
            if (log[1].equals("start")) { // case1：start开始函数！！！
                if (!myStack.isEmpty()) {
                    result[myStack.peekFirst()] += (Integer.parseInt(log[2]) - previous); // 累加进前一个(栈顶)函数的结果当中！！！
				}
				myStack.addFirst(Integer.parseInt(log[0])); // 入栈！！！
                previous = Integer.parseInt(log[2]);
            } else { // case2：end结束函数！！！
                result[myStack.peekFirst()] += (Integer.parseInt(log[2]) - previous + 1); // 累加进前一个(栈顶)函数的结果当中！！！
                myStack.removeFirst(); // 出栈！！！
                previous = Integer.parseInt(log[2]) + 1; // 由题目所给例子可知，处理end时都需要加1才符合运算！！！
            }
        }
        return result;
    }
}