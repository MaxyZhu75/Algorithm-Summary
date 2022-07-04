func totalFruit(fruits []int) int { // 滑动窗口虫取法！！！
    hashRecord := make(map[int]int)
    k, left, right := 2, 0, 0
    for right < len(fruits) {
        _, ok := hashRecord[fruits[right]]
        if ok {
            hashRecord[fruits[right]]++
        } else {
            hashRecord[fruits[right]] = 1
        }
        if len(hashRecord) > k {
            hashRecord[fruits[left]]--
            if hashRecord[fruits[left]] == 0 {
                delete(hashRecord, fruits[left])
            }
            left++
        }
        right++
    }
    return right-left
}