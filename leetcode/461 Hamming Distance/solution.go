func hammingDistance(x int, y int) int {
    var n int = x ^ y
    result := 0
    for (n != 0) {
        n = n&(n-1)  // ��n&(n-1)���������n�����Ʊ�ʾ�����λ��1�����⼴����x��y���Ľ��n��Ҫ�������ٸ�1���ɣ��൱��java.lang.Integer.bitCount(x^y)������
        result++
    }
    return result
}