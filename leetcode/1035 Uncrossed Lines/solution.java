class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) { // Ҫ�㣺����ȼ���LeetCode1143��������������⣡����
        int n = nums1.length;
        int m = nums2.length;
        int[][] d = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    d[i][j] = d[i-1][j-1] + 1; // case1����λ�������ַ�����ĸƥ�䣡����
                } else {
                    d[i][j] = Math.max(d[i][j-1], d[i-1][j]); // case2����λ�������ַ�����ƥ�䣡����
                }
            }
        }
        return d[n][m];
    }
}