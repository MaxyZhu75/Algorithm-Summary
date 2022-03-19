class MinStack {

    private Stack<Integer> dataStack; // ����һ������ջ���ռ临�Ӷ�O(1)��Go���Դ𰸣�����
    private Stack<Integer> minStack;
    private int minVal;

    public MinStack() { // ���캯����ʼ��������
        dataStack = new Stack<>();
        minStack = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        dataStack.push(val);
        minVal = Math.min(minVal, val); // Ҫ��һ��ÿ����ջʱ����minVal����ÿ����minStackѹ����ǵ�ǰminVal������
        minStack.push(minVal);
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
        minVal = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek(); // Ҫ�����minValȡminStackջ��Ԫ�أ�����ջ�����һ��Ԫ�س�ջ��minVal��Ϊ��ʼ������󼴿ɣ�����
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