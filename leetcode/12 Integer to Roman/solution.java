class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; // �ɴ�С�洢���п��õĻ������ּ���Ӧ�ַ�������
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; // ע������������������Ҫ��Ӧ������

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<values.length; i++) { // ̰�ĵشӴ�С�������õ����֣�����
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
            if (num == 0) { // �����ɣ����ڣ�����
                break;
            }
        }
        return sb.toString();
    }
}