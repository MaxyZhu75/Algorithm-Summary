class Solution {
    public int longestValidParentheses(String s) { // 贪心 + 「正向逆向结合」！！！
        int left = 0, right = 0; // 统计左右括号数量！！！
		int result = 0;
        for (int i=0; i<s.length(); i++) { // 正向！！！
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) { // case1：左右括号数量相等，尝试更新计算最长有效括号的长度！！！
                result = Math.max(result, left+right);
            } else if (right > left) { // case2：右括号多于左括号，皆重置为0！！！
                left = 0;
				right = 0;
            } // case3：左括号多于右括号，不作显示处理！！！
        }

        left = 0;
		right = 0;
        for (int i=s.length()-1; i >= 0; i--) { // 逆向；防止漏掉正向遍历时左括号始终多于右括号导致无法统计结果的情况！！！
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left+right);
            } else if (left > right) {
                left = 0;
				right = 0;
            }
        }
        return result;
    }
}