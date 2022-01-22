func containsNearbyDuplicate(nums []int, k int) bool { // 方法一：普通哈希表解决！！！
    var n int = len(nums)
    hashRecord := make (map[int]int)
    for i:=0; i<n; i++ {
        maxIndex, ok := hashRecord[nums[i]] // 熟悉该常用写法！！！
        if ok {
            abs := i-maxIndex // 虽然该题描述为需满足相同元素的索引绝对值小于k，但由于我们按索引顺序由小到大，且值相同的数组元素每次循环会记录当前最大的索引，故能保证nums[maxIndex]是最接近nums[i]的值相同的数组元素！！！
            if abs <= k {
                return true
            }
        } 
        hashRecord[nums[i]] = i // 每次循环的最后都必须更新值为nums[i]的元素的最大索引（即为i）！！！
    }
    return false
}