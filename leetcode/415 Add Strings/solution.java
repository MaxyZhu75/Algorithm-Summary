class Solution {
    public String addStrings(String num1, String num2) { // ָ��Ӻ���ǰ����ʮ���ƴӵ�λ��ӵ�ģ�⣻��LeetCode67�����ƣ�����
        int p1 = num1.length()-1, p2 = num2.length()-1;
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();

        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            int a = (p1 < 0) ? 0 : num1.charAt(p1)-'0'; // java���ַ�������ȡ�����ַ�����ĸ�ַ��󣬼���Ӧ�ġ�0����a������ת���֣�����
            int b = (p2 < 0) ? 0 : num2.charAt(p2)-'0';
            int sum = (a + b + carry) % 10; // ��λ = (carry+a+b)/2����ǰbit = (carrry+a+b)%2������
            carry = (a + b + carry) / 10;
            sb.append(sum);
            p1--;
            p2--;
        }

        return sb.reverse().toString();
    }
}