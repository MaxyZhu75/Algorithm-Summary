class MyStack {
    private static Queue<Integer> queue; // ��Ŀ˵����ʹ���������У����˴����ǽ���һ������Ҳ����ɣ�����
    
    public MyStack() {
        queue = new LinkedList<Integer>(); // Ҫ��һ��ע��queue��ʵ��������֣���LinkedList��PriorityQueue������ 
    }                                      // ʵ����java.util.LinkedList���÷������ࣻ��������õķ�����������add(), remove(), peek(), isEmpty(), size()������
    
    public void push(int x) {
        int count = queue.size();
        queue.add(x);
        while (count != 0) { // Ҫ�����������xǰ�������Ԫ�����γ��ӣ������������ӣ��������Ч���൱�ڰ�x��ӵ��˶��е��ײ�������
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