class CustomStack { // 将Increment操作复杂度由O(k)降到O(1)！！！
    int[] stack;
    int top; // 记录栈顶位置！！！
    int[] add; // 记录增量！！！

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.add = new int[maxSize];
        this.top = -1;
    }
    
    public void push(int x) {
        if (top != stack.length-1) {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) return -1;
        int result = stack[top] + add[top];
        if (top != 0) {
			add[top-1] += add[top]; // 栈顶元素被弹出，增量需要往下传递！！！
        }
        add[top] = 0;
        top--;
        return result;
    }
    
    public void increment(int k, int val) { // 调用时只改变栈顶元素的增量！！！
        int limit = Math.min(k-1, top);
        if (limit >= 0) {
			add[limit] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */