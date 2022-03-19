type Solution struct { // 前缀和 + 二分查找 ！！！
    prefixSum []int
}


func Constructor(w []int) Solution { // 构造函数，按Solution类型的结构体返回！！！
    prefixSum := make([]int, len(w))
    prefixSum[0] = w[0]
    for i:=1; i<len(w); i++ {
        prefixSum[i] = prefixSum[i-1] + w[i] // 填写dp表的方式将前缀和填写完整！！
    }
    return Solution{prefixSum}
}


func (this *Solution) PickIndex() int { // 我们已将区间[1, weightSum]看作n个部分，若此次随机选择索引为i的元素，随机数需要落在区间[prefixSum[i]-w[i]+1, prefixSum[i]]！！！
    n := len(this.prefixSum)
    weightSum := this.prefixSum[n-1] // 获取权重之和，并在[1, weightSum]中取随机数！！！
    randomNum := rand.Intn(weightSum) + 1 // import rand；Intn(n int)返回区间[0, n)的伪随机数！！！
    return sort.SearchInts(this.prefixSum, randomNum) // import sort；SearchInts(a []int, x int) int 返回区间整型数组a中元素x的索引！！！
}


/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(w);
 * param_1 := obj.PickIndex();
 */