func minimumHealth(damage []int, armor int) int64 { // 贪心抵消max或armor的伤害！！！
    sum, max := 0, 0
    for _, current := range damage {
        sum += current
        max = maxTwo(max, current)
    }
    return int64(sum - minTwo(max, armor) + 1) // 存活需要剩一滴血！！！
}

func maxTwo(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}

func minTwo(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}