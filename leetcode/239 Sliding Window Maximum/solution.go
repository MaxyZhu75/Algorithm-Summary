func maxSlidingWindow(nums []int, k int) []int { //「双端队列」实现「单调队列」；线性时间完成！！！
    n := len(nums)
    deque := []int{}
    for i:=0; i<k; i++ { // 窗口内第一组元素处理；添加元素的方法在时间上优于堆（优先队列）！！！
        for len(deque) != 0 && nums[i] >= nums[deque[len(deque)-1]] {
            deque = deque[:len(deque)-1] // 当队尾元素小于新来的元素时，必然被直接弹出，不必再考虑该元素；「最大值会被移动到队首」！！！
        }
        deque = append(deque, i) // 存储元素索引！！！
    }

    result := []int{}
    result = append(result, nums[deque[0]])
    for i:=k; i<n; i++ { // 滑动窗口，即对新来的元素遍历！！！
        for len(deque) != 0 && deque[0] <= i-k { // 清理左侧所有不在当前窗口内的元素！！！
            deque = deque[1:]
        }
        for len(deque) != 0 && nums[i] >= nums[deque[len(deque)-1]] {
            deque = deque[:len(deque)-1]
        }
        deque = append(deque, i)

        result = append(result, nums[deque[0]])
    }
    return result
}