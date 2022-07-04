func numFriendRequests(ages []int) int { // 计数 + 前缀和 ！！！
    count := [121]int{}
    for _, age := range ages {
        count[age]++
    }
    pSum := [121]int{}
    for i:=1; i<=120; i++ {
        pSum[i] = pSum[i-1] + count[i]
    }
    result := 0 // 三个条件合并为：0.5*ages[x]+7 < ages[y] <= ages[x] ！！！
    for i:=15; i<=120; i++ { // 已知15岁以下的x是找不到满足上式的y的！！！
        if count[i] > 0 {
            lower := int(i/2 + 7) // 细节：向下取整！！！
            result += count[i] *(pSum[i]-pSum[lower]-1) // 细节：pSum下标与ages下标相差1；末尾减1为减去x本身！！！
        }
    }
    return result
}