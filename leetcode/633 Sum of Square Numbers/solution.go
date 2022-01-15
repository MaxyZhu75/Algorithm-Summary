func judgeSquareSum(c int) bool {
    var p1 int = 0 // Go语言没有long，此处int即可！！！
    var p2 int = int(math.Sqrt(float64(c))) // import math导包；函数math.Sqrt()的S大写，且使用函数时要先转为float64；注意强制转换的写法与java不同！！！
    for p1 <= p2 { // Go语言中用for实现while！！！
        var squareSum int = p1*p1 + p2*p2
        if squareSum == c {
            return true
        } else if squareSum < c {
            p1++
        } else {
            p2--
        }
    }
    return false
}