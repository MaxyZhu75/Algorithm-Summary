class Solution {
    public boolean isPalindrome(int x) { // 要求不能将数字转化为字符串！！！
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false; // 注意非0且个位为0的数不是回文数！！！

        int right = 0;
        while (x > right) { // 要点：将该数分为左右两部分，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了！！！
            right = right * 10 + x % 10;
            x /= 10;
        }

        return x == right || x == right/10; // 位数为奇数或偶数！！！
    }
}