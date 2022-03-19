func minRemoveToMakeValid(s string) string { // 方法二：两个结果数组；先删除右括号，再删除右边未匹配的左括号！！！
    tempResult := []byte{}
    leftSum := 0 // 记录左括号总数！！！
    leftRemain := 0 // 记录待匹配左括号数量！！！
    
    for i:=0; i<len(s); i++ {
        if s[i] == '(' { // 左括号进行统计！！！
            leftSum++
            leftRemain++
        } else if s[i] == ')' { // 右括号分情况处理！！！
            if leftRemain == 0 {
                continue // case1：没有待匹配的左括号，则直接continue，相当于将该右括号删除（未append）！！！
            } else {
                leftRemain-- // case2：匹配成功，待匹配左括号数量减1！！！
            }
        }
        tempResult = append(tempResult, s[i])
    }

    result := []byte{}
    leftNum := leftSum - leftRemain // 最终需要填加的左括号数量！！！
    for i:=0; i<len(tempResult); i++ {
        if (tempResult[i] == '(') {
            if leftNum == 0 { // 无需再添加左括号，相当于接下来右边出现的左括号都会被删除！！！
                continue
            } else {
                leftNum--
            }
        }
        result = append(result, tempResult[i])
    }

    return string(result)
}