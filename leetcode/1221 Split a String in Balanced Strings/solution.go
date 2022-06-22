func balancedStringSplit(s string) int { // 贪心；正确性证明见官方题解！！！
    count, balance := 0, 0
    for i:=0; i<len(s); i++ {
        if s[i] == 'L' { // L则balance++！！！
            balance++
        } else {
            balance-- // R则balance--！！！
        }
        if balance == 0 { // 贪心地添加每次平衡状态；此时剩余部分必然仍是平衡字符串！！！
            count++
        }
    }
    return count
}