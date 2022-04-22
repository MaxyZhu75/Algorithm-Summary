func lengthOfLongestSubstring(s string) int { // ע�⣺�ִ���Ҫ�����������в���Ҫ����������
    n, result := len(s), 0
    hashSet := map[byte]bool{} // ��סGo����HashSetд��������

    right := 0 // Ҫ�㣺�������ڵ��Ҷ��ǲ���Ҫ�����˵ģ�����
    for left:=0; left<n; left++ {
        if left > 0 {
            delete(hashSet, s[left-1]) // ÿ���ƶ���ˣ���Ҫ��ǰһ����ĸ��HashSet���õ�������
        }
        for right < n && hashSet[s[right]] == false {
            hashSet[s[right]] = true
            right++
        }
        result = max(result, right-left)
    }
    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}