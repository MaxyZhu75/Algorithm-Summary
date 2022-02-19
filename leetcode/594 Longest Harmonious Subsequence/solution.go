func findLHS(nums []int) int {
    hashRecord := make(map[int]int)
    for _, num := range nums {
        hashRecord[num]++
    }

    result := 0
    for key, count := range hashRecord {
        if hashRecord[key+1] != 0 {
            b := hashRecord[key+1]
            result = max(result, count+b)
        }
    }

    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}