class Solution {
    int n;
    String digits;
    int target;
    List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) { // 回溯！！！
        this.n = num.length();
        this.digits = num;
        this.target = target;
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, 0, 0);
        return result;
    }

    public void backtrack(StringBuilder sb, int start, long curVal, long mulVal) {
        if (start == n) {
            if (curVal == target) {
                result.add(sb.toString());
            }
            return;
        }
        int signIndex = sb.length(); // 细节：记录「递归拼接」及「回溯」的位置！！！
        if (start > 0) {
            sb.append('#'); // 细节：占位，下面填充符号！！！
        }
        long num = 0; // 运算的操作数也需要枚举；但注意数字可以是单个0，不能有前导零！！！
        for (int i=start; i<n && (i==start || digits.charAt(start)!='0'); i++) {
            num = num * 10 + digits.charAt(i)-'0';
            sb.append(digits.charAt(i));
            if (start == 0) { // 表达式开头不能添加符号！！！
                backtrack(sb, i+1, num, num);
            } else { // 枚举操作符！！！
                sb.setCharAt(signIndex, '+');
                backtrack(sb, i+1, curVal+num, num);
                sb.setCharAt(signIndex, '-');
                backtrack(sb, i+1, curVal-num, -num);
                sb.setCharAt(signIndex, '*');
                backtrack(sb, i+1, curVal-mulVal+mulVal*num, mulVal*num); // 细节：mulVal为表达式最后一个连乘串的计算结果！！！
            }
        }
        sb.setLength(signIndex); // 回溯删除末尾部分！！！
    }
}