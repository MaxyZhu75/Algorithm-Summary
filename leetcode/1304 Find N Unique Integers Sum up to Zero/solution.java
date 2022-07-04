class Solution {
    public int[] sumZero(int n) { // [0], [-1,1], [-1,1,0], [-2,-1,1,2], [-2,-1,-1,2,0]......！！！
        int[] A = new int[n]; // 细节：n为奇数时数组末尾为初始化元素0！！！
        int index = 0;
        for (int i=1; i<=n/2; i++) { // 细节：注意循环由1到n/2！！！
            A[index++] = -i;
            A[index++] = i;
        }
        return A;
    }
}