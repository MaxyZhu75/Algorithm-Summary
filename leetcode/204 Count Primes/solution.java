class Solution {
    public int countPrimes(int n) { // 该方法为经典埃氏筛，还有更快的线性筛！！！
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i=2; i<n; i++) {
            if (isPrime[i]) {
                count++;
            }
            for(long j=(long)i*i; j<n; j+=i) { // 要点:从i*i开始，循环对i的倍数标记notPrime！！！
                isPrime[(int)j] = false; // 做题时若发现溢出要思考数据是否需要转型；该题用Go语言更方便！！！
            }
        }

        return count;
    }
}