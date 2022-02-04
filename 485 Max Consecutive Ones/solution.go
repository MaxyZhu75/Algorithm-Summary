func findMaxConsecutiveOnes(nums []int) int {
    max, count := 0, 0
    for _, num := range nums {
        if num == 0 {
            count = 0
        } else {
            count++
            max = twoMax(max, count)
        }
    }
    return max
}

func twoMax(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}