class Solution {
    public int removePalindromeSub(String s) {
        if ( isPalindrome(s, 0, s.length()-1) ) { // 本题目关键看清楚两个定义（子序列，回文）即可轻而易举地解决；请注意是子序列，而非连续子序列！！！
            return 1;
        } else {
            return 2;
        }
    }

    public boolean isPalindrome(String s, int i, int j) { // 与回文有关的题目常常需要定义该方法，需要熟练掌握！！
        int p1 = i;
        int p2 = j;
        while (p1 < p2) {
            if (s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }
        return true;
    }
}