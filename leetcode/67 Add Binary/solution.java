class Solution {
    public String addBinary(String a, String b) {
        int p1 = a.length()-1;
        int p2 = b.length()-1; // Ҫ��һ��ָ��Ӻ���ǰ���϶����ƴӵ�λ��ӵ�ģ�⣡����
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (p1 >= 0 || p2 >= 0 || carry == 1) {
            int sum = carry;
            sum += p1 < 0 ? 0 : a.charAt(p1)-'0'; // java���ַ�������ȡ�����ַ�����ĸ�ַ��󣬼���Ӧ�ġ�0����a������ת���֣�����
            sum += p2 < 0 ? 0 : b.charAt(p2)-'0';
            carry = sum/2; // Ҫ�������������ѧ���㣡����
            sb.append(sum % 2); // ��λ = (carry+a+b)/2����ǰbit = (carrry+a+b)%2������
            p1--;
            p2--;
        }

        return sb.reverse().toString();
    }
}