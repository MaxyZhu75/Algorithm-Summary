class MyQueue {
    private static Stack<Integer> in; // Ҫ��һ��in��out����ջʵ�ֶ��У��˴�������������
    private static Stack<Integer> out; // java.util.Stack�������ʹ�õķ���������empty(), peek(), push(obj), pop(), search(obj)������

    public MyQueue() {
        in = new Stack<Integer>(); // Ҫ��������캯������newΪ����ջ����ʵ�ʵĴ洢�ռ䣡����
        out = new Stack<Integer>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(!out.empty()) {
            return out.pop();
        } else {
            in2out();
            return out.pop();
        }
    }
    
    public int peek() {
        if(!out.empty()) {
            return out.peek();
        } else {
            in2out();
            return out.peek();
        }
    }
    
    public boolean empty() {
        return in.empty() && out.empty();
    }

    public void in2out() { // Ҫ��������Ҫ����in2out()������������������ʵ�֣�����
        while (!in.empty()) {
            out.push(in.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */