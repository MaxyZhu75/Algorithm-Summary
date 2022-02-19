class Solution { // 方法一：试除法（另一方法见Go语言版本答案）！！！
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n%3 == 0) { // 3的幂每次除3不会有余数；负数及0不是3的幂不会进入循环！！！
            n /= 3;   
        }
        return n == 1; 
    }
}