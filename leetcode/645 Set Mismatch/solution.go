func findErrorNums(nums []int) []int { // 方法二：桶排序！！！
    n := len(nums)
    result := make([]int, 2)
    for i:=0; i<n; i++ { // 期望满足的关系式：nums[i] = i+1！！！
        for (nums[i] != i+1 && nums[nums[i]-1] != nums[i]) { // 注意此处是while循环；在位置i处以及位置nums[i]-1处皆不满足关系式时，交换元素位置！！！
            swap(nums, i, nums[i]-1)
        }
    }

    for i:=0; i<n; i++ { // 经过之前的交换，数组中仅有两个元素不满足关系式 nums[i] = i+1 ！！！
        if (nums[i] != i+1) {
            result[0], result[1] = nums[i], i+1 // 出问题的地方必是i处；而由于此处期望的元素是i+1，实际却是nums[i]，所以i+1代表缺失元素，nums[i]代表重复元素！！！
        }
    }

    return result
}

func swap(nums []int, i int, j int) {
    temp := nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}