func simplifiedFractions(n int) []string { // 本题关键在于判断是否为最简分数，不能靠记录已出现的i/j，因为“/”运算结果都仅是整除！！！
    result := []string{}

    for i:=2; i<=n; i++ {
        for j:=1; j<i; j++ {
            if gcd(i, j) == 1 { // 正确判断方法：分子分母最大公约数为1，则该分数为最简分数；然后从小到大暴力遍历即可！！！
                fraction := strconv.Itoa(j) + "/" + strconv.Itoa(i)
                result = append(result, fraction)
            }
        }
    }
    return result
}

func gcd(a int, b int) int { // Greatest Common Divisor递归写法！！！
    if b == 0 {
        return a
    } else {
        return gcd(b, a%b)
    }
}