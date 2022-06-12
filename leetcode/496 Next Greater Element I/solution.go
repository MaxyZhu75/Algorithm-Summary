func nextGreaterElement(nums1 []int, nums2 []int) []int { //「单调栈」解决「子集下一个更大元素问题」！！！
    hashRecord := make(map[int]int) // 记录形式：<nums2[i], 右边下一个更大的元素值>！！！
    stack := []int{}
    for i:=len(nums2)-1; i>=0; i-- { // 倒序遍历nums2！！！
        for len(stack) > 0 && stack[len(stack)-1] <= nums2[i] { // 出栈条件：栈顶元素小于等于当前元素（维护单调栈）！！！
            stack = stack[:len(stack)-1]
        }
        if len(stack) > 0 { // 栈为空说明右侧没有比当前元素更大的！！！
            hashRecord[nums2[i]] = stack[len(stack)-1]
        } else {
            hashRecord[nums2[i]] = -1;
        }
        stack = append(stack, nums2[i]) // 每次需要入栈操作！！
    }
    result := []int{}
    for _, num := range nums1 {
        result = append(result, hashRecord[num])
    }
    return result
}