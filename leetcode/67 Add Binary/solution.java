class Solution {
    public String addBinary(String a, String b) {
        int p1 = a.length()-1;
        int p2 = b.length()-1; // 要点一：指针从后往前符合二进制从低位相加的模拟！！！
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            int sum = carry;
            sum += p1 < 0 ? 0 : a.charAt(p1)-'0'; // java从字符串中提取数字字符或字母字符后，减相应的‘0’或‘a’即会转数字！！！
            sum += p2 < 0 ? 0 : b.charAt(p2)-'0';
            carry = sum/2; // 要点二：二进制数学运算！！！
            sb.append(sum % 2); // 进位 = (carry+a+b)/2；当前bit = (carrry+a+b)%2！！！
            p1--;
            p2--;
        }

        return sb.reverse().toString();
    }
}