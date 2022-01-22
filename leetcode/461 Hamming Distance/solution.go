func hammingDistance(x int, y int) int {
    var n int = x ^ y
    result := 0
    for (n != 0) {
        n = n&(n-1)  // 做n&(n-1)运算可消除n二进制表示中最低位的1，本题即计算x与y异或的结果n需要消除多少个1即可，相当于java.lang.Integer.bitCount(x^y)！！！
        result++
    }
    return result
}