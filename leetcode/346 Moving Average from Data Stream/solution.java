class MovingAverage { // ���������ѭ�����У�����
	int size;
	int head = 0, tail = 0;
	int windowSum = 0;
	int count = 0;
	int[] circularQueue;
  
	public MovingAverage(int size) {
		this.size = size;
		this.circularQueue = new int[size];
	}

	public double next(int val) {
		count++;
		tail = (head+1) % size;
		windowSum -= circularQueue[tail]; // ɾ�����Ԫ�أ�����
		
		head = (head+1) % size;
		circularQueue[head] = val; // ����µ�Ԫ�أ�����
		windowSum += val;
		return windowSum * 1.0 / Math.min(size, count);
	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */