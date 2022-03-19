class MinStack {

    private Stack<Integer> dataStack; // 方法一：辅助栈；空间复杂度O(1)见Go语言答案！！！
    private Stack<Integer> minStack;
    private int minVal;

    public MinStack() { // 构造函数初始化！！！
        dataStack = new Stack<>();
        minStack = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        dataStack.push(val);
        minVal = Math.min(minVal, val); // 要点一：每次入栈时更新minVal，且每次往minStack压入的是当前minVal！！！
        minStack.push(minVal);
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
        minVal = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek(); // 要点二：minVal取minStack栈顶元素；若是栈中最后一个元素出栈，minVal置为初始的无穷大即可！！！
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */