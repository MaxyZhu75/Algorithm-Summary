var result []string // 回溯经典题目，回溯属于DFS问题，需要统计排列组合的各种情况时可用回溯解决！！！
var sb string // 要点一：可将结果变量等提前声明！！！

func letterCombinations(digits string) []string {
    result = []string{}
    sb = "" 
    if len(digits) == 0 {
        return result
    }
    dfsBackTrack(digits)
    return result
}

func dfsBackTrack(digits string) { // 无返回值，直接对定义的结果变量操作！！！
    letters := [10]string {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}

    if len(sb) == len(digits) { // 递归左右出口！！！
        result = append(result, sb)
        return
    }

    position := len(sb) // 最后删除末尾字母时不能用position变量来表示sb.length()，因为递归后的变量含义已经不一样，这一点要小心！！！
    curretDigit := digits[position] - '0'
    curretletters := letters[curretDigit]
    for i:=0; i<len(curretletters); i++ { // 要点二：DFS移动过程中包括三个重要处理步骤，且必须按顺序执行！！！
        sb = sb + string(curretletters[i]) // 处理一：标记已访问；本题主要由sb.length()控制，添加字母后sb长度改变，相当于标记访问！！！
        dfsBackTrack(digits) // 处理二：dfs往下递归！！！
        sb = sb[:len(sb)-1] // 处理三：标记未访问；本题主要由sb.length()控制，删除最后一个字母后sb长度改变，相当于标记未访问！！！
    }
}