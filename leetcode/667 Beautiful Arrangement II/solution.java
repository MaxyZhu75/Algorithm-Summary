class Solution {
    public int[] constructArray(int n, int k) { // 让前k+1个元素构建出k个不相同的差值，序列为：1, k+1, 2, k, 3, k-1, ... , k/2, k/2+1, k+2, k+3, ... , n-1, n ！！！
        int[] result = new int[n];
        result[0] = 1;
        for (int i=1, difference=k; i<=k; i++, difference--) { // 前k+1个数交叉构造！！！
            result[i] = (i % 2 == 1) ? result[i-1]+difference : result[i-1]-difference;
        }
        for (int i=k+1; i<n; i++) { // 剩余的数顺序填满！！！
            result[i] = i+1;
        }
        return result;
    }
}