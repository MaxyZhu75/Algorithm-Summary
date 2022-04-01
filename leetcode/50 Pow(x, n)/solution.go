func myPow(x float64, n int) float64 { // 方法二：递归！！！
    if n >= 0 {
        return binaryPower(x, n)
    } else {
        return 1.0 / binaryPower(x, -n)
    }
}

func binaryPower(x float64, n int) float64 {
    if n == 0 {
        return 1.0 // 递归左右出口！！！
    }
    
    y := binaryPower(x, n/2) // 前一个乘除！！！
    
    if n % 2 == 0 { // 判断奇数次方还是偶数次方！！！
        return y * y
    } else {
        return y * y * x
    }
}