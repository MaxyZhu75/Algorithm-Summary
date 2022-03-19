type MinStack struct { // 方法二：Stack存差值不存数据，维护minVal变量！！！
	stack []int
	minVal int
	size int
}


func Constructor() MinStack { // 构造函数初始化，注意格式！！！
	return MinStack{stack: make([]int, 0), minVal: math.MaxInt64}
}


func (this *MinStack) Push(val int) {
	if this.size == 0 { // 若栈为空，则更新minVal为当前val！！！
		this.minVal = val
	}
	
    this.stack = append(this.stack, val - this.minVal) // 要点一：Stack内存入的值是 val - minVal ！！！
	if this.minVal > val { // 当 val-minVal 为正数时不需要更新minVal的值！！！
		this.minVal = val // 当 val-minVal 为负数时，此时val即为minVal，被保存到栈中的val-minVal其实指的是minVal-preMinVal！！！
	}	
    
    this.size++
}


func (this *MinStack) Pop() {
    if this.stack[this.size-1] < 0 { // 要点二：数组末尾元素即为栈顶；若栈顶元素为负数，则minVal需要恢复成前一个被更改的preMinVal的值，即minVal减去栈顶（实际上此时栈保存的是二者差值minVal-preMinVal）！！！
        this.minVal -= this.stack[this.size-1]
    }

    this.stack = this.stack[:this.size-1] // 删除数组末尾元素，即弹出栈顶元素！！！
    this.size--
}


func (this *MinStack) Top() int {
    if this.stack[this.size-1] >= 0 {
        return this.minVal + this.stack[this.size-1] // case1：若栈顶元素为正数，则返回数值 = minVal + 栈顶元素（val-minVal）！！！
    } else {
        return this.minVal // case2：若栈顶元素为负数，则返回数值 = minVal！！！
    }
}


func (this *MinStack) GetMin() int { // 最小值由minVal维护，直接返回！！！
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