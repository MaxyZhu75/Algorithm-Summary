class MedianFinder { // 双堆维护「中位数」；优化是使用双指针！！！
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>((o1, o2) -> o2 - o1); //「大顶堆」存储「小于中位数的数字」！！！
        larger = new PriorityQueue<>((o1, o2) -> o1 - o2); //「小顶堆」存储「大于中位数的数字」！！！
    }
    
    public void addNum(int num) {
        if (smaller.isEmpty() || num <= smaller.peek()) { // case1：num小于等于当前中位数！！！
            smaller.add(num);
            if (larger.size()+1 < smaller.size()) {
                larger.add(smaller.poll());
            }
        } else { // case2：num大于当前中位数！！！
            larger.add(num);
            if (larger.size() > smaller.size()) {
                smaller.add(larger.poll());
            }
        }
    }
    
    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek(); // 当数量为奇数时，smaller中的数比larger中多一个，此时中位数为「smaller堆顶」！！！
        } else {
			return (smaller.peek() + larger.peek()) / 2.0; // 当数量为偶数时，smaller与larger中数量相同，此时中位数为「smaller与larger堆顶的均值」！！！
		}
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */