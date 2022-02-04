func uncommonFromSentences(s1 string, s2 string) []string {
     wordList1 := strings.Split(s1, " ") // Go语言字符串分割操作！！！
     wordList2 := strings.Split(s2, " ")
     result := []string{} // 定义空数组！！！

     hashRecord := make(map[string]int)
     for _, word := range wordList1 {
         hashRecord[word]++ // Go语言map可以直接这样记录（有点像数组的写法）！！！
     }
     for _, word := range wordList2 {
         hashRecord[word]++
     }

    for word, frequency := range hashRecord {
        if frequency == 1 {
            result = append(result, word) // Go语言在数组末尾添加元素记得用append()！！！
        }
    }

    return result
}