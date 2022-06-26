class MedianFinder { // ˫��ά������λ�������Ż���ʹ��˫ָ�룡����
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>((o1, o2) -> o2 - o1); //���󶥶ѡ��洢��С����λ�������֡�������
        larger = new PriorityQueue<>((o1, o2) -> o1 - o2); //��С���ѡ��洢��������λ�������֡�������
    }
    
    public void addNum(int num) {
        if (smaller.isEmpty() || num <= smaller.peek()) { // case1��numС�ڵ��ڵ�ǰ��λ��������
            smaller.add(num);
            if (larger.size()+1 < smaller.size()) {
                larger.add(smaller.poll());
            }
        } else { // case2��num���ڵ�ǰ��λ��������
            larger.add(num);
            if (larger.size() > smaller.size()) {
                smaller.add(larger.poll());
            }
        }
    }
    
    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek(); // ������Ϊ����ʱ��smaller�е�����larger�ж�һ������ʱ��λ��Ϊ��smaller�Ѷ���������
        } else {
			return (smaller.peek() + larger.peek()) / 2.0; // ������Ϊż��ʱ��smaller��larger��������ͬ����ʱ��λ��Ϊ��smaller��larger�Ѷ��ľ�ֵ��������
		}
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */