func reorganizeString(s string) string { // 贪心交叉填数解决；正确性证明见官方解答！！！
    n := len(s)
    if n <= 1 {
        return s
    }

    record := make([]int, 26) // 统计各个字符出现次数及，单个字符最大出现次数！！！
    maxCount := 0
    for _, c := range s {
        record[c-'a']++
        if record[c-'a'] > maxCount {
            maxCount = record[c-'a']
        }
    }

    if maxCount > (n+1)/2 { // 当n是偶数，单个字母的出现次数都不能超过n/2次；当n是奇数，单个字母的出现次数都不能超过(n+1)/2次！！！
        return "" // 对于偶数，n/2与(n+1)/2相等，故简化判断条件！！！
    }

    reorganized := make([]byte, n) // 奇偶下标交叉填数，故使用字符数组！！！
    even, odd := 0, 1
    for i, count := range record {
        letter := byte('a' + i)
        for count > 0 && count <= n/2 && odd < n { // 要点：当n是奇数且maxCount=(n+1)/2时，出现最多的字母必须全部放置在偶数下标；其余情况任意！！
            reorganized[odd] = letter
            count--
            odd += 2
        }
        for count > 0 { // 将record剩余字符拿出填完即可！！！
            reorganized[even] = letter
            count--
            even += 2
        }
    }
    return string(reorganized)
}