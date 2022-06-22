class Solution {
    public List<Integer> grayCode(int n) { // 格雷码公式！！！
        List<Integer> result = new ArrayList<>();
        for (int i=0; i < (1<<n); i++) {
            result.add((i>>1) ^ i); // 公式:「g(i)=b(i+1)⊕b(i)」；b(i)为当前二进制数的第i+1位！！！
        }
        return result;
    }
}