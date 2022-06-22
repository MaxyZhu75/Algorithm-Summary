func dailyTemperatures(temperatures []int) []int { // 经典单调栈！！！
    n := len(temperatures)
    result := make([]int, n)
    stack := []int{} //「栈顶到栈底温度依次递增」！！！
    for i:=0; i<n; i++ {
        for len(stack) != 0 && temperatures[i] > temperatures[stack[len(stack)-1]] { // 原先栈内可能有多个温度小于新来的，都需要标记后出栈！！！
            index :=  stack[len(stack)-1]
            stack = stack[:len(stack)-1]
            result[index] = i - index 
        }
        stack = append(stack, i)
    }
    return result
}