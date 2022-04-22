func isNumber(s string) bool {
    n, ePosition, result := len(s), -1, false

    for i:=0; i<n; i++ {
        if s[i] == 'e' || s[i] == 'E' {
            if ePosition == -1 {
                ePosition = i // 遍历扫描e的位置并记录！！！
            } else {
                return false // 不能重复出现e！！！
            }
        }
    }

    if ePosition != -1 { // case1: 如果存在e，左侧可以是「整数」或「浮点数」，右侧必须是「整数」！！！
        result = check(s, 0, ePosition-1, false) && check(s, ePosition+1, n-1, true)
    } else {
        result = check(s, 0, n-1, false) // case2: 如果不存在e ，整段可以是「整数」或「浮点数」！！！
    }

    return result
}

func check(s string, start int, end int, mustInteger bool) bool { // 用于判断是否是合法的「整数」或「浮点数」！！！
    if start > end {
        return false
    }
    if s[start] == '+' || s[start] == '-' { // 只有首位可以是符号位！！！
        start++
    }

    hasDot, hasDigit := false, false
    for i:=start; i<=end; i++ {
        if s[i] == '.' { // case1：小数点「.」最多出现一次，且不存在于整数！！！
            if mustInteger || hasDot {
                return false
            }
            hasDot = true
        } else if s[i] >= '0' && s[i] <= '9' { // case2：数字「0~9」至少出现一次！！！
            hasDigit = true;
        } else {
            return false; // case3：若再次出现符号位则不是有效数字！！！
        }
    }
    return hasDigit // 至少存在一个数字！！！
}