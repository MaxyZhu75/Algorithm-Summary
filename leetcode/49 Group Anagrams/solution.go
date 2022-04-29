func groupAnagrams(strs []string) [][]string { // 哈希表+排序！！！
    hashRecord := make(map[string][]string) // 存储方式为(排序后的str，原str列表)！！！
    for _, str := range strs {
        letters := []byte(str)
        sort.Slice(letters, func(i int, j int) bool { // 重写数组字典序排序！！！
            return letters[i] < letters[j]
        })
        key := string(letters)
        hashRecord[key] = append(hashRecord[key], str)
    }

    result := make([][]string, 0, len(hashRecord))
    for _, group := range hashRecord {
        result = append(result, group)
    }
    return result
}