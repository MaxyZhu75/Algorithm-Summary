type SparseVector struct { // 在 type SparseVector struct 处定义成员变量！！！
    hashRecord map[int]int
}

func Constructor(nums []int) SparseVector { // 构造函数需要返回一个SparseVector的初始化实例！！！
    hashRecord := map[int]int{}
    for i:=0; i<len(nums); i++ {
        if nums[i] != 0 {
            hashRecord[i] = nums[i]
        }
    }
    return SparseVector{hashRecord: hashRecord}
}

// Return the dotProduct of two sparse vectors
func (this *SparseVector) dotProduct(vec SparseVector) int {
    result := 0
    for index, num1 := range this.hashRecord { // 结合下方调用示例理解，this即指v1，vec即指v2！！！
        num2, ok := vec.hashRecord[index]
        if ok {
            result += num1 * num2
        }
    }
    return result
}

/**
 * Your SparseVector object will be instantiated and called as such:
 * v1 := Constructor(nums1);
 * v2 := Constructor(nums2);
 * ans := v1.dotProduct(v2);
 */