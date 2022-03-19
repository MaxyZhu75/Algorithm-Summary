func subarraySum(nums []int, k int) int { // 前缀和+哈希表！！！
    prefixSum, result := 0, 0
    hashRecord := map[int]int{}
    hashRecord[0] = 1
    for i:=0; i<len(nums); i++ {
        prefixSum += nums[i]
        count, ok := hashRecord[prefixSum-k] // 要点：查询获取的是前缀和为 prefixSum - k 的数量！！！
        if ok {
            result += count
        }
        hashRecord[prefixSum] += 1
    }
    return result
}