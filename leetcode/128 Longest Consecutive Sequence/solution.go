func longestConsecutive(nums []int) int { // 线性时间完成；哈希表！！！
    hashRecord := map[int]bool{}
    for _, num := range nums { // 存储索引元素且去重！！！
        hashRecord[num] = true
    }
    result := 0
    for num, _ := range hashRecord {
        if !hashRecord[num-1] { // 结论：若发现原数组存在num-1，则无需枚举以num为开头的连续序列结果（此时num必然已经被访问过）！！！
			current := num
            count := 1
            for hashRecord[current+1] { // 统计当前最长序列长度！！！
                current++
                count++
            }
            if result < count {
                result = count
            }
        }
    }
    return result
}