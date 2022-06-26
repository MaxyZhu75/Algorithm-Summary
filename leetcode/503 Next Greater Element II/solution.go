func nextGreaterElements(nums []int) []int { // 把循环数组「拉直」：对下标取模，相当于将数组复制拼接在尾部！！！
    n := len(nums)
    stack := []int{}
    result := make([]int, n)
    for i:=2*n-1; i>=0; i-- { //「反向」：为左边新来的元素找到右侧第一个更小的元素！！！
        for len(stack) > 0 && nums[i%n] >= stack[len(stack)-1] {
            stack = stack[:len(stack)-1]
        }
        if len(stack) > 0 {
            result[i%n] = stack[len(stack)-1]
        } else {
            result[i%n] = -1; // 注意默认为-1！！！
        }
        stack = append(stack, nums[i%n])
    }

    return result
}