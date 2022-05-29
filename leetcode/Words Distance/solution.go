func findClosest(words []string, word1 string, word2 string) int { // 常数空间一次遍历！！！
    n := len(words)
    result := n
    previous1, previous2 := -1, -1 // 记录已经遍历的单词中，最后一次出现的word1与word2的下标！！！
    for i:=0; i<n; i++ {
        if words[i] == word1 { // case1：遇到word1，更新previous1的值！！！
            previous1 = i
        } else if words[i] == word2 {{ // case2：遇到word2，更新previous2的值！！！
            previous2 = i
        }
        if previous1 >= 0 && previous2 >= 0 { // 每次循环都需要更新result！！！
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

func abs(n int) int { // 手写int类型abs函数！！！
    if n >= 0 {
        return n
    } else {
        return -1 * n
    }
}