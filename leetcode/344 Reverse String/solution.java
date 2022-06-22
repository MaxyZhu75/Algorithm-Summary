class Solution {
    public void reverseString(char[] s) { // 双指针！！！
        for (int left = 0, right = s.length-1; left<right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}