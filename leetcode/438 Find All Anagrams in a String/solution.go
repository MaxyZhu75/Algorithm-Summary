func findAnagrams(s string, p string) []int { // 滑动窗口！！！
    result := []int{}
    var sCount, pCount [26]int // 注意：此处不能用make创建，因为之后「==」不能比较slice内容！！！
    for i:=0; i<len(p); i++ { // 存储「p」各个字母的数量！！！
        pCount[int(p[i]-'a')]++
    }
    for i:=0; i<len(s); i++ { // 统计大小为「k」的滑动窗口内，「s」各个字母的数量！！！
        sCount[int(s[i]-'a')]++
        if i >= len(p) {
            sCount[int(s[i-len(p)]-'a')]--
        }
        if pCount == sCount { // 比较两数组内容是否相同即可！！！
            result = append(result, i-len(p)+1)
        }
    }
    return result
}