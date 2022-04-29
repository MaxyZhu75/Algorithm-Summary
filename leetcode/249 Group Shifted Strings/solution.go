func groupStrings(strings []string) [][]string { // 哈希表存储字母之间的差值！！
    hashRecord := make(map[string][]string) // 存储形式：{由字母表示的差值，差值相同的组合}；hashRecord["cd"] = ["acf", "gil", "xzc"]！！！
    for _, s := range strings {
        hashKey := getHash(s) // 重写哈希值计算！！！
        if hashRecord[hashKey] == nil {
            hashRecord[hashKey] = []string{}
        }
        hashRecord[hashKey] = append(hashRecord[hashKey], s)
    }

    result := [][]string{}
    for _, group := range hashRecord { // 字母间差值相同的已经分到同一组，将每组加入答案！！！
        result = append(result, group)
    }
    return result
}

func getHash(s string) string { // 计算字符串每个字符之间的差值后表示为字符串；如["acf", "gil", "xzc"]都相差[2,3]，转换成英文字母表示则为[c,d]！！！
    hashValue := []byte{}
    for i:=1; i<len(s); i++ {
        hashValue = append(hashValue, byte((s[i]-s[i-1]+26) % 26 + 'a')) // 计算差值要考虑字母表循环，需要手动 +26 再 %26 ！！！
    }
    return string(hashValue)
}