func findUnsortedSubarray(nums []int) int { //「正向逆向结合问题」！！！
    n := len(nums) // 将数组视作numsA，numsB，numsC；对numsB进行排序整个数组将有序，说明numsA和numsC有序且未改变！！！
    max, min := math.MinInt32, math.MaxInt32
    right, left := -1, -1
    for i:=0; i<n; i++ { // 正向！！！
        if nums[i] < max {
            right = i // 若有序则右边新来的元素必然改变max，记录下「最后一次」无需改变max的位置为numsB的右边界！！！
        } else {
            max = nums[i]
        }
    }
    for i:=n-1; i>=0; i-- {
        if nums[i] > min {
            left = i // 若有序则左边新来的元素必然改变min，记录下「最后一次」无需改变min的位置为numsB的左边界！！！
        } else {
            min = nums[i]
        }
    }
    if right == -1 {
        return 0
    } else {
        return right-left+1
    }
}