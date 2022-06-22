class Solution {
    public int numTrees(int n) { // 动态规划推导；正确性见官方题解！！！
        int[] G = new int[n+1]; // 长度为n的序列能构成的不同二叉搜索树的个数！！！
        G[0] = 1;
        G[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) { // F(i,j) = G[j-1]*G[i-j] 可表示以j为根、以i为序列长度的不同二叉搜索树个数！！！
                G[i] += G[j-1] * G[i-j]; // 转移方程：G[i] = sum{G[j-1]*G[i-j]} 其中sum表示j由1到i累加！！！
            }
        }
        return G[n];
    }
}