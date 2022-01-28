func containsDuplicate(nums []int) bool {
    hashRecord := make(map[int]int)
    for _, num := range nums {
        _, ok := hashRecord[num]
        if ok {
            return true
        } else {
            hashRecord[num] = 1  // 不用计具体出现次数，只用在第一次出现时标记存在即可，第二次出现会直接返回true！！！
        }
    }
    return false
}