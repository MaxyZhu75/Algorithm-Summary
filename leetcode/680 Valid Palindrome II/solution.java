class Solution {
    public boolean validPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length()-1;
        while (p1 < p2) {
            if (s.charAt(p1) == s.charAt(p2)) { // case1：如果s是回文，则循环结束时返回true！！！
                p1++;
                p2--;
            } else { // case2：由于题目表示可以删除一个字符，若出现一次不相等，则还可以调用isPalindrome判断剩下的部分是否严格是回文（不能再次删除字母）！！！
                return isPalindrome(s, p1+1, p2) || isPalindrome(s, p1, p2-1); // 删除的字符有两种情况，删除后若有一种满足回文即可，此处直接return或运算结果！！！
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) { // 与回文有关的题目常常需要定义该方法，需要熟练掌握！！！
        int p1 = i;
        int p2 = j;
        while (p1 < p2) {
            if ( s.charAt(p1) == s.charAt(p2) ) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }
        return true;
    }
}