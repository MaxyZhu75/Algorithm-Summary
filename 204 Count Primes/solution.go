func countPrimes(n int) int { // 该方法为经典埃氏筛，还有更快的线性筛！！！
    isPrime := make([]bool, n)
    count := 0
    for i, _ := range isPrime {
        isPrime[i] = true
    }
    for i:=2; i<n; i++ {
        if isPrime[i] {
            count++
        }
        for j:=i*i; j<n; j+=i { // 要点:从i*i开始，循环对i的倍数标记notPrime！！！
            isPrime[j] = false // 做题时若发现溢出要思考数据是否需要转型；该题用Go语言更方便！！！
        }
    }

    return count
}