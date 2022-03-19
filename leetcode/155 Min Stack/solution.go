type MinStack struct { // ��������Stack���ֵ�������ݣ�ά��minVal����������
	stack []int
	minVal int
	size int
}


func Constructor() MinStack { // ���캯����ʼ����ע���ʽ������
	return MinStack{stack: make([]int, 0), minVal: math.MaxInt64}
}


func (this *MinStack) Push(val int) {
	if this.size == 0 { // ��ջΪ�գ������minValΪ��ǰval������
		this.minVal = val
	}
	
    this.stack = append(this.stack, val - this.minVal) // Ҫ��һ��Stack�ڴ����ֵ�� val - minVal ������
	if this.minVal > val { // �� val-minVal Ϊ����ʱ����Ҫ����minVal��ֵ������
		this.minVal = val // �� val-minVal Ϊ����ʱ����ʱval��ΪminVal�������浽ջ�е�val-minVal��ʵָ����minVal-preMinVal������
	}	
    
    this.size++
}


func (this *MinStack) Pop() {
    if this.stack[this.size-1] < 0 { // Ҫ���������ĩβԪ�ؼ�Ϊջ������ջ��Ԫ��Ϊ��������minVal��Ҫ�ָ���ǰһ�������ĵ�preMinVal��ֵ����minVal��ȥջ����ʵ���ϴ�ʱջ������Ƕ��߲�ֵminVal-preMinVal��������
        this.minVal -= this.stack[this.size-1]
    }

    this.stack = this.stack[:this.size-1] // ɾ������ĩβԪ�أ�������ջ��Ԫ�أ�����
    this.size--
}


func (this *MinStack) Top() int {
    if this.stack[this.size-1] >= 0 {
        return this.minVal + this.stack[this.size-1] // case1����ջ��Ԫ��Ϊ�������򷵻���ֵ = minVal + ջ��Ԫ�أ�val-minVal��������
    } else {
        return this.minVal // case2����ջ��Ԫ��Ϊ�������򷵻���ֵ = minVal������
    }
}


func (this *MinStack) GetMin() int { // ��Сֵ��minValά����ֱ�ӷ��أ�����
    return this.minVal
}


/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */