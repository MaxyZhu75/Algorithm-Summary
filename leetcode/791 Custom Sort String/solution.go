func customSortString(order string, s string) string {
    hashRecord := make(map[byte]int)
    for _, char := range s { // 记录s中每个字符出现次数！！！
        letter := byte(char) // 若为切片遍历此处需要先将rune强制转为byte！！！
        _, ok := hashRecord[letter]
        if ok {
            hashRecord[letter]++
        } else {
            hashRecord[letter] = 1
        }
    }

    result := []byte{}
    for _, char := range order { // 遍历order，按HashMap中的次数依次将出现的字符添加入sb！！！
        letter := byte(char) // 此处需要将rune强制转为byte！！！
        count := hashRecord[letter]
        for count > 0 {
            count--
            result = append(result, letter)
            hashRecord[letter] = 0 // 添加结束后次数置0！！！
        }
    }

    for letter, count := range hashRecord { // 将剩余字符拼接到sb末尾（本题仅要求返回满足性质的的任意排列）！！！
        for count > 0 {
            count--
            result = append(result, letter)
        }
    }

    return string(result)
}