var original string
var regular string

func isMatch(s string, p string) bool { // 复杂的动态规划转移方程；多看官方题解以及宫水三叶的证明！！！
    original = s
    regular = p
    m, n := len(s), len(p)

    d := make([][]bool, m+1) // original第i个字符与regular第j个字符匹配情况！！！
    for i:=0; i<=m; i++ {
        d[i] = make([]bool, n+1)
    }
    d[0][0] = true

    for i:=0; i<=m; i++ {                               // 要点一：填dp表时i从0开始，j从1开始！！！
        for j:=1; j<=n; j++ {
            if regular[j-1] == '*' {                    // case1：regular第j个字符为 * ！！！
                if matches(i, j-1) { 				    // 注意：即使能够匹配 * 也可能选择不替换（替换0个字符）！！！
                    d[i][j] = d[i-1][j] || d[i][j-2]    // 能够匹配，取d[i-1][j]代表决定替换original末尾的字符（此处不必枚举往前替换多少个字符，取dp中 * 可用情况下的前一个状态即可）；取d[i][j-2]代表 * 替换original里的0个字符！！！
                } else {
                    d[i][j] = d[i][j-2]					// 不能够匹配，取d[i][j-2]代表 * 替换original里的0个字符！！！
                }
            } else {                         		    // case2：regular第j个字符为字母或 "." ！！！
                if matches(i, j) {
                    d[i][j] = d[i-1][j-1]				// 取d[i-1][j-1]代表单个普通字符（非*）匹配成功！！！
                } else {
                    d[i][j] = false					    // 单个普通字符（非*）匹配不成功！！！
                }
            }
        }
    }
    return d[m][n];
}

func matches(i int, j int) bool {
    if i == 0 {
        return false // case1：original若为空则必然无法匹配！！！
    }

    if regular[j-1] == '.' { // case2: "." 可以匹配任意字母！！！
        return true
    }

    return original[i-1] == regular[j-1] // case3：两个字母本身相等！！！
}
