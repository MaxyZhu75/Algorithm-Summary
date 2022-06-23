func nextGreaterElement(nums1 []int, nums2 []int) []int { //「单调栈」解决「子集下一个更大元素问题」！！！
    hashRecord := make(map[int]int) // 记录形式：<nums2[i], 右边下一个更大的元素值>！！！
    stack := []int{}
    for i:=len(nums2)-1; i>=0; i-- { //「反向」：为左边新来的元素找到右侧第一个更小的元素！！！
        for len(stack) > 0 && nums2[i] >= stack[len(stack)-1] {
            stack = stack[:len(stack)-1]
        }
        if len(stack) > 0 { // 栈为空说明右侧没有比当前元素更大的！！！
            hashRecord[nums2[i]] = stack[len(stack)-1]
        } else {
            hashRecord[nums2[i]] = -1; // 注意默认为-1！！！
        }
        stack = append(stack, nums2[i])
    }

    result := []int{} // 添加结果！！！
    for _, num := range nums1 {
        result = append(result, hashRecord[num])
    }
    return result
}
