func findBuildings(heights []int) []int { // 从后向前遍历，贪心地加入海景房即可；注意输出对顺序有要求，所以使用Stack数据结构！！！
    n := len(heights)
    myStack := []int{n-1}
    highest := heights[n-1]
    for i:=n-2; i>=0; i-- {
        if heights[i] > highest {
            myStack = append(myStack, i)
            highest = heights[i]
        }
    }

    m := len(myStack)
    result := []int{}
    for i:=m-1; i>=0; i-- {
        result = append(result, myStack[i])
    }
    return result
}