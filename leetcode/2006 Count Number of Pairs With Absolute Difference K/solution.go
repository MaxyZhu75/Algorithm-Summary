func countKDifference(nums []int, k int) int { // LeetCode第一题两数之和变体；用哈希表+一次遍历！！！
    result := 0
    hashRecord := make(map[int]int)
    for _, num := range nums {
        result += hashRecord[num+k] + hashRecord[num-k] // 此处由getOrDefault()代替containsKey()更方便简洁！！！
    }
    return result
}