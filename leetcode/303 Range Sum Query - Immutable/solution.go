type NumArray struct { // 该题考察的是前缀和，以及已知多次调用某一函数，如何进行时间优化的问题！！！
    D []int // 定义一个dp表存储前缀和；前缀和即该元素前面所有元素的和（不包括该元素）！！！
}


func Constructor(nums []int) NumArray { // 已知构造函数只调用一次，而sumRange()会调用多次；因此相比于在sumRange()中写循环相加，此处在构造函数中用for循环填dp表来保存前缀和能明显优化时间！！！
    var n int = len(nums)
    D := make([]int, n+1) // 初始化注意dp表的大小，防止溢出！！！
    D[0] = 0
    for i, num := range nums {
        D[i+1] = D[i] + num // 简易dp方程！！！
    }
    return NumArray{D} // Go语言中此处构造函数需要返回！！！
}


func (this *NumArray) SumRange(left int, right int) int {
    return this.D[right+1] - this.D[left]  // 由前缀和的定义直接返回；Go语言面向对象注意使用receiver进行调用！！！ 
}


/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */