func findClosest(words []string, word1 string, word2 string) int { // �����ռ�һ�α���������
    n := len(words)
    result := n
    previous1, previous2 := -1, -1 // ��¼�Ѿ������ĵ����У����һ�γ��ֵ�word1��word2���±꣡����
    for i:=0; i<n; i++ {
        if words[i] == word1 { // case1������word1������previous1��ֵ������
            previous1 = i
        } else if words[i] == word2 {{ // case2������word2������previous2��ֵ������
            previous2 = i
        }
        if previous1 >= 0 && previous2 >= 0 { // ÿ��ѭ������Ҫ����result������
            result = min(result, abs(previous1-previous2))
        }
    }
    return result
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}

func abs(n int) int { // ��дint����abs����������
    if n >= 0 {
        return n
    } else {
        return -1 * n
    }
}