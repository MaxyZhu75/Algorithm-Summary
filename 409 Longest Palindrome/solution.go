func longestPalindrome(s string) int {
    n := len(s)
    hashRecord := make(map[byte]int)

    for i:=0; i<n; i++ {
        letter := s[i]
        hashRecord[letter]++
    }

    pairs, single := 0, 0
    for _, count := range hashRecord { // ����ɶԵĶ�������
        currentpair := count / 2;
        pairs += currentpair;
    }

    if pairs*2 < n { // ����ɶ�������2С��ԭ�����ȣ���˵�����䵥���ַ�������
        single = 1
    }

    result := 2*pairs + single
    return result
}