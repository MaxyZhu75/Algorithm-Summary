class MyQueue {
    private static Stack<Integer> in; // 要点一：in和out两个栈实现队列，此处先声明！！！
    private static Stack<Integer> out; // java.util.Stack本身可以使用的方法包括：empty(), peek(), push(obj), pop(), search(obj)！！！

    public MyQueue() {
        in = new Stack<Integer>(); // 要点二：构造函数里用new为两个栈开辟实际的存储空间！！！
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

    public void in2out() { // 要点三：需要增加in2out()方法辅助其他方法的实现！！！
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