func longestValidParentheses(s string) int { // 保持一定特性的栈！！！
    result := 0 // 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，栈里其他元素维护「左括号的下标」！！！
    stack := []int{}
    stack = append(stack, -1) // 若第一个为左括号则不满足栈底是右括号下标的性质，故遍历前先压入-1！！！ 
    for i:=0; i<len(s); i++ {
        if s[i] == '(' { // case1：左括号下标直接入栈！！！
            stack = append(stack, i)
        } else { // case2：右括号则先弹出栈顶！！！
            stack = stack[:len(stack)-1]
            if len(stack) == 0 {
                stack = append(stack, i) // 若栈为空则将当前右括号索引压入；非空则更新「最长有效括号的长度」！！！
            } else {
                result = max(result, i-stack[len(stack)-1])
            }
        }
    }
    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}