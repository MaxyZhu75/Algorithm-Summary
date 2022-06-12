func findPeakElement(nums []int) int { // 此题求极大值而不是最大值；二分查找正确性证明见官方解答；此题展示了二段性而不是单调性！！！
    low, high := 0, len(nums)-1
    for low < high { // 本题二段性：根据nums[mid]与[mid±1]的大小关系，可以确定其中一段满足「必然有解」！！！
        mid := (high-low)/2 + low
        if nums[mid] < nums[mid+1] { // 具体地，选择大于边界一端进行二分，可以确保选择的区间一定存在峰值！！！
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
}