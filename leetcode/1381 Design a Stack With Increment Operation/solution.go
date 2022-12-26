type CustomStack struct { // ����ṹ�壡����
	stack []int
	top int
}

func Constructor(maxSize int) CustomStack { // ����������ʵ��������
	return CustomStack{
		stack : make([]int, maxSize),
		top : -1,
	}
}

func (this *CustomStack) Push(x int) {
	if this.top != len(this.stack)-1 {
		this.top++
        this.stack[this.top] = x
	}
}

func (this *CustomStack) Pop() int {
    if this.top == -1 {
        return -1
    }
    this.top--
    return this.stack[this.top+1]
}

func (this *CustomStack) Increment(k int, val int) { // Increment�������Ӷ���O(k)������
    limit := k
	if k > this.top+1 {
        limit = this.top+1
	}
	for i:=0; i<limit; i++ {
		this.stack[i] += val
	}
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * obj := Constructor(maxSize);
 * obj.Push(x);
 * param_2 := obj.Pop();
 * obj.Increment(k,val);
 */