func countGoodRectangles(rectangles [][]int) int {
    maxLen, count := 0, 0 // 变量维护！！！
    for _, rectangle := range rectangles {
        currentLen := min(rectangle[0], rectangle[1]) // 必然是按矩形短边长度切正方形！！！
        if currentLen == maxLen {
            count++
        }
        if currentLen > maxLen {
            maxLen = currentLen
            count = 1
        }
    }
    return count
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}