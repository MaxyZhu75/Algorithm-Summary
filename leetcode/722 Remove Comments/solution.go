func removeComments(source []string) []string { // 分情况处理！！！
    inBlock := false
    sb := ""
    result := []string{}
    for _, line := range source {
        if (!inBlock) {
            sb = "" // 读取每行代码时（非注释）要重置sb！！！
        }
        i := 0
        for i < len(line) {
            if !inBlock && i+1<len(line) && line[i] == '/' && line[i+1] == '*' {
                inBlock = true // case1：不在注释中且遇到/*，则跳过接下来的两个字符，并将状态更改为在注释中！！！
                i++
            } else if inBlock && i+1<len(line) && line[i] == '*' && line[i+1] == '/' {
                inBlock = false // case2：在注释中且遇到*/，则跳过接下来的两个字符，并将状态更改为不在注释中！！！
                i++
            } else if !inBlock && i+1<len(line) && line[i] == '/' && line[i+1] == '/' {
                break; // case3：不在注释中且遇到//，根据优先级则忽略该行的其余部分直接break！！！
            } else if !inBlock {
                sb = sb + string(line[i]) // case4：有效代码，需要记录！！！
            }
            i++
        }
        if !inBlock && len(sb) > 0 { // 该行记录结束，判断是否需要添加到结果！！！
            result = append(result, sb)
        }
    }
    return result
}