func validWordAbbreviation(word string, abbr string) bool { // 要点：对数字的处理！！！
    n := len(word)
    pointer, digit := 0, 0 // word中的指针；abbr中的数字！！！
    for i, letter := range abbr {
        if letter == '0' && digit == 0 { // case1：存在前导0；digit等于0说明前一个字符不是数字是字母！！！
            return false;
        }
        if letter >= '0' && letter <= '9' { // case2：合理数字；按照如下写法则可以顺利统计多位合理数字！！！
            digit = digit * 10 + int(letter-'0')
        } else { // case3：合理字母！！！
            pointer += digit // 将word中指针移动，然后digit需要清零！！！
            digit = 0
            if pointer >= n || word[pointer] != abbr[i] { // 指针越界或字母不匹配说明缩写不合理，直接返回；注意letter为rune类型，此处不便直接使用！！！
                return false
            }
            pointer++
        }
    }
    return digit == n - pointer // 缩写末尾的数字并未验证，需要在循环外验证！！！
}