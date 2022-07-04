class Solution {
    char[] s;

    public List<Integer> diffWaysToCompute(String expression) {
        this.s = expression.toCharArray();
        return dfs(0, expression.length()-1);
    }

    public List<Integer> dfs(int left, int right) { // 递归计算「操作符」左右两边值的组合！！！
        List<Integer> result = new ArrayList<>();
        for (int i=left; i<=right; i++) {
            if (Character.isDigit(s[i])) continue; //「数字」需要先跳过！！！
            List<Integer> values1 = dfs(left, i-1);
            List<Integer> values2 = dfs(i+1, right);
            for (int val1 : values1) { // 递归「操作符」左右两边的值，并计算！！！
                for (int val2 : values2) {
                    int current = 0;
                    switch (s[i]) {
                        case '+':
                            current = val1 + val2;
                            break;
                        case '-':
                            current = val1 - val2;
                            break;
                        default:
                            current = val1 * val2;
                            break;
                    }
                    result.add(current);
                }
            }
        }
        if (result.isEmpty()) { // result若为空则为纯数字，统计数字加入即可！！！
            int num = 0;
            for (int i=left; i<=right; i++) {
                num = num * 10 + (s[i]-'0');
            }
            result.add(num);
        }
        return result;
    }
}