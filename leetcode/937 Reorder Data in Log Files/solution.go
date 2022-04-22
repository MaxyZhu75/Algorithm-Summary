func reorderLogFiles(logs []string) []string { // 重写数组排序方法！！！
	sort.SliceStable(logs, func(i, j int) bool { // import sort！！！
		log1 := strings.SplitN(logs[i], " ", 2) // import strings; 以（首个）空格为分隔符，仅分为两部分！！！
		log2 := strings.SplitN(logs[j], " ", 2)
		isDigit1 := unicode.IsDigit(rune(log1[1][0])) // import unicode; 注意输入类型需要强转为rune！！！
		isDigit2 := unicode.IsDigit(rune(log2[1][0]))
		if !isDigit1 && !isDigit2 {
			if log1[1] != log2[1] {
                return log1[1] < log2[1] // 按字典顺序比较两个字符串；小于则返回true！！！
            } else {
                return log1[0] < log2[0]
            }
		} else {
            return !isDigit1 && isDigit2  // 在Go重写排序中，返回true表示该排序规则满足需要（不交换），返回false表示该排序规则不满足需要（交换）！！！
        }
	})
	return logs
}