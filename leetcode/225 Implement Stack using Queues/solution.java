class MyStack {
    private static Queue<Integer> queue; // 题目说可以使用两个队列，但此处我们仅用一个队列也可完成！！！
    
    public MyStack() {
        queue = new LinkedList<Integer>(); // 要点一：注意queue的实现类仅两种，即LinkedList和PriorityQueue！！！ 
    }                                      // 实际中java.util.LinkedList可用方法甚多；但该题可用的方法仅包括：add(), remove(), peek(), isEmpty(), size()！！！
    
    public void push(int x) {
        int count = queue.size();
        queue.add(x);
        while (count != 0) { // 要点二：将加入x前队列里的元素依次出队，再依次添加入队；操作后的效果相当于把x添加到了队列的首部！！！
            queue.add(queue.remove());
            count--;
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */