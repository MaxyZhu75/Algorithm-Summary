func compressString(S string) string {
    n := len(S)
    if n <= 1 {
        return S
    }

    previous := S[0]; // Go语言中string根据索引取字符很方便！！！
    count := 1;
    result := "" // 由于byte和int转换麻烦，字符切片[]byte不便于添加数字，此处应该直接定义string空字符串！！！

    for i:=1; i<n; i++ {
        if S[i] == previous {
            count++
        } else {
            result = result + string(previous) // 将byte强转为string类型直接用 "+" 添加！！！
            byteCount := strconv.Itoa(count) // import "strconv"；字符串方法Itoa()可将int转为string！！！
            result = result + byteCount
            count = 1
            previous = S[i]
        }
    }

    result = result + string(previous) // 最后一组字符循环中未添加！！！
    byteCount := strconv.Itoa(count)
    result = result + byteCount

    if len(result) >= n {
        return S
    }

    return result
}