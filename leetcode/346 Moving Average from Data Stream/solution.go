type MovingAverage struct { // 基于数组的循环队列！！！
    Size int
    Head int
    Tail int
    windowSum int
    Count int
    circularQueue []int
}

func Constructor(size int) MovingAverage {
    return MovingAverage {
        Size: size,
        Head: 0,
        Tail: 0,
        windowSum: 0,
        Count: 0,
        circularQueue: make([]int, size),
    }
}


func (this *MovingAverage) Next(val int) float64 {
    this.Count++
    this.Tail = (this.Head+1) % this.Size
    this.windowSum -= this.circularQueue[this.Tail] // 删除最旧元素！！！

    this.Head = (this.Head+1) % this.Size
    this.circularQueue[this.Head] = val // 添加新的元素！！！
    this.windowSum += val
    return float64(this.windowSum) / float64(min(this.Size, this.Count))
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}


/**
 * Your MovingAverage object will be instantiated and called as such:
 * obj := Constructor(size);
 * param_1 := obj.Next(val);
 */