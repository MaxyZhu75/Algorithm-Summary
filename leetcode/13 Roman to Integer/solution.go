func romanToInt(s string) int {
    hashRecord := map[byte]int{'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
    
    result, currentVal, nextVal := 0, 0, 0
    for i:=0; i<len(s)-1; i++ {
        currentVal, nextVal = hashRecord[s[i]], hashRecord[s[i+1]]
        if currentVal < nextVal {
            result -= currentVal // case1: 小的数字在大的数字的左边，由规则可知仅有6种情况，在答案中减去该小的数字即可！！！
        } else {
            result += currentVal // case2: 小的数字在大的数字的右边，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可！！！
        }
    }
    result += hashRecord[s[len(s)-1]] // 末尾数字的值必然需要加入答案！！！
    return result
}