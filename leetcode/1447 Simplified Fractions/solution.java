class Solution {
    public List<String> simplifiedFractions(int n) { // 本题关键在于判断是否为最简分数，不能靠记录已出现的i/j，因为“/”运算结果都仅是整除！！！
        List<String> result = new ArrayList<>();
    
        for (int i=2; i<=n; i++) {
            for (int j=1; j<i; j++) {
                StringBuilder sb = new StringBuilder();
                if (gcd(j, i) == 1) { // 正确判断方法：分子分母最大公约数为1，则该分数为最简分数；然后从小到大暴力遍历即可！！！
                    sb.append(j);
                    sb.append("/");
                    sb.append(i);
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    public int gcd(int a, int b) { // Greatest Common Divisor递归写法！！！
        return b == 0 ? a : gcd(b, a%b);
    }
}