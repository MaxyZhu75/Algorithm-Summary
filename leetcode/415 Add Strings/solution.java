class Solution {
    public String addStrings(String num1, String num2) { // 指针从后往前符合十进制从低位相加的模拟；与LeetCode67题类似！！！
        int p1 = num1.length()-1, p2 = num2.length()-1;
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();

        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            int a = (p1 < 0) ? 0 : num1.charAt(p1)-'0'; // java从字符串中提取数字字符或字母字符后，减相应的‘0’或‘a’即会转数字！！！
            int b = (p2 < 0) ? 0 : num2.charAt(p2)-'0';
            int sum = (a + b + carry) % 10; // 进位 = (carry+a+b)/2；当前bit = (carrry+a+b)%2！！！
            carry = (a + b + carry) / 10;
            sb.append(sum);
            p1--;
            p2--;
        }

        return sb.reverse().toString();
    }
}