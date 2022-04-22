func jump(nums []int) int { // 接近贪心思想！！！
    n := len(nums)
    actualBoundary, currentFurthest, hop := 0, 0, 0 // actualBoundary为每一跳结束后的实际边界；currentFurthest计算当前能跳的最远距离，为下一跳准备！！！！！
    for i:=0; i<n-1; i++ { // 仅遍历需要跳的位置，n-1处已到达终点，不用遍历！！！
        currentFurthest = max(currentFurthest, i+nums[i])
        if i == actualBoundary { // 要点：仅当遍历到实际边界时触发下一跳！！！
            actualBoundary = currentFurthest
            hop++
        }
    }
    return hop
}

func max(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}