class Solution {
    public boolean isPalindrome(String s) { // 双指针；无需额外空间！！！
        int n = s.length();
        int left = 0, right = n-1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) { // 每次循环先将左右指针移至字母或数字停下！！！
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) { // 若左右指针未重叠交叉，则进行比较！！！
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}