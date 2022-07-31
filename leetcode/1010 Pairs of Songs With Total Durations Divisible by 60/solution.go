func numPairsDivisibleBy60(time []int) int {
    count := [60]int{}
    pair := 0
    for i:=0; i<len(time); i++ {
        remainder := time[i] % 60
        if remainder == 0 {
            pair += count[0]
        } else {
            pair += count[60-remainder] // 余数之和为60的组队！！！
        }
        count[remainder]++
    }
    return pair
}