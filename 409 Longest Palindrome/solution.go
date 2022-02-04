func longestPalindrome(s string) int {
    n := len(s)
    hashRecord := make(map[byte]int)

    for i:=0; i<n; i++ {
        letter := s[i]
        hashRecord[letter]++
    }

    pairs, single := 0, 0
    for _, count := range hashRecord { // 计算成对的对数！！
        currentpair := count / 2;
        pairs += currentpair;
    }

    if pairs*2 < n { // 如果成对数量乘2小于原本长度，则说明有落单的字符！！！
        single = 1
    }

    result := 2*pairs + single
    return result
}