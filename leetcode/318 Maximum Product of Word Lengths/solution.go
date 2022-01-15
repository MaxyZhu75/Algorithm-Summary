func maxProduct(words []string) int {
    var n int = len(words)
    var wordBits [1000] int // 注意按这种方式创建数组时数组大小必须写常量，若写n则会报错！！！
    for i, word := range words { 
        for _, letter := range word { // 迭代器的使用，此处不需要像java一样使用toCharArray()来遍历各个单词中的字母！！！
            wordBits[i] |= 1<<(letter-'a') // 技巧：小写字母-‘a’后变为数字，不同字母对1的左移各不相同；可用“|”或运算记录每个字母的出现！！！
        }
    }

    var maxLen int = 0
    for i:=0; i<n; i++ {
        for j:=i+1; j<n; j++ {
            if (wordBits[i]&wordBits[j])==0 { // 注意若不加括号则优先算后面wordBits[j]==0，整个条件则报错！！！
                maxLen = maxNum(maxLen, len(words[i])*len(words[j]))
            }
        }
    }
    return maxLen
}

func maxNum(a int, b int) int {
    if a>b {
        return a
    } else {
        return b
    }
}